package com.york.pattern.proxy.cglib_proxy;

public class Client {

    public static void main(String[] args) {

        ProxyFactory factory = new ProxyFactory();

        TrainStation proxyInstance = factory.getProxyInstance();
        proxyInstance.sell();
    }
}
