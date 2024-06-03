package com.york.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.york.security.mapper.IUserMapper;
import com.york.security.pojo.po.UserPo;
import com.york.security.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, UserPo> implements IUserService {
}
