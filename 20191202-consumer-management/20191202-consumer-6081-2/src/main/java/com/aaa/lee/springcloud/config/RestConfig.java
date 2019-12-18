package com.aaa.lee.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 14:58
 * @Description
 **/
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
