package com.bobo.jdk.date;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test07 {
    public static void main(String[] args) {
        /**
         * 时区操作
         */
        // 获取所有的时区id
        // ZoneId.getAvailableZoneIds().forEach(System.out::println);

        // 获取当前时间，中国使用的是东八区的时区，比标准时间要早8个小时
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        // 获取标准时间
        ZonedDateTime bz = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("bz = " + bz);

        // 使用计算机默认的时区，创建日期时间
        ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println("now1 = " + now1);

        // 使用指定的时区创建日期时间
        ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("America/Marigot"));
        System.out.println("now2 = " + now2);
    }
}
