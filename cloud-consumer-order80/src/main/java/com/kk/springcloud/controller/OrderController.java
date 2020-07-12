package com.kk.springcloud.controller;

/*
@author kzj
@date 2020/7/11 - 14:25
*/

import com.kk.springcloud.entity.CommonResult;
import com.kk.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    // 单机版
//    private static final String PAYMENT_URL = "http://localhost:8001";

    // 多服务提供者时，服务调用不能写死，要根据应用名来调用
    private static final String PAYMENT_URL = "http://cloud-payment-service";



    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create" ,payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

}


















