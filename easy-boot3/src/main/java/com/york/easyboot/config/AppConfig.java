package com.york.easyboot.config;

import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.york.easyboot.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserBean user() {
        UserBean user = new UserBean();
        user.setUserId(1L);
        user.setUsername("york");

        return user;
    }

//    @Bean
//    public JsonFactoryBuilder jsonFactoryBuilder() {
//        return new JsonFactoryBuilder();
//    }
}
