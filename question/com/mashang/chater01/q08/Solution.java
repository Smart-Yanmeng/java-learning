package com.mashang.chater01.q08;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Thread printOdd = new Thread(new RunOdd(), "Odd");
        Thread printEven = new Thread(new RunEven(), "Even");

        printOdd.start();
        printEven.start();
    }
}

class RunOdd implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i += 2) {
            int number = new Random().nextInt(49) * 2 + 1;
            System.out.println(Thread.currentThread().getName() + " " + number);
        }
    }
}

class RunEven implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 999; i += 2) {
            System.out.println(Thread.currentThread().getName() + new Random().nextInt(50) * 2);
        }
    }
}
