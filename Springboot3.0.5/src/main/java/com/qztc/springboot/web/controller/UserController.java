package com.qztc.springboot.web.controller;

import com.qztc.springboot.web.domain.entity.UserEntity;
import com.qztc.springboot.web.service.UserService;
import com.qztc.springboot.web.utils.JWTUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public Map<String, Object> login(UserEntity user) {
        log.info("用户名: [{}]", user.getUsername());
        log.info("密码: [{}]", user.getPassword());
        Map<String, Object> map = new HashMap<>();
        try {
            UserEntity userDB = userService.login(user);
            Map<String, String> payload = new HashMap<>();
            payload.put("id", String.valueOf(userDB.getId()));
            payload.put("name", userDB.getUsername());
            // 生成 JWT 令牌
            String token = JWTUtil.getToken(payload);

            map.put("state", true);
            map.put("msg", "登录成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }

        return map;
    }

    @PostMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();

        // 处理自己的业务
        map.put("state", true);
        map.put("msg", "请求成功");

        return map;
    }
}
