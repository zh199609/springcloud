package com.zl.springcloud;

import com.zl.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在该微服务启动的时候就能去加载我们自定义Ribbon配置类，从而使配置生效
@RibbonClient(name = "MICROSERVIERCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class App_80 {
    public static void main(String[] args) {
        SpringApplication.run(App_80.class,args);
    }
}
