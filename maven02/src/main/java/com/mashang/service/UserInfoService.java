package com.mashang.service;

import java.util.PrimitiveIterator;

/**
 * 处理业务逻辑, 调用 mybatis 操作数据
 */
public class UserInfoService {
    private String name;

    private String age;

    private TeacherService teacherService;

    private Integer height;

    public void setHeight(Integer height) {
        this.height = height;
        System.out.println("height = " + height);
    }

    public UserInfoService(String name, String age, TeacherService teacherService) {
        System.out.println("UserInfoService 有参构造函数");
        this.name = name;
        this.age = age;
        this.teacherService = teacherService;

        System.out.println("teacherService= " + teacherService);
    }

    public UserInfoService() {
    }

    public UserInfoService(String name) {
    }

    public void login(String userName, String pwd) {
        System.out.println("userName=" + userName + " pwd=" + pwd);

        System.out.println("UserInfoService.login");
    }

    public void initUserInfoService() {
        System.out.println("UserInfoService.initUserInfoService");
    }


}
