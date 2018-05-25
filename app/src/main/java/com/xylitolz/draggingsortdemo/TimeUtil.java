package com.xylitolz.draggingsortdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 时间工具类
 * @date 2018-05-15 10:49
 */
public class TimeUtil {

    private static String timeFormateryMdHHmm = "yyyy-MM-dd HH:mm";
    private static long oneHour = 60 * 60 * 1000;
    private static long oneMinute = 60 * 1000;

    public static String parseTimeByLatest(long timeMillis) {
        Date date = new Date(timeMillis);
        SimpleDateFormat format = new SimpleDateFormat(timeFormateryMdHHmm);
        long currentTimeMillis = System.currentTimeMillis();
        if(currentTimeMillis - timeMillis < oneMinute) {
           return "刚刚";
        } else if(currentTimeMillis - timeMillis < oneHour) {
            return ((currentTimeMillis - timeMillis) / oneMinute) + "分钟前";
        } else {
            return format.format(date);
        }
    }
}
