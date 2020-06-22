package com.qiuhang.springcloud.controller;

import com.qiuhang.springcloud.entity.CommonResult;
import com.qiuhang.springcloud.entity.Payment;
import com.qiuhang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.controller
 * @ClassName: PaymentController
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/10 10:07
 * @Version: 1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if (i>0){
            return new CommonResult(200,"插入成功",i);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment.getSerial());
        if (payment!=null){
            return new CommonResult(200,port+"查询成功",payment);
        }else {
            return new CommonResult(444,"未查到数据");
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return port;
    }


    @GetMapping(value = "feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return port;
    }
}
