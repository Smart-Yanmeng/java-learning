package com.springboottest.springboot01.controller;

import com.springboottest.springboot01.entity.Classes;
import com.springboottest.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Value("${user.name.hello}")
  private String hello;

  @Autowired
  private UserService userService;

  @GetMapping("/getData1")
  public String getData1() {

    System.out.println(hello);
    userService.getUserInfo();
    System.out.println("getData1()");

    return "success";
  }

  @GetMapping("/saveClazz")
  public String saveClazz() {
    Classes clazz = new Classes();
    clazz.setClassId("111");
    clazz.setName("111");
    clazz.setType("1");
    clazz.setRemark("111");
    clazz.setClassNo("111");
    clazz.setCreateTime("111");

    userService.saveClazz(clazz);

    return "success";
  }

}
