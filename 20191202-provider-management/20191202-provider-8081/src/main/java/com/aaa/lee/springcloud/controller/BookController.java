package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 15:06
 * @Description
 *      虽然现实使用@Controller也可以让consumer直接调用到provider
 *      但是强制要求使用@RestController
 *      也就是说以后所有的provider都必须使用@RestController，以后@Controller就不能用了(Feign)
 *
 *      provider中的Controller中的GetMapping/PostMapping，一定要和consumer中restTemplate中的方法保持一致
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return bookService.selectAllBooks();
    }

}
