package com.qiuhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud
 * @ClassName: PaymentMain8001
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/9 16:54
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class);
    }
}
