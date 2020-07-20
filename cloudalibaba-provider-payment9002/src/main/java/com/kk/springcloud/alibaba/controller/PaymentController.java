package com.kk.springcloud.alibaba.controller;

/*
@author kzj
@date 2020/7/18 - 15:27
*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getpayment(@PathVariable("id") Integer id) {
        return "nacos registry,serverPort:" + serverPort + "\t" + "id:" + id;
    }
}
