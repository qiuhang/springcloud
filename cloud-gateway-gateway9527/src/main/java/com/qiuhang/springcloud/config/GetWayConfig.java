package com.qiuhang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/24 11:19
 */
@Configuration
public class GetWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes=builder.routes();
        routes.route("guonei_url",r->r.path("/guonei")
                                        .uri("https://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }
}
