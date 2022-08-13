package com.zlh.springcloud.controller;

import com.zlh.springcloud.entities.CommonResult;
import com.zlh.springcloud.entities.Payment;
import com.zlh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author lh
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果,{}", result);
        if (result > 0){
            return new CommonResult<>(200, "success,serverPort:"+serverPort, result);
        }else {
            return new CommonResult<>(400, "fail", result);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> get(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果,{}", payment);
        if (payment != null){
            return new CommonResult<>(200, "success,serverPort:"+serverPort, payment);
        }else {
            return new CommonResult<>(400, "fail", payment);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }
}
