package com.york;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        Number sum = new Number();
        sum.setNumber(0);

        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {

            lock.lock();
            for (int i = 0; i < 1000000; i++) {
                sum.setNumber(sum.getNumber() + 1);
            }
            lock.unlock();
        });

        Thread t2 = new Thread(() -> {

            lock.lock();
            for (int i = 0; i < 1000000; i++) {
                sum.setNumber(sum.getNumber() + 1);
            }
            lock.unlock();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException _) {
        }

        System.out.println(sum.getNumber());
    }
}
