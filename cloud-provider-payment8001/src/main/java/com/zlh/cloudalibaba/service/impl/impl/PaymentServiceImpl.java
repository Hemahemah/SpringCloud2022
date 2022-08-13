package com.zlh.cloudalibaba.service.impl.impl;

import com.zlh.springcloud.dao.PaymentDao;
import com.zlh.springcloud.entities.Payment;
import com.zlh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author lh
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
