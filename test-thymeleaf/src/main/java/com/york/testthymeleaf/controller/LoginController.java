package com.york.testthymeleaf.controller;

import com.york.testthymeleaf.entity.UserEntity;
import com.york.testthymeleaf.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("isFail", false);

        return "index";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String username, @RequestParam String password) {

        Integer result = loginService.login(username, password);

        if (result == 1) {
            model.addAttribute("username", username);

            return "success";
        } else model.addAttribute("isFail", true);

        return "index";
    }

    @GetMapping("/toList")
    public String toList() {

        return "query";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam String username) {

        List<UserEntity> users = loginService.users(username);

        if (users.isEmpty()) {

            model.addAttribute("isEmpty", true);

            return "query";
        } else {

            model.addAttribute("userList", users);

            return "result";
        }
    }
}
