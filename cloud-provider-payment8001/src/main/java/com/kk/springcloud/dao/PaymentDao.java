package com.kk.springcloud.dao;

/*
@author kzj
@date 2020/7/11 - 12:51
*/

import com.kk.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
