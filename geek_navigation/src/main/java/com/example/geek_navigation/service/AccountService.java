package com.example.geek_navigation.service;

import com.example.geek_navigation.domain.entity.BAccountEntity;
import com.example.geek_navigation.mapper.IAccountMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Resource
    private IAccountMapper accountMapper;

    public List<BAccountEntity> viewAccount() {
        return accountMapper.queryAccount();
    }
}
