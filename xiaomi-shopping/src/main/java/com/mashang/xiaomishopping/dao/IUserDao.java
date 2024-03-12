package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BUserEntity;

import java.util.List;

public interface IUserDao {

  // 获取个人信息
  BUserEntity queryUserInfoByCondition(Long userId);

  // 注册
  int register(BUserEntity bUser);

  // 登录查询
  List<BUserEntity> findUserByCondition(BUserEntity bUser);

  // 查询用户名是否已经存在
  Integer judgeUsernameExist(String username);
}
