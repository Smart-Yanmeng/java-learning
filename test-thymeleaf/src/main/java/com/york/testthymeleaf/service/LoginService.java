package com.york.testthymeleaf.service;

import com.york.testthymeleaf.mapper.ILoginMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private ILoginMapper loginMapper;

    public Integer login(String username, String password) {

        return loginMapper.login(username, password);
    }
}
