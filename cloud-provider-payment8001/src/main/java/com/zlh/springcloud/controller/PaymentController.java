package com.zlh.springcloud.controller;

import com.zlh.springcloud.entities.CommonResult;
import com.zlh.springcloud.entities.Payment;
import com.zlh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> log.info("***element:{}",s));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(serviceInstance ->
                log.info("serverId:{},host:{},port:{},uri:{}",
                        serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort(), serviceInstance.getUri()));
    return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping("/payment/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
