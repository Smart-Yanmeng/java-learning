package com.york.eyesight.controller;

import com.york.eyesight.pojo.dto.RUserDTO;
import com.york.eyesight.service.impl.TestServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {

    @Resource
    private TestServiceImpl testService;

    @PostMapping("/test")
    public String hello(@RequestBody RUserDTO user) {
        System.out.println(user);

        return "HELLO WORLD!";
    }
}
