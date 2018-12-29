package com.example.until;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转换
 * @author : zhangfx 2018/12/27/ 16:24
 * @version 1.0
 */
public class DateUntil {
    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     * @return 时间
     */
    public static String dateToStrLong() {
        Date dateDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }
    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     * @return 时间
     */
    public static String dateToStr() {
        Date dateDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

}
