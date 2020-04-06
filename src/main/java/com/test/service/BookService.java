package com.test.service;

import com.test.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookService {

//    @Qualifier("bookDao2")
//    @Autowired
//    @Resource
    @Inject
    private BookDao bookDao;

    public void print(){
        System.out.println("-----------------"+bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
