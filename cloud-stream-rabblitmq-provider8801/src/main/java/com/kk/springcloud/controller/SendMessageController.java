package com.kk.springcloud.controller;

/*
@author kzj
@date 2020/7/18 - 10:26
*/

import com.kk.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
