package com.mashang;

import com.mashang.service.ClazzInfoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");

        ClazzInfoService clazzInfoService = xml.getBean(ClazzInfoService.class);
        clazzInfoService.getClazzInfoData();

    }
}