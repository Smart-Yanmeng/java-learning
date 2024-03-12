package com.springboottest.springboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication // springboot
@MapperScan("com.springboottest.**.dao") // 配置扫描的 dao
@ServletComponentScan("com.springboottest.springboot01.filter") // 配置扫描的 filter
public class Springboot01Application {

  public static void main(String[] args) {
    SpringApplication.run(Springboot01Application.class, args);
  }

}
