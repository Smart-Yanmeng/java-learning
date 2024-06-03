package com.york.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.york.security.mapper")
public class SpringbootAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAuthenticationApplication.class, args);
    }

}
