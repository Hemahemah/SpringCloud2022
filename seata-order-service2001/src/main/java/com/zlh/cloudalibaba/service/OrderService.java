package com.zlh.cloudalibaba.service;

import com.zlh.cloudalibaba.domain.Order;
import org.springframework.stereotype.Service;

/**
 * @author lh
 */
public interface OrderService {

    void create(Order order);

    void insert(Order order);
}
