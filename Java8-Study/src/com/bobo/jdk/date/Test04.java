package com.bobo.jdk.date;

import java.time.Instant;

public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Instant 时间戳
         *     可以用来统计时间消耗
         */
        Instant now = Instant.now();
        System.out.println("now = " + now);

        // 获取从 1970年1月1日 00:00:00 到现在的纳秒偏移量
        System.out.println(now.getNano());
        Thread.sleep(5);
    }
}
