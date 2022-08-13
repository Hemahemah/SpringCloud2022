package com.zlh.cloudalibaba.service.impl.impl;

import com.zlh.cloudalibaba.dao.OrderDao;
import com.zlh.cloudalibaba.domain.Order;
import com.zlh.cloudalibaba.service.AccountService;
import com.zlh.cloudalibaba.service.OrderService;
import com.zlh.cloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author lh
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->新建订单");
        orderDao.create(order);
        log.info("----->订单微服务调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->账户微服务调用，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("----->新建订单结束");
    }

    @Override
    public void insert(Order order) {

    }
}
