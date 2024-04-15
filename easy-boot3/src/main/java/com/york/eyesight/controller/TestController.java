package com.york.eyesight.controller;

import com.york.eyesight.pojo.dto.RUserDTO;
import com.york.eyesight.service.impl.TestServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Tag(name = "UserControllerApi", description = "用户相关接口")
public class TestController {

    @Resource
    private TestServiceImpl testService;

    @Operation(summary = "Get user info", description = "获取用户信息")
    @PostMapping("/test")
    public String hello(@RequestBody RUserDTO user) {
        System.out.println(user);

        return "HELLO WORLD!";
    }
}
