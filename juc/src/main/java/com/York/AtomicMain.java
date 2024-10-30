package com.York;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {

    public static AtomicInteger stock = new AtomicInteger(1000000);

    static class StockRunnable implements Runnable {

        @Override
        public void run() {
            if (stock.get() > 0) {
                stock.decrementAndGet();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        StockRunnable task = new StockRunnable();

        try {
            for (int i = 0; i < 1000000; i++) {
                threadPool.execute(task);
            }

            System.out.println("Stock: " + stock.get());
        } finally {
            threadPool.shutdown();
        }
    }
}
