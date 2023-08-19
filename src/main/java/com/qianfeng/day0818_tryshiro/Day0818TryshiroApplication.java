package com.qianfeng.day0818_tryshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qianfeng.day0818_tryshiro.dao")
public class Day0818TryshiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(Day0818TryshiroApplication.class,args);
    }
}
