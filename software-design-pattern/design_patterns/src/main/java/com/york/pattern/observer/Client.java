package com.york.pattern.observer;

public class Client {

    public static void main(String[] args) {

        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WechatUser("张三"));
        subject.attach(new WechatUser("李四"));
        subject.attach(new WechatUser("王五"));

        subject.notify("推送消息：明天放假！");
    }
}
