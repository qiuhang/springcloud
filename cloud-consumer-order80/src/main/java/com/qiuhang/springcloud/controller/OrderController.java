package com.qiuhang.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.qiuhang.springcloud.entity.CommonResult;
import com.qiuhang.springcloud.entity.Payment;
import com.qiuhang.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.controller
 * @ClassName: OrderController
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/10 15:09
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderController {

    public static final String URL="http://cloud-payment-service/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("consumer/payment/getEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity =
                restTemplate.getForEntity(URL + "payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            log.info(forEntity.getStatusCodeValue()+":"+forEntity.getStatusCode());
            return forEntity.getBody();
        } else {
            return new CommonResult(444,"操作失败");
        }

    }


    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(URL+"payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(URL+"payment/get/"+id,CommonResult.class);
    }
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String name:services){
            log.info(name);

        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getHost()+","+instance.getPort()+","+instance.getUri());
        }
        return this.discoveryClient;

    }

    @GetMapping("/payment/getlb")
    public String getlb(){
        List<ServiceInstance> instances =
                discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null||instances.size()==0){
            return null;
        }
        ServiceInstance instance = loadBalancer.random(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }

}
