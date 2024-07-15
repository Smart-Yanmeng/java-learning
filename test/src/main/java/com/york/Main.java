package com.york;

import java.sql.Time;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {

        Number sum = new Number();
        sum.setNumber(0);

        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 10000000; i++) {
                lock.lock();
                sum.setNumber(sum.getNumber() + 1);
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10000000; i++) {
                lock.lock();
                sum.setNumber(sum.getNumber() + 1);
                lock.unlock();
            }
        });

        Time start = new Time(System.currentTimeMillis());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException _) {
        } finally {
            Time passBy = new Time(System.currentTimeMillis() - start.getTime());
            System.out.println(STR."Time: \{passBy.getTime() }ms");
        }

        System.out.println(sum.getNumber());
    }
}
