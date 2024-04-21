package com.york;

import com.spring.MyApplicationContext;
import com.york.service.IUserService;

public class Main {
    public static void main(String[] args) {
        MyApplicationContext applicationContext = new MyApplicationContext(AppConfig.class);

        IUserService userService = (IUserService) applicationContext.getBean("userService");
        userService.test(); // 先执行代理逻辑，再执行业务逻辑
    }
}
