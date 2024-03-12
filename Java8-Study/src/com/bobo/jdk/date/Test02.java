package com.bobo.jdk.date;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test02 {
    public static void main(String[] args) {
        /**
         * 日期时间的修改
         */
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        // 修改时间，对日期时间的修改，对已存在的 LocalDate 对象，创建了它的模板
        // 并不会修改原来的信息
        LocalDateTime localDateTime = now.withYear(1998);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println(now.withMonth(10));
        System.out.println(now.withDayOfMonth(6));
        System.out.println(now.withHour(8));
        System.out.println(now.withMinute(15));

        // 在当前日期的基础上，加上或者减去指定的时间
        System.out.println("两天后 = " + now.plusDays(2));
        System.out.println("十年后 = " + now.plusYears(10));
        System.out.println("六个月后 = " + now.plusMonths(6));
        System.out.println("十年前 = " + now.minusYears(10));
        System.out.println("六个月前 = " + now.minusMonths(6));
        System.out.println("七天前 = " + now.minusDays(7));

        /**
         * 日期时间的比较
         */
        LocalDate now1 = LocalDate.now();
        LocalDate date = LocalDate.of(2020, 1, 3);

        // 在 JDK8 中要实现日期的比较
        System.out.println(now.isAfter(date.atStartOfDay())); // true
        System.out.println(now.isBefore(date.atStartOfDay())); // false
        System.out.println(now.isEqual(date.atStartOfDay())); // false
    }
}
