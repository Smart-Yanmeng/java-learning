package com.bobo.jdk.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Test05 {
    public static void main(String[] args) {
        /**
         * 计算日期时间差
         */
        // 计算时间差
        LocalTime now = LocalTime.now();
        LocalTime time = LocalTime.of(22, 48, 59);

        // 通过 Duration 来计算时间差
        Duration duration = Duration.between(now, time);
        System.out.println("duration.toDays() = " + duration.toDays());
        System.out.println("duration.toHours() = " + duration.toHours());
        System.out.println("duration.toMinutes() = " + duration.toMinutes());
        System.out.println("duration.toMillis() = " + duration.toMillis());

        // 计算日期差
        LocalDate nowDate = LocalDate.now();
        LocalDate date = LocalDate.of(2017, 1, 1);
        Period period = Period.between(date, nowDate);
        System.out.println("period.getYears() = "+period.getYears());
        System.out.println("period.getMonths() = "+period.getMonths());
        System.out.println("period.getDays() = "+period.getDays());
    }
}
