package com.example.geek_navigation.controller;

import com.example.geek_navigation.domain.entity.BAccountEntity;
import com.example.geek_navigation.domain.vo.ResultVo;
import com.example.geek_navigation.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/account")
    public ResultVo<List<BAccountEntity>> viewAccount() {
        return new ResultVo<>(0, "success", accountService.viewAccount());
    }
}
