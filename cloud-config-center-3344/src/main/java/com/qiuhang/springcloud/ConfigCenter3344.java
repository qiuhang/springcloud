package com.qiuhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/28 15:12
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class);
    }
}
