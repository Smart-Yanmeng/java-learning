package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.IUserDao;
import com.mashang.xiaomishopping.entity.BUserEntity;
import com.mashang.xiaomishopping.view.user.UserInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private IUserDao userDao;

  @Transactional(rollbackFor = Exception.class)
  public int register(BUserEntity user) {

    // 判断用户名是否已经存在
    if (userDao.judgeUsernameExist(user.getUsername()) == 0) return userDao.register(user);
    else return 0;
  }

  public List<BUserEntity> userLoginList(BUserEntity user) {

    return userDao.findUserByCondition(user);
  }

  public UserInfoView userInfo(Long userId) {

    return new UserInfoView().transfer(userDao.queryUserInfoByCondition(userId));
  }

}
