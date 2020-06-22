package com.qiuhang.myrule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.myrule
 * @ClassName: MyRule
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/15 13:51
 * @Version: 1.0
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
