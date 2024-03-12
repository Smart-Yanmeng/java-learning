package com.qztc.springboot.web.service;

import com.qztc.springboot.web.dao.IUserDao;
import com.qztc.springboot.web.domain.entity.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private IUserDao userDao;

    public UserEntity login(UserEntity user) {
        UserEntity userDB = userDao.login(user);
        if (userDB != null) return userDB;
        throw new RuntimeException("登录失败");
    }
}
