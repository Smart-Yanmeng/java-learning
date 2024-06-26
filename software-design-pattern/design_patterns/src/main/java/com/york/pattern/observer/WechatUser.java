package com.york.pattern.observer;

public class WechatUser implements Observer {

    private String name;

    public WechatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " 收到推送消息：" + message);
    }
}
