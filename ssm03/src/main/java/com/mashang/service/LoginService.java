package com.mashang.service;

public class LoginService implements ILoginService {

    @Override
    public boolean login(String name, String password) {

        // 记录日志, 将访问的信息记录到日志中
        // 开启事务

        System.out.println("LoginService.login.name = " + name);
        System.out.println("LoginService.login.password = " + password);

        // 提交事务、回滚事务

        return false;
    }
}
