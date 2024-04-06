package com.york.mymp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.york.mymp.dto.po.BUserPO;
import com.york.mymp.mapper.IUserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@MapperScan("com.york.mymp.mapper")
@SpringBootApplication
public class MpForTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpForTestApplication.class, args);
    }
}
