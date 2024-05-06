package com.york.pattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    // 声明目标对象
//    private TrainStation mTrainStation = new TrainStation();

    // 获取代理对象的方法
    public SellTickets getProxyObject() {

        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(

                TrainStation.class.getClassLoader(),
                TrainStation.class.getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if (method.getName().equals("sell")) {
                            System.out.println("代售点卖票");
                        }

//                        Object obj = method.invoke(mTrainStation, args);

                        return null;
                    }
                }
        );

        return proxyInstance;
    }
}
