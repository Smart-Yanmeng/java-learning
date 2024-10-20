package com.York;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    private static void threadPoolSubmit() {

        try {
            // 创建一个固定大小的线程池
            ExecutorService threadPool = Executors.newFixedThreadPool(10);

            // Execute 的返回值是 void
            // 若中间出现了异常，会在子线程中抛出，主线程捕捉不到异常
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " is running..."));

            // Submit 的返回值是 Future 类型
            // 若中间出现了异常，不会立马抛出。而是在调用 Future 的 get 方法时抛出，并且主线程可以捕捉到异常
            Future<String> future = threadPool.submit(() -> "Hello, World!");

            // Future 的 get 方法会阻塞当前线程，直到任务执行完毕
            System.out.println(future.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        threadPoolSubmit();
    }
}
