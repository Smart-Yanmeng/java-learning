package com.mashang.study.dao;

import com.mashang.study.entity.BUserEntity;

import java.util.List;

public interface IUserDao {

  // 登录
  List<BUserEntity> findUserByCondition(BUserEntity user);

  // 查询用户名是否已经存在
  Integer judgeUsernameExist(String username);
}
