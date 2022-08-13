package com.zlh.springcloud.service;

import com.zlh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lh
 */
public interface PaymentService {

    /**
     * create
     * @param payment payment
     * @return int
     */
    int create(Payment payment);

    /**
     * get
     * @param id id
     * @return payment
     */
    Payment getPaymentById(@Param("id") Long id);
}
