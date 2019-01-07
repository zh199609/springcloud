package com.zl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//开启eureka server  启动类，接受其他服务注册进来
@EnableEurekaServer
public class EurekaServer_7001App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001App.class,args);
    }
}
