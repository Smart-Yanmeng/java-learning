package com.mashang;

import com.mashang.service.UserInfoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");

        UserInfoService userInfoService = (UserInfoService) xml.getBean("userInfoService");
        userInfoService.login("zhangsan", "123");

        System.out.println(userInfoService);

        UserInfoService infoService = xml.getBean(UserInfoService.class);
        infoService.login("lisi", "456");
    }
}
