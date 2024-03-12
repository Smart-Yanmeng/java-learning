package com.mashang.study.service;

import com.mashang.study.dao.IUserDao;
import com.mashang.study.entity.BUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private IUserDao userDao;

  // login
  public List<BUserEntity> userLoginList(BUserEntity user) {

    return userDao.findUserByCondition(user);
  }

}
