package com.zlh.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lh
 */
@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "OrderServiceImpl paymentInfoOk fallback o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "OrderServiceImpl paymentInfoTimeout fallback o(╥﹏╥)o";
    }
}
