package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 14:58
 * @Description
 **/
@RestController
public class BookController {

    private static final String PROVIDER_URL = "http://localhost:8081/all";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @author Seven Lee
     * @description
     *      查询所有的图书信息
     * @param []
     * @date 2019/12/2
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws 
    **/
    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return restTemplate.getForObject(PROVIDER_URL, List.class);
    }

}
