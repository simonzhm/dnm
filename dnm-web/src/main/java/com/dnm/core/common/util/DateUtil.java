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
 * ���ڹ�����
 * 
 * @author hongmin.zhonghm
 * @version $Id: DateUtil.java, v 0.1 2014-5-15 ����2:05:50 hongmin.zhonghm Exp $
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
     * ת���ַ���Ϊ��������
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
     * ��ȡĳ���ڵ�ǰ��ĳһ�졣��������ʱ���ж���ʱ������ʱ���⣬<br>
     * com.iwallet.biz.common.util.DateUtil�����������ȱ�ݡ��������ڼ�������ø÷�����
     *
     * @param dateStr      �����ַ���
     * @param span         �������
     * @return             �������
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
        calendar.add(Calendar.DATE, -span); //�õ�ǰ����

        return df.format(calendar.getTime());
    }

    /**
     * ��ȡĳ���ڵ�ǰ��ĳ���µ����ڡ�
     * 
     * @param dateStr      �����ַ���
     * @param span         �������
     * @return             �������
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
        calendar.add(Calendar.MONTH, -span); //�õ�ǰ����

        return df.format(calendar.getTime());
    }

    /**
     * ��ȡ��ǰ�յ�ǰ��ĳһ�졣
     *
     * @param span  ���
     * @return      ��ǰ�յ�ǰ��ĳһ��
     */
    public static String getBeforeDayString(int span) {
        return getBeforeDayString(getTodayString(), span);
    }

    /**
     * ��ָ��ʱ�����<code>days<code>��������������ʱ���ж���ʱ������ʱ���⣬<br>
     * com.iwallet.biz.common.util.DateUtil�����������ȱ��
     * �硣2013�������ʱ��2013/03/10 02:00:00,�����2013/03/10 1:59:59����1�죬Ӧ����<br>
     * 2013/03/11 1:59:59���������com.iwallet.biz.common.util.DateUtil�Ĵ�����ֱ�Ӽ���24��Сʱ��<br>
     * �ͱ����2013/03/11 2:59:59
     * @param date  ʱ��
     * @param span  ���
     * @return      ������ʱ��
     */
    public static Date addDays(Date date, int span) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, span);
        return calendar.getTime();
    }

    /**
     * ��ȡ���������
     *
     * @param dateStr           ���ڣ�yyyyMMdd��ʽ��
     * @return                  ���������
     */
    public static String getTomorrowDateString(String dateStr) {

        return getBeforeDayString(dateStr, -1);
    }

    /**
     * ��ȡ���������
     *
     * @param dateStr           ���ڣ�yyyyMMdd��ʽ��
     * @return                  ���������
     */
    public static String getYesterDayDateString(String dateStr) {

        return getBeforeDayString(dateStr, 1);
    }

    /**
     * �õ�����ʱ���֮������������
     *
     * @param startDt   ��ʼʱ��
     * @param endDt     ����ʱ��
     * @return          �������
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

        int days = endCl.get(Calendar.DAY_OF_YEAR) - startCl.get(Calendar.DAY_OF_YEAR);//����2��ʱ���Ĳ�
        int year = endCl.get(Calendar.YEAR);
        if (startCl.get(Calendar.YEAR) != year) {
            startCl = (Calendar) startCl.clone();
            do {
                days = days + startCl.getActualMaximum(Calendar.DAY_OF_YEAR);//�������ͬһ�����ۼƸ����������
                startCl.add(Calendar.YEAR, 1);
            } while (startCl.get(Calendar.YEAR) != year);
        }
        if (!positive) {
            days = days * -1;
        }
        return days;
    }

    /**
     * ��ָ��ʱ������Сʱ
     *
     * @param date    ʱ��
     * @param hours   Сʱ��
     * @return        ���Ӻ��ʱ��
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);

        return calendar.getTime();
    }

    /**
     * ���ػ���չʾ��ʽ������ July 04 2013 12:00:00
     * 
     * @param       ʱ��
     * @return      ��ʽ�����ʱ��
     */
    public static String defaultUSLocalTime(Date date) {

        String mon = String.format(Locale.US, "%tb", date);

        DateFormat formate = getNewDateFormat(" dd yyyy HH:mm:ss");

        String times = formate.format(date);

        return mon + times;
    }

    /**
     * ��ȡ���ڸ�ʽ
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
     * ��ȡ��������
     * 
     * @return
     */
    public static String getTodayString() {
        DateFormat dateFormat = getNewDateFormat(shortFormat);

        return getDateString(new Date(), dateFormat);
    }

    /**
     * ��ȡ��ʽ��������
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
