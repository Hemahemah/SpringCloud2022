package com.zlh.springcloud.dao;

import com.zlh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lh
 */
@Mapper
public interface PaymentDao {

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
