package com.mashang;

import com.mashang.config.JdbcUtils;
import com.mashang.config.SpringConfig;
import com.mashang.service.ClazzInfoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.AnnotatedElement;

public class Test03 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ClazzInfoService service = context.getBean(ClazzInfoService.class);
        service.getClazzInfoData();

        JdbcUtils jdbcUtils = context.getBean(JdbcUtils.class);
        jdbcUtils.getData();
    }
}
