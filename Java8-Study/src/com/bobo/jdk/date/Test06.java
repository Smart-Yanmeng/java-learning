package com.bobo.jdk.date;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Test06 {
    public static void main(String[] args) {
        /**
         * 时间校正器
         */
        LocalDateTime now = LocalDateTime.now();
        // 将当前的日期调整到下个月的一号
        TemporalAdjuster adjuster = (temporal) -> {
            LocalDateTime dateTime = (LocalDateTime) temporal;
            LocalDateTime nextMonth = dateTime.plusMonths(1).withDayOfMonth(1);
            System.out.println("nextMonth = " + nextMonth);

            return nextMonth;
        };

        // 我们还可以通过 TemporalAdjusters 来实现
//        LocalDateTime nextMonth = now.with(adjuster);
        LocalDateTime nextMonth = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("nextMonth = " + nextMonth);
    }
}