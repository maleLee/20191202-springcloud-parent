package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/4 16:06
 * @Description
 *      所谓的服务发现，就必须先从注册中心里查询provider是否存在
 *      consumer直接使用eureka的Application的值来进行调用provider
 *      Application的值就是provider项目中的spring.application.name的值(不是)
 *          eureka中Application的值是大写，但是spring.application.name的值是小写
 *          不要使用spring.application.name的值因为调不到
 *
 **/
@RestController
public class BookController {

    // private static final String URL = "http://localhost:8081/all";
    private static final String URL = "http://BOOK-PROVIDER/all";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return restTemplate.getForObject(URL, List.class);
    }

    /**
     * @author Seven Lee
     * @description
     *      如果ribbon一旦脱离了eureka，ribbon只能运行在真实环境中，不能再使用localhost进行映射
     *      内网穿透:
     *          花生壳
     *      如果以后你们进入到工作中，需要找我调bug，必须要下载teamviewer
     * @param []
     * @date 2019/12/5
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/allLB")
    public List<Book> selectAllBooksLB() {
        // 如果需要实现负载均衡，就必须要知道所有provider的ip和端口号
        // 1.获取所有provider的IP地址和端口号(通过ribbon来进行获取)
        // 通过spring.application.name的值进行选择
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-provider");
        // 2.获取host信息
        String host = serviceInstance.getHost();
        // 3.获取port信息
        int port = serviceInstance.getPort();
        System.out.println(port);
        // 4.使用restTemplate进行远程调用
        return restTemplate.getForObject("http://"+host+":"+port+"/all", List.class);
    }

}
