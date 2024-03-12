package com.mashang.service;

import com.mashang.dao.ClazzDao;
import com.mashang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ClazzInfoService {

    // 通过类型方式, 注入这个对象
    @Autowired
    public UserDao userDao;

    @Resource(name = "clazzDao")
    private ClazzDao clazzDao;

    @Value("1班")
    private String className = "1班";

    public void getClazzInfoData() {
        System.out.println("ClazzInfoService.getClazzInfoData");
        System.out.println("userDao = " + userDao);
        System.out.println("clazzDao = " + clazzDao);
    }
}
