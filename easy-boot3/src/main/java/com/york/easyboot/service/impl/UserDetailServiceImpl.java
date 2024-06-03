package com.york.easyboot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.york.easyboot.pojo.dto.LoginUserDetails;
import com.york.easyboot.pojo.po.BUserPO;
import com.york.easyboot.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private IUserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BUserPO user = userService.getOne(Wrappers.<BUserPO>lambdaQuery().eq(BUserPO::getUsername, username));

        if (user == null) throw new UsernameNotFoundException(username);

        return new LoginUserDetails(user);
    }
}
