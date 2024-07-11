package com.york.easyboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.york.easyboot.mapper.IUserMapper;
import com.york.easyboot.pojo.dto.LoginUserDetails;
import com.york.easyboot.pojo.po.BUserPO;
import com.york.easyboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, BUserPO> implements IUserService {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String loginByUsernameAndPassword(String username, String password) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (authenticate == null) throw new UsernameNotFoundException("未找到该用户");

        LoginUserDetails userDetails = (LoginUserDetails) authenticate.getPrincipal();

//        return TokenUtils.genAccessToken(userDetails.getUsername());
        return null;
    }
}
