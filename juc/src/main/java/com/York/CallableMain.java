package com.York;

import java.util.concurrent.FutureTask;

public class CallableMain {

    public static void main(String[] args) {

        // 使用 FutureTask 创建 Callable 任务
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println("Callable task is running...");

            return 5;
        });

        new Thread(task).start();

        try {
            // 阻塞等待任务执行完毕
            System.out.println("Result: " + task.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
