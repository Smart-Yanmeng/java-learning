package com.York;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    // 不使用线程池
    private static void thread() {

        Long start = System.currentTimeMillis();

        // 创建 100000 个线程
        for (int i = 0; i < 100000; i++) {
            new Thread(
                    () -> System.out.println(Thread.currentThread().getName() + " is running...")
            ).start();
        }

        Long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }

    private static void pool() throws InterruptedException {

        Long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 创建 100000 个线程
        for (int i = 0; i < 100000; i++) {
            executorService.execute(
                    () -> System.out.println(Thread.currentThread().getName() + " is running...")
            );
        }

        executorService.shutdown();
        executorService.awaitTermination(1, java.util.concurrent.TimeUnit.DAYS);

        Long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }

    public static void main(String[] args) {

            try {
                thread();
                pool();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
