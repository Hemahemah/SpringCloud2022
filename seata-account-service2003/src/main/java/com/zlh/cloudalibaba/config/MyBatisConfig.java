package com.zlh.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lh
 */
@Configuration
@MapperScan("com.zlh.cloudalibaba.dao")
public class MyBatisConfig {
}
