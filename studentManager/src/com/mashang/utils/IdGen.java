package com.mashang.utils;

public class IdGen {

    private static int num = 0;

    // 时间戳 + 自增的索引
    public synchronized static long gen() {
        long timeTemp = System.currentTimeMillis();
        long resultNum = Long.parseLong(timeTemp + "" + num++);

        return resultNum;
    }
}
