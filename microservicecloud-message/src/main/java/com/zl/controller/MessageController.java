package com.zl.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.zl.config.MessageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author
 * @Description
 * @Date
 */
@RestController
public class MessageController {

    @Autowired
    private MessageConfig messageConfig;
    @Autowired
    private SmsSingleSender smsSingleSender;


    @RequestMapping("/test")
    public String sendMessage(){
        System.out.println("开始发送短信！");
        String[] params = {"5678","30"};
        try {
            SmsSingleSenderResult smsSingleSenderResult = smsSingleSender.sendWithParam("86", messageConfig.getPhoneNumber(), messageConfig.getTemplateId(), params, messageConfig.getSmsSign(), "", "");
            System.out.println("结果："+smsSingleSenderResult.toString());
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
}
