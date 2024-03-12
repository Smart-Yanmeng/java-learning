package com.example.springbootswagger.controller;

import com.example.springbootswagger.model.User;
import com.example.springbootswagger.model.UserQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

  @GetMapping("/getUserInfo")
  @ApiOperation("获取用户信息")
  public User getUserInfo(User user) {
    System.out.println("UserController.getUserInfo");

    return new User();
  }

  @PostMapping("/login")
  @ApiOperation("登录")
  public User login(@RequestBody UserQueryVo vo) {
    System.out.println("UserController.login");

    return new User();
  }
}
