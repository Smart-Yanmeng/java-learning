package com.patientmanager.controller.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home/")
public class HomeController {
    @RequestMapping("/getinfo/")
    public Map<String, String> getInfo() {
        Map<String, String> user = new HashMap<>();
        user.put("name", "aer");
        user.put("password", "paer");

        return user;
    }
}
