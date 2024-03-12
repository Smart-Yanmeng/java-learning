package com.mashang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String formatDate(String formatStr) {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        return simpleDateFormat.format(nowDate);
    }

    public static String formatDate() {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(nowDate);
    }

}
