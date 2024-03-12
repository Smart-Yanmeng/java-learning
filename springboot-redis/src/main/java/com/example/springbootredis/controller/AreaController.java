package com.example.springbootredis.controller;

import com.example.springbootredis.vo.StudentVo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

//    @Resource
//    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/getArrayList")
    public List<String> getAreaList() {

//        redisTemplate.opsForValue().set("testusername", "zhangsan");

        StudentVo studentVo = new StudentVo();
        studentVo.setId(1001L);
        studentVo.setName("York");
        redisTemplate.opsForValue().set("testname2", studentVo);

        return Arrays.asList("1", "2");
    }

    @GetMapping("/getRedisValue")
    public List<String> getRedisValue() {

//        String testusername = redisTemplate.opsForValue().get("testusername");
//        System.out.println(testusername);

        StudentVo studentVo = (StudentVo) redisTemplate.opsForValue().get("testname2");
        System.out.println(studentVo);

        return Arrays.asList("1", "2");
    }
}
