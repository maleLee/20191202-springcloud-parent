package com.aaa.lee.springcloud;

import com.aaa.lee.rule.MineRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/4 15:55
 * @Description
 *      ribbon也支持自定义算法:
 *          必须要使用注解来进行标识@RibbonClinet()，就是当八种算法无法满足业务的时候，可以自己自定义算法配置类
 *          name:
 *              负载均衡请求provider，现在又三台，必须要使用eureka的Application的值，也就是说必须要让自定义算法针对于某些provider生效，并不是所有
 *          configuration
 *              声明的负载均衡算法配置类
 **/
@SpringBootApplication
@EnableDiscoveryClient
// @RibbonClient(name = "BOOK-PROVIDER", configuration = MineRule.class)
public class ApplicationRun6082 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6082.class, args);
    }

}
