package com.zlh.springcloud.service;

import com.zlh.springcloud.entities.CommonResult;
import com.zlh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lh
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPamentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String paymentFeignTimeout();
}
