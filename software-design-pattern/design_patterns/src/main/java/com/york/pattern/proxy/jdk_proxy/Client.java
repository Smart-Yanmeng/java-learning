package com.york.pattern.proxy.jdk_proxy;

public class Client {

    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory();

        SellTickets sellTickets = (SellTickets) proxyFactory.getProxyObject();

        sellTickets.sell();
    }
}
