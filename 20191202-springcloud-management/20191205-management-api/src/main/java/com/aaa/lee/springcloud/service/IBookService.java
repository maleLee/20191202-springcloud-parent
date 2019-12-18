package com.aaa.lee.springcloud.service;

import com.aaa.lee.springcloud.factory.IBookServiceFallBackFactory;
import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.model.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/5 16:50
 * @Description
 *      无论什么时候要远程调用，都必须要知道provider的ip地址和端口号
 *      @FeignClient:就实现了远程调用
 *          value:其实就是provider项目中spring.application.name的值
 *              这里可以任意写(可以使用大写，也可以使用小写)
 *      !!!!!!!!!注意:
 *          当使用feign的时候，必须要注意注解方式必须要和provider保持一致(GetMapping)，注解中的值也必须要一模一样(包括大小写)
 *          方法名以及方法的参数都必须一模一样(包括参数的个数以及参数的类型)
 *          返回值也必须一模一样
 **/
@FeignClient(value = "book-provider", fallbackFactory = IBookServiceFallBackFactory.class)
public interface IBookService {

    @GetMapping("/all")
    List<Book> selectAllBooks();

    /*@GetMapping("/cartAll")
    List<Cart> selectAllCarts();*/

}
