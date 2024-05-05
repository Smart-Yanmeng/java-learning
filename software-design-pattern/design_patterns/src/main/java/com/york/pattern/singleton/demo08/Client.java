package com.york.pattern.singleton.demo08;

import java.lang.reflect.Constructor;

/**
 * 使用反射破坏单例模式
 */
public class Client {

    public static void main(String[] args) throws Exception {

        Class<Singleton> singletonClass = Singleton.class;
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton instance1 = declaredConstructor.newInstance();
        Singleton instance2 = declaredConstructor.newInstance();

        System.out.println(instance1 == instance2);
    }
}
