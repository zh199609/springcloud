package com.zl.config;


import com.github.qcloudsms.SmsSingleSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author
 * @Description
 * @Date
 */
@Configuration
public class CreateSmsSingleSender {

    @Autowired
    private MessageConfig messageConfig;

    @Bean
    public SmsSingleSender smsSingleSender(MessageConfig messageConfig){
        return new SmsSingleSender(messageConfig.getAppId(), messageConfig.getAppKey());
    }
}
