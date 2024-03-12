package com.mashang.test;

import com.mashang.service.UserLoginService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserLoginService userLoginService = (UserLoginService) context.getBean("userLoginService");

        userLoginService.loginByTel("York");

        System.out.println("----------------------");

        userLoginService.loginByCode();

    }

}
