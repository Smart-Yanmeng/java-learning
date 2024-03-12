package com.mashang.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.mashang.study.filter")
@MapperScan("com.mashang.**.dao")
public class StudyApplication {

  public static void main(String[] args) {
    SpringApplication.run(StudyApplication.class, args);
  }

}
