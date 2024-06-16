package com.york.testthymeleaf.controller;

import com.york.testthymeleaf.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String username, @RequestParam String password) {

        Integer result = loginService.login(username, password);
        if (result == 1) {
            model.addAttribute("username", username);

            return "success";
        }

        return "fail";
    }
}
