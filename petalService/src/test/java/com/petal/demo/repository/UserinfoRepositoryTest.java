package com.petal.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserinfoRepositoryTest {

    @Autowired
    private UserinfoRepository userinfoRepository;

    @Test
    void finAll(){
        System.out.println(userinfoRepository.findAll());
    }

    @Test
    void check(){
        String url="http://technologyx.cn/images/cover/3014200.jpg";
        String[] p =url.split("/");
        System.out.println(p.length);
        System.out.println(p[3]);
    }
}