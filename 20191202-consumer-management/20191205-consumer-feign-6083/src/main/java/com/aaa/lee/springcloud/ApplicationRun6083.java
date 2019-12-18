package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/5 16:44
 * @Description
 *      @EnableFeignClients:说明该注解是复数，可以拥有多个@FeignClient
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationRun6083 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6083.class, args);
    }

}
