package com.mashang.chater01.q07;

public class Solution implements Runnable {
    private int availableTickets = 100;

    @Override
    public void run() {
        while (availableTickets > 0) {
            sellTicket();
        }
    }

    private synchronized void sellTicket() {
        if (availableTickets > 0) {
            availableTickets--;

            System.out.println(Thread.currentThread().getName() + " sells a ticket, leaves available tickets: " + availableTickets);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Thread window1 = new Thread(solution, "Window1");
        Thread window2 = new Thread(solution, "Window2");
        Thread window3 = new Thread(solution, "Window3");

        window1.start();
        window2.start();
        window3.start();
    }
}
