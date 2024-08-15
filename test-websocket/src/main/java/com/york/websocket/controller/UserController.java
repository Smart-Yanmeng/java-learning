package com.york.websocket.controller;

import com.york.websocket.pojo.Result;
import com.york.websocket.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {

        Result result = new Result();

        if (user != null && "123".equals(user.getPassword())) {
            result.setFlag(true);
            result.setMessage("登录成功");

            session.setAttribute("user", user.getUsername());
        } else {
            result.setFlag(false);
            result.setMessage("登录失败");
        }

        return result;
    }

    @GetMapping("/getUsername")
    public String getUsername(HttpSession session) {

        return (String) session.getAttribute("user");
    }
}
