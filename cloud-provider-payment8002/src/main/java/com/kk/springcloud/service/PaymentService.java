package com.kk.springcloud.service;

import com.kk.springcloud.entity.Payment;
import java.util.List;

/**
 * (Payment)表服务接口
 *
 * @author makejava
 * @since 2020-07-11 13:07:29
 */
public interface PaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment getPaymentById(Long id);


    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    int create(Payment payment);


}