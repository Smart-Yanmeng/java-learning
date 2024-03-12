package com.mashang.test;

import com.mashang.service.ILoginService;
import com.mashang.service.LoginService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test01 {

    public static void main(String[] args) {

        ILoginService loginService = new LoginService();

        // 生成一个代理类
        ILoginService proxyLoginService = (ILoginService) Proxy.newProxyInstance(loginService.getClass().getClassLoader(), loginService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object obj = null;

                // 代码增强
                if ("login".equals(method.getName())) {
                    System.out.println("开启事务");
                    String name = (String) args[0];
                    String password = (String) args[1];
                    obj = method.invoke(loginService, name, password);
                    System.out.println("关闭事务");
                }

                return obj;
            }
        });

        proxyLoginService.login("York", "123456");

    }

}
