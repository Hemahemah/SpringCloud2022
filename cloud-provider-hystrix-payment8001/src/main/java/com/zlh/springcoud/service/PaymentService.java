package com.zlh.springcoud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id id
     * @return string
     */
    public String paymentInfoOk(Integer id){
        return "线程池:" + Thread.currentThread().getName() +
                " paymentInfoOk,Id:" + id + " O(∩_∩)O哈哈~";
    }

    /**
     * 错误访问
     * @param id id
     * @return string
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties ={
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() +
                " paymentInfoTimeout,Id:" + id + " O(∩_∩)O哈哈~" + " 耗时"+time+"s";
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() +
                " paymentInfoTimeoutHandler,Id:" + id + " o(╥﹏╥)o";

    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //最小请求次数
            //短路多久以后开始尝试是否恢复，默认5s
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")  //失败率达到多少后跳闸
    })   //总的意思就是在n毫秒内的时间窗口期内，m次请求中有p%的请求失败了，那么断路器启动
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();  //等价于UUID.randomUUID().toString()

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
