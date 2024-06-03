package com.york.easyboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.york.easyboot.mapper.IUserMapper;
import com.york.easyboot.pojo.po.BUserPO;
import com.york.easyboot.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, BUserPO> implements IUserService {
}
