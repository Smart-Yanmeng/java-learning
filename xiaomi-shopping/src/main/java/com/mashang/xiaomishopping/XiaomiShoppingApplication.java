package com.mashang.xiaomishopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.mashang.xiaomishopping.filter")
@MapperScan("com.mashang.**.dao")
public class XiaomiShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaomiShoppingApplication.class, args);
    }

}
