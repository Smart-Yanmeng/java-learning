package com.york.mymp;

import com.york.mymp.mapper.IUserMapper;
import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MpForTestApplicationTests {

    @Resource
    private IUserMapper userMapper;
}
