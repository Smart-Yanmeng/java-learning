package com.york.pattern.singleton.demo02;

/**
 * 饿汉式：静态代码块
 */
public class Singleton {

    private Singleton() {
    }

    private static final Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
