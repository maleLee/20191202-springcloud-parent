package com.aaa.lee.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 15:04
 * @Description
 * @EnableEurekaServer:
 *      在eureka服务器端所配置的注解
 * @EnableDisconveryClinet:
 *      在eureka的客户端所需要配置的注解
 * @EnableEurekaClinet:
 *      在springcloud1.x版本的时候所使用的客户端注解，在2.x版本之后被废弃
 **/
@SpringBootApplication
@MapperScan("com.aaa.lee.springcloud.mapper")
@EnableDiscoveryClient
public class ApplicationRun8081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class, args);
    }

}
