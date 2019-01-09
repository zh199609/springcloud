package com.zl.springcloud.controller;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration()
public class ConfigBean {

    @Bean
    @LoadBalanced //Spring cloud  Ribbon是基于Netflix实现的一套客户端 负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //默认的规则，轮询
    //@Bean
    public IRule myRuleArithmetic1(){
        return new RoundRobinRule();//使用随机算法
    }


}
