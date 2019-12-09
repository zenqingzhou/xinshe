package com.xinshe.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zengqingzhou on 2019/6/29 10:58
 */
@SpringBootApplication
//@ComponentScan("com.xinshe.web")
public class WebApplicationServer {
    public static void main(String[] args) {
        SpringApplication.run(
                WebApplicationServer.class, args
        );
    }
}
