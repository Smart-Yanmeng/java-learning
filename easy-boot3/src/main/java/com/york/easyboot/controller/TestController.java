package com.york.easyboot.controller;

import com.york.easyboot.pojo.dto.RUserDTO;
import com.york.easyboot.service.impl.TestServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping
@Tag(name = "UserControllerApi", description = "用户相关接口")
public class TestController {

    @Resource
    private TestServiceImpl testService;

    @Operation(summary = "Get user info", description = "获取用户信息")
    @PostMapping("/test")
    public String hello(@RequestBody RUserDTO user) {
//        Logger logger = Logger.getLogger(String.valueOf(getClass()));
//        logger.info("Execute the test method.");
        log.info("Execute the test method.");

        System.out.println(user);

        return "HELLO WORLD!";
    }
}
