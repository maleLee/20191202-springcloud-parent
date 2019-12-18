package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/6 15:45
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @author Seven Lee
     * @description
     *      单纯的使用hystrix的情况下，也就是说一个controller中的方法就必须要对应一个后备方法
     *      这么一来整个controller就会非常非常的臃肿
     *      涉及到原则问题：
     *          在java中因为是面向对象的思想，所以每一个类的职责要单一化
     *          因为该类为controller，只需要做控制跳转，但是现在写了后备方法，职责就不单一
     *      使用封装的方式来实现每个类的职责单一化
     * @param []
     * @date 2019/12/6
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/all")
    // @HystrixCommand(fallbackMethod = "selectAllFallBack")
    public List<Book> selectAllBooks() throws Exception {
        /**
         * 假设如果selectAllBooks方法抛出异常(运行时异常)
         * 因为mysql数据库中有数据，所以bookList永远长度大于0，所以也就是说这个方法一定会抛异常
         */
        List<Book> bookList = bookService.selectAllBooks();
        if(bookList.size() > 0) {
            // 说明数据库中有数据
            throw new Exception("我是异常，故意抛出！");
        }
        return null;
    }

    /**
     * @author Seven Lee
     * @description
     *      该方法是selectAllBooks方法的后备方法！！
     * @param []
     * @date 2019/12/6
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws 
    **/
    /*public List<Book> selectAllFallBack() {
        *//**
         * 该方法就是永远可以返回正常结果，这个结果客户端还可以接受
         * 也就是说后备方法一定永远都可以要正常运行
         *//*
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book();
        book.setBookName("熔断测试图书名称");
        bookList.add(book);
        return bookList;
    }*/

    public static void main(String[] args) {
        System.out.println(1/0);
    }

}
