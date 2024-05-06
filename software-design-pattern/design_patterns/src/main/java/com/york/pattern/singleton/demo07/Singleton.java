package com.york.pattern.singleton.demo07;

import java.io.Serializable;

/**
 * 懒汉式：静态内部类
 */
public class Singleton implements Serializable {

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 当进行反序列化时，会自动调用该方法，返回指定的对象
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
