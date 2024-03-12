package com.bobo.jdk.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test01 {
    public static void main(String[] args) {
        /**
         * JDK8 日期时间操作
         */
        // 1.创建指定的日期
        LocalDate date1 = LocalDate.of(2021, 05, 06);
        System.out.println("date1 = " + date1);

        // 2.得到当前日期
        LocalDate now = LocalDate.now();
        System.out.println("date2 = " + now);

        // 3.根据 LocalDate 对象获取对应的日期信息
        System.out.println("Year = " + now.getYear());
        System.out.println("Month = " + now.getMonth().getValue());
        System.out.println("Day = " + now.getDayOfMonth());
        System.out.println("Week = " + now.getDayOfWeek().getValue());

        /**
         * 时间操作
         */
        // 1.得到指定时间
        LocalTime time = LocalTime.of(5, 26, 33, 23145);
        System.out.println(time);

        // 2.获取当前的时间
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);

        // 3.获取时间信息
        System.out.println("Hour = " + now1.getHour());
        System.out.println("Minute = " + now1.getMinute());
        System.out.println("Second = " + now1.getSecond());
        System.out.println("Nano = " + now1.getNano());

        /**
         * 日期时间类型 LocalDateTime
         */
        // 1.获取指定的日期时间
        LocalDateTime dateTime = LocalDateTime.of(2023, 03, 03, 12, 12, 33, 213);
        System.out.println(dateTime);

        // 2.获取当前的日期时间
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        // 3.获取日期时间信息
        System.out.println("Year = " + now2.getYear());
        System.out.println("Month = " + now2.getMonth().getValue());
        System.out.println("Day = " + now2.getDayOfMonth());
        System.out.println("Week = " + now2.getDayOfWeek().getValue());
        System.out.println("Hour = " + now2.getHour());
        System.out.println("Minute = " + now2.getMinute());
        System.out.println("Second = " + now2.getSecond());
        System.out.println("Nano = " + now2.getNano());
    }
}
