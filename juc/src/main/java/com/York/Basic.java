package com.York;

public class Basic {
    public static void main(String[] args) {

        Thread t1 = new Thread(
                () -> {
                    int i = 0;

                    for (int j = 0; j < 100; j++) {
                        System.out.println("A -> " + ++i);
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    int i = 0;

                    for (int j = 0; j < 100; j++) {
                        System.out.println("B -> " + ++i);
                    }
                }
        );

        t1.start();
        t2.start();
    }
}
