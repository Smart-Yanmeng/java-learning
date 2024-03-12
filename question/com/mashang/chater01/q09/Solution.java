package com.mashang.chater01.q09;

public class Solution implements Runnable {
    private char now = 'A';

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            printThreadId();
        }
    }

    private synchronized void printThreadId() {
        Thread t = Thread.currentThread();
        while (t.getName().charAt(0) != now) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(t.getName());
        now = (char) ((now - 'A' + 1) % 3 + 'A');

        notifyAll();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Thread ta = new Thread(solution, "A");
        Thread tb = new Thread(solution, "B");
        Thread tc = new Thread(solution, "C");

        ta.start();
        tb.start();
        tc.start();
    }
}
