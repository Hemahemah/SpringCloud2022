package com.atguigu.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lh
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelMainApp8401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelMainApp8401.class, args);
    }
}
