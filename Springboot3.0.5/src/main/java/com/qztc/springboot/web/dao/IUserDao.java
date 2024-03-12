package com.qztc.springboot.web.dao;

import com.qztc.springboot.web.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {
    UserEntity login(UserEntity user);
}
