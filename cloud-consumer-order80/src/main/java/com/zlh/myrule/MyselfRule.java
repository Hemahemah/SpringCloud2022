package com.zlh.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lh
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        // 定义为随机
        return new RandomRule();
    }
}
