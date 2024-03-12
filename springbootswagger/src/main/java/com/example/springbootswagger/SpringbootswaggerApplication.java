package com.example.springbootswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.example.springbootswagger.filter")
public class SpringbootswaggerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootswaggerApplication.class, args);
  }

}
