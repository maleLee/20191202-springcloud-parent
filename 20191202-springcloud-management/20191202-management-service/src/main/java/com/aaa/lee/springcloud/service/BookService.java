package com.aaa.lee.springcloud.service;

import com.aaa.lee.springcloud.mapper.BookMapper;
import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 15:07
 * @Description
 **/
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectAllBooks() {
        return bookMapper.selectAll();
    }

}
