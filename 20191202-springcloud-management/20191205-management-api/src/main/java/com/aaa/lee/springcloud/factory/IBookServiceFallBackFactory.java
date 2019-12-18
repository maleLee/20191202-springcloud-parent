package com.aaa.lee.springcloud.factory;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.IBookService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/6 16:38
 * @Description
 *      对于IBookService层的所有抽象方法做熔断处理
 *      也就是说该类中必须要重写IBOOKService接口中的所有的抽象方法
 *      1.把该类标识类spring的组件类
 *      2.实现FallbackFactory的接口，需要传入一个泛型(IBookService接口)
 *      3.重写create方法(返回值是IBookService接口)
 *      4.创建该接口对象
 **/
@Component
public class IBookServiceFallBackFactory implements FallbackFactory<IBookService> {
    @Override
    public IBookService create(Throwable throwable) {
        // 创建IBookService对象
        IBookService bookService = new IBookService() {
            @Override
            public List<Book> selectAllBooks() {
                // 熔断方法
                System.out.println("我暂时被停止服务，降级了！");
                return null;
            }
        };
        return bookService;
    }
}
