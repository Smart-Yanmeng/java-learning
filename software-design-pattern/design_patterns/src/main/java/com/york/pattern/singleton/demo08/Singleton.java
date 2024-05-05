package com.york.pattern.singleton.demo08;

/**
 * 懒汉式：静态内部类
 */
public class Singleton {

    private static boolean flag = false;

    private Singleton() {

        synchronized (Singleton.class) {
            if (!flag) {
                flag = true;
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
