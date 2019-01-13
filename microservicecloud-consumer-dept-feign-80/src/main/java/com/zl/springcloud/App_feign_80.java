package com.zl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//在该微服务启动的时候就能去加载我们自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name = "MICROSERVIERCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
//由于Service是单独编译一个jar包，那么在使用@EnableFeignClients注解时需要指定basePackages的值
@EnableFeignClients(basePackages = "com.zl.springcloud.service")
public class App_feign_80 {
    public static void main(String[] args) {
        SpringApplication.run(App_feign_80.class, args);
    }
}
