package com.york.testthymeleaf.service;

import com.york.testthymeleaf.entity.UserEntity;
import com.york.testthymeleaf.mapper.ILoginMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Resource
    private ILoginMapper loginMapper;

    public Integer login(String username, String password) {

        return loginMapper.login(username, password);
    }

    public List<UserEntity> users(String username) {

        return loginMapper.listUsers(username);
    }
}
