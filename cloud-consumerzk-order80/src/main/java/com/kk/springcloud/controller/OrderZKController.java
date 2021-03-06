package com.kk.springcloud.controller;

/*
@author kzj
@date 2020/7/12 - 17:53
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-payment-com.kk.springcloud.service";

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk", String.class);
        return result;
    }

}
