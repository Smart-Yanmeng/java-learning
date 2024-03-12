package com.example.geek_navigation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.geek_navigation.mapper")
public class GeekNavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekNavigationApplication.class, args);
    }

}
