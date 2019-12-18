package com.aaa.lee.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/4 17:10
 * @Description
 *      ribbon的负载均衡算法类一定不能放在主启动类包以及子包下(@ComponentScan)
 *      如果需要把一个类标识为配置的类的时候可以使用两个注解(@SpringBootApplication, @Configuration)
 *      但是因为@ComponentScan的缘故只能使用@Configuration注解，不能使用@SpringBootApplication注解
 **/
// @Configuration
public class MineRule {

    /*@Bean
    public IRule mineRule() {
        return new RandomRule();
    }

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = j + ++i * i++;

        int n = 1;
        int m = 2;
        System.out.println(n+++m);
    }*/

}
