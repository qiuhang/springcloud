package com.qiuhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud
 * @ClassName: EurekaServer7002
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/11 9:31
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class);
    }
}
