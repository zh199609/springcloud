package com.zl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//服务发现
@EnableHystrix//对hystrix熔断机制的支持
public class App_hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(App_hystrix_8001.class, args);
    }
}
