package com.york.spring.dao.impl;

import com.york.spring.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

    public UserDaoImpl() {
        System.out.println("UserDaoImpl constructor...");
    }

    @Override
    public void save() {
        System.out.println("UserDaoImpl save...");
    }
}
