package com.york.security.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.york.security.pojo.po.UserPo;
import com.york.security.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private IUserService userService;

    @GetMapping
    public ResponseEntity<UserPo> test(String username) {

        UserPo user = userService.getOne(Wrappers.<UserPo>lambdaQuery().eq(UserPo::getUsername, username));

        return ResponseEntity.ok(user);
    }
}
