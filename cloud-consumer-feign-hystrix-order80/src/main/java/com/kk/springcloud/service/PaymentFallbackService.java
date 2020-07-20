package com.kk.springcloud.service;

import org.springframework.stereotype.Component;

/*
@author kzj
@date 2020/7/15 - 20:10
*/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------------PaymentFallbackService------------------OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------------PaymentFallbackService------------------TimeOut";
    }

}
