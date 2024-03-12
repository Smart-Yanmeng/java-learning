package com.bobo.jdk.res;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test07 {
    public static void main(String[] args) throws ParseException {
        /**
         * 旧版日期时间设计的问题
         */
        // 1、设计不合理
        Date date = new Date(2023, 03, 03);
        System.out.println(date);

        // 2、时间格式化和解析操作是线程不安全的
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    System.out.println(sdf.parse("2023-03-03"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
