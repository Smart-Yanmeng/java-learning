package com.york.spring.service.impl;

import com.york.spring.dao.IUserDao;
import com.york.spring.service.IUserService;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl constructor...");
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl save...");

        userDao.save();
    }
}
