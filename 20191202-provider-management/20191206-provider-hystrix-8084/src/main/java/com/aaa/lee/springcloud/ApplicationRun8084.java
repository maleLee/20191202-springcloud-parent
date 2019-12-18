package com.aaa.lee.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/6 15:43
 * @Description
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aaa.lee.springcloud.mapper")
@EnableCircuitBreaker
public class ApplicationRun8084 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8084.class, args);
    }

}
