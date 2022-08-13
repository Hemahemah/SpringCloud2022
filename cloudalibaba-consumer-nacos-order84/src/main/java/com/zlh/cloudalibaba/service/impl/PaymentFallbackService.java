package com.zlh.cloudalibaba.service.impl;

import com.zlh.cloudalibaba.service.PaymentService;
import com.zlh.springcloud.entities.CommonResult;
import com.zlh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    //如果nacos-payment-consumer服务中的相应接口出事了，我来兜底
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息-------PaymentFallbackService",new Payment(id, "errorSerial......"));
    }
}
