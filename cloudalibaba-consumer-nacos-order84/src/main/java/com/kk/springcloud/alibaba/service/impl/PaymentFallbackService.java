package com.kk.springcloud.alibaba.service.impl;

/*
@author kzj
@date 2020/7/19 - 21:11
*/

import com.kk.springcloud.alibaba.service.PaymentService;
import com.kk.springcloud.entity.CommonResult;
import com.kk.springcloud.entity.Payment;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，--PaymentFallbackservice");
    }
}

