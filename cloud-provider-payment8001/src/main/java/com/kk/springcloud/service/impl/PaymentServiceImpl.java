package com.kk.springcloud.service.impl;

import com.kk.springcloud.entity.Payment;
import com.kk.springcloud.dao.PaymentDao;
import com.kk.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2020-07-11 13:07:30
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment getPaymentById(Long id) {
        return this.paymentDao.getPaymentById(id);
    }


    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public int create(Payment payment) {
        return this.paymentDao.create(payment);
    }

}