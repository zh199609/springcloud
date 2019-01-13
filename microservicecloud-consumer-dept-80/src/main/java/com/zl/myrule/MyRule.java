package com.zl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {


    public IRule myRuleArithmetic2(){
        return new RandomRule();//随机
    }

    @Bean
    public IRule myRuleArithmetic3(){
        return new MyRandomRule();//5次切换  -轮询
    }
}
