package com.mashang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:JdbcUtil.properties")
public class JdbcUtils {

    @Value("${jdbcDriverClassName}")
    private String jdbcDriverClassName;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public void getData() {
        System.out.println("jdbcDriverClassName=" + jdbcDriverClassName + " username=" + username + " password=" + password);
    }
}
