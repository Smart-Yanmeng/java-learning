package com.york.mymp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.york.mymp.dto.po.BUserPO;
import com.york.mymp.mapper.IUserMapper;
import com.york.mymp.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, BUserPO> implements IUserService {
}
