package com.kk.springcloud.alibaba.service;

/*
@author kzj
@date 2020/7/19 - 21:09
*/

import com.kk.springcloud.alibaba.service.impl.PaymentFallbackService;
import com.kk.springcloud.entity.CommonResult;
import com.kk.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback= PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
