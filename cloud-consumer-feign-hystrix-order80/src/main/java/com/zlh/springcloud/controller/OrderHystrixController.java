package com.zlh.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zlh.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentFallbackMethod")
public class OrderHystrixController {

    @Resource
    private OrderService orderService;

    @GetMapping("/payment/consumer/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return orderService.paymentInfoOk(id);
    }

    @GetMapping("/payment/consumer/hystrix/timeout/{id}")
    /**
     * 错误访问
     * @param id id
     * @return string
     */
   /* @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties ={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5900")
    })*/
    @HystrixCommand
    public String paymentInfoTimeout(Integer id){
        return orderService.paymentInfoTimeout(id);
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "80,线程池:" + Thread.currentThread().getName() +
                " paymentInfoTimeoutHandler,Id:" + id + " o(╥﹏╥)o";

    }

    /**
     * 全局fallback
     */
    public String paymentFallbackMethod(){
        return "Global异常处理信息，请稍后再试";
    }
}
