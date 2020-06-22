package com.qiuhang.springcloud.service.impl;

import com.qiuhang.springcloud.dao.PaymentDao;
import com.qiuhang.springcloud.entity.Payment;
import com.qiuhang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.service.impl
 * @ClassName: PaymentServiceImpl
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/10 10:04
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
