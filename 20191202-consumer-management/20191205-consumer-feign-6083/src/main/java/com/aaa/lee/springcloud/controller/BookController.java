package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/5 16:45
 * @Description
 *      dubbo实现方式:
 *          consumer中声明service层的接口
 *          provider中声明service接口和实现类
 *          其实consumer的service层接口最终会被provider的service层的实现类所注入
 *
 *      因为在springcloud2.x版本之后只能有一个接口，但是springcloud1.x版本可以有很多个
 *      接口的名字必须要规范
 *          ---> ISpringcloudService(我的个人习惯)
 *          ---> IOrerService
 *
 *
 *
 **/
@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return bookService.selectAllBooks();
    }

}
