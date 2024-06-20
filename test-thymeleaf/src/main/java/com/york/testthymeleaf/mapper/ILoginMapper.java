package com.york.testthymeleaf.mapper;

import com.york.testthymeleaf.entity.UserEntity;

import java.util.List;

public interface ILoginMapper {

    Integer login(String username, String password);

    List<UserEntity> listUsers(String username);
}
