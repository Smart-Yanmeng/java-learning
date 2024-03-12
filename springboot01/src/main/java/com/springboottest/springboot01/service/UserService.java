package com.springboottest.springboot01.service;

import com.springboottest.springboot01.dao.IUserDao;
import com.springboottest.springboot01.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class UserService {

  @Autowired
  private IUserDao userDao;

  public void getUserInfo() {
    Classes classes = userDao.findById("16597267904311");
    System.out.println(classes.toString());
    System.out.println("UserService.getUserInfo()");
  }

  @Transactional(rollbackFor = Exception.class)
  public void saveClazz(Classes clazz) {
    userDao.insertClasses(clazz);

    int i = 1 / 0;
  }

}
