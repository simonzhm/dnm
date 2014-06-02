/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * 
 * @author hongmin.zhonghm
 * @version $Id: DateUtil.java, v 0.1 2014-5-15 上午2:05:50 hongmin.zhonghm Exp $
 */
public class DateUtil {

    public final static String shortFormat          = "yyyyMMdd";
    public final static String longFormat           = "yyyyMMddHHmmss";
    public final static String webFormat            = "yyyy-MM-dd";
    public final static String timeFormat           = "HHmmss";
    public final static String monthFormat          = "yyyyMM";
    public final static String newFormat            = "yyyy-MM-dd HH:mm:ss";
    public final static String noSecondFormat       = "yyyy-MM-dd HH:mm";
    public final static long   ONE_DAY_MILL_SECONDS = 86400000;

    /**
     * 转换字符串为日期类型
     * 
     * @param dateStr
     * @return
     */
    public static Date getDate(String dateStr, String format) {
        Date date;
        DateFormat df = getNewDateFormat(format);

        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * 获取某日期的前面某一天。由于美国时区有冬令时和夏令时问题，<br>
     * com.iwallet.biz.common.util.DateUtil处理该问题有缺陷。所以日期计算必须用该方法。
     *
     * @param dateStr      日期字符串
     * @param span         间隔天数
     * @return             结果日期
     */
    public static String getBeforeDayString(String dateStr, int span) {

        Date date;
        DateFormat df = getNewDateFormat(shortFormat);

        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            date = new Date();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -span); //得到前几天

        return df.format(calendar.getTime());
    }

    /**
     * 获取某日期的前面某几月的日期。
     * 
     * @param dateStr      日期字符串
     * @param span         间隔月数
     * @return             结果日期
     */
    public static String getBeforeMonthString(String dateStr, int span) {

        Date date;
        DateFormat df = getNewDateFormat(shortFormat);

        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            date = new Date();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -span); //得到前几天

        return df.format(calendar.getTime());
    }

    /**
     * 获取当前日的前面某一天。
     *
     * @param span  跨度
     * @return      当前日的前面某一天
     */
    public static String getBeforeDayString(int span) {
        return getBeforeDayString(getTodayString(), span);
    }

    /**
     * 给指定时间加上<code>days<code>天数。由于美国时区有冬令时和夏令时问题，<br>
     * com.iwallet.biz.common.util.DateUtil处理该问题有缺陷
     * 如。2013年的夏令时是2013/03/10 02:00:00,如果是2013/03/10 1:59:59加上1天，应该是<br>
     * 2013/03/11 1:59:59，如果按照com.iwallet.biz.common.util.DateUtil的处理是直接加了24个小时，<br>
     * 就变成了2013/03/11 2:59:59
     * @param date  时间
     * @param span  跨度
     * @return      计算后的时间
     */
    public static Date addDays(Date date, int span) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, span);
        return calendar.getTime();
    }

    /**
     * 获取明天的日期
     *
     * @param dateStr           日期（yyyyMMdd格式）
     * @return                  明天的日期
     */
    public static String getTomorrowDateString(String dateStr) {

        return getBeforeDayString(dateStr, -1);
    }

    /**
     * 获取昨天的日期
     *
     * @param dateStr           日期（yyyyMMdd格式）
     * @return                  昨天的日期
     */
    public static String getYesterDayDateString(String dateStr) {

        return getBeforeDayString(dateStr, 1);
    }

    /**
     * 得到两个时间点之间相差的天数。
     *
     * @param startDt   开始时间
     * @param endDt     结束时间
     * @return          相差天数
     */
    public static long getDiffDays(Date startDt, Date endDt) {

        Calendar startCl = Calendar.getInstance();
        startCl.setTime(startDt);
        Calendar endCl = Calendar.getInstance();
        endCl.setTime(endDt);
        boolean positive = false;
        if (startCl.after(endCl)) {
            Calendar swap = startCl;
            startCl = endCl;
            endCl = swap;
            positive = true;
        }

        int days = endCl.get(Calendar.DAY_OF_YEAR) - startCl.get(Calendar.DAY_OF_YEAR);//计算2个时间点的差
        int year = endCl.get(Calendar.YEAR);
        if (startCl.get(Calendar.YEAR) != year) {
            startCl = (Calendar) startCl.clone();
            do {
                days = days + startCl.getActualMaximum(Calendar.DAY_OF_YEAR);//如果不是同一年则累计该年的天数。
                startCl.add(Calendar.YEAR, 1);
            } while (startCl.get(Calendar.YEAR) != year);
        }
        if (!positive) {
            days = days * -1;
        }
        return days;
    }

    /**
     * 给指定时间增加小时
     *
     * @param date    时间
     * @param hours   小时数
     * @return        增加后的时间
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);

        return calendar.getTime();
    }

    /**
     * 本地化的展示方式：美国 July 04 2013 12:00:00
     * 
     * @param       时间
     * @return      格式化后的时间
     */
    public static String defaultUSLocalTime(Date date) {

        String mon = String.format(Locale.US, "%tb", date);

        DateFormat formate = getNewDateFormat(" dd yyyy HH:mm:ss");

        String times = formate.format(date);

        return mon + times;
    }

    /**
     * 获取日期格式
     * 
     * @param pattern
     * @return
     */
    public static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);

        df.setLenient(false);
        return df;
    }

    /**
     * 获取今天日期
     * 
     * @return
     */
    public static String getTodayString() {
        DateFormat dateFormat = getNewDateFormat(shortFormat);

        return getDateString(new Date(), dateFormat);
    }

    /**
     * 获取格式化的日期
     * 
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getDateString(Date date, DateFormat dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }

        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getBeforeMonthString("20120331", 13));
    }
}
