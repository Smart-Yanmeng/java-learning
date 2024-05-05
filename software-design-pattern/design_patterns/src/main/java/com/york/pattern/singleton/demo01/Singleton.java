package com.york.pattern.singleton.demo01;

/**
 * 饿汉式：静态成员变量
 */
public class Singleton {

    private Singleton() {
    }

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
