package com.york.mymp.mapper;

import com.york.mymp.dto.po.BUserPO;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private IUserMapper userMapper;

    @Test
    void insertTest() throws JSONException {
        BUserPO user = new BUserPO();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age", 18);
        jsonObject.put("intro", "I am a programmer.");
        jsonObject.put("gender", "female");


        user.setUsername("York");
        user.setPassword("123456");
        user.setPhone("12345678902");
        user.setInfo(jsonObject.toString());
        user.setStatus(1);
        user.setBalance(100000000);
        user.setCreateTime("2021-08-01 00:00:00");
        user.setUpdateTime("2021-08-01 00:00:00");

        int insert = userMapper.insert(user);

        System.out.println("insert = " + insert);
    }

    @Test
    void selectTest() {
        BUserPO user = userMapper.selectById(1);
        System.out.println("user = " + user);
    }
}
