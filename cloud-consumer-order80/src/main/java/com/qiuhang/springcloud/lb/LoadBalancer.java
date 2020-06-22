package com.qiuhang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.lb
 * @ClassName: LoadBalancer
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/16 10:25
 * @Version: 1.0
 */
public interface LoadBalancer {
    /**
     * 轮训
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);

    /**
     * 随机
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance random(List<ServiceInstance> serviceInstanceList);
}
