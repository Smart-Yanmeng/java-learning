package com.example.geek_navigation.mapper;

import com.example.geek_navigation.domain.entity.BAccountEntity;

import java.util.List;

public interface IAccountMapper {
    List<BAccountEntity> queryAccount();
}
