package com.aaa.lee.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/4 16:05
 * @Description
 *      如果需要实现负载均衡，只需要在RestTemplate的bean上添加一个注解@LoadBalanced
 *      这种负载均衡的模式默认使用的是轮询
 *
 *      ribbon中一共提供了八种负载均衡的算法，如果自己公司的业务无法使用这八种算法，也可以进行自定义(写自定义算法)
 *      其中有四种是最常用的:
 *          BestAvailableRule:
 *              选择一个最小的并发服务
 *              8081
 *              8082
 *              8083
 *              8081--->100
 *              8082--->150
 *              8083--->99
 *              当负载均衡的时候会选择8083，因为8083上的并发是最小的
 *
 *          RetryRule:
 *              重新连接
 *              8081
 *              8082
 *              8083
 *              客户端发送请求到达了consumer了--->consumer就要请求provider(8081,8082,8083)--->先请求8081，但是发现8081存活
 *              当第二次请求的时候依然请求是8081--->8081因为压力过大导致宕机
 *              当第三次请求的时候会直接请求8082跳过8081(不准确)
 *                  至于请求8081还是8082，完全取决于配置
 *                  在ribbon的配置中有auto.max....--->标识请求的次数，默认值是1-->0 直接请求8082跳过8081
 *                  第三个请求依然会去请求8081，如果8081依然宕机就会请求8082
 *          RoundRobinRule(默认的算法):
 *              就是轮询，什么说的，不明白的自杀！
 *          RandomRule:
 *              随便选(没有规律)
 **/
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public IRule mineRule() {
        return new RandomRule();
    }*/

}
