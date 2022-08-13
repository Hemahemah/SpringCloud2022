package com.zlh.cloudalibaba.controller;

import com.zlh.cloudalibaba.domain.CommonResult;
import com.zlh.cloudalibaba.domain.Order;
import com.zlh.cloudalibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lh
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
