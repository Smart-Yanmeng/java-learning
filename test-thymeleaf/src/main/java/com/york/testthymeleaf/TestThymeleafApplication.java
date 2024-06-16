package com.york.testthymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.york.testthymeleaf.mapper")
@SpringBootApplication
public class TestThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestThymeleafApplication.class, args);
    }

}
