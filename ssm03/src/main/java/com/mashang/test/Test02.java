package com.mashang.test;

import com.mashang.service.ClazzService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test02 {

    public static void main(String[] args) {

        final ClazzService clazzService = new ClazzService();

        ClazzService proxyClazzService = (ClazzService) Enhancer.create(clazzService.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                Object obj = null;
                if ("login".equals(method.getName())) {
                    try {
                        System.out.println("开启事务");
                        String name = (String) objects[0];
                        String password = (String) objects[1];
                        obj = method.invoke(clazzService, name, password);
                        System.out.println("关闭事务");

                    } catch (Exception e) {
                        System.out.println("回滚事务");

                        e.printStackTrace();
                    }
                }

                return obj;
            }
        });

        proxyClazzService.login("York", "123456");


    }

}
