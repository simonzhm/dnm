/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.math.BigDecimal;

/**
 * ���㹤��
 * 
 * @author hongmin.zhonghm
 * @version $Id: CalculateUtil.java, v 0.1 2014-5-15 ����11:23:51 hongmin.zhonghm Exp $
 */
public class CalculateUtil {

    /**
     * �����Ĭ�ϱ�����λС������������
     * 
     * @param origAmt ������ (10000.00)
     * @param rate ���� (21.06%)������ʱû��%�����Լ�������Ҫ����100
     * @return
     */
    public static BigDecimal calcAmt(String origAmt, String rate, String actualAmt) {
        return calcAmt(getBigDecimal(origAmt), getRateNonPercent(rate), getBigDecimal(actualAmt));
    }

    /**
     * �����Ĭ�ϱ�����λС������������
     * 
     * @param origAmt ������ (10000.00)
     * @param rate ���� (21.06%)������ʱ��Ϊ0.2106
     * @param actualAmt ʵ�ʽ����ý�Ϊ��ʱ���Ըý��Ϊ׼
     * @return
     */
    public static BigDecimal calcAmt(BigDecimal origAmt, BigDecimal rate, BigDecimal actualAmt) {
        if (actualAmt == null) {
            actualAmt = origAmt;
            actualAmt = actualAmt.multiply(rate);
            actualAmt = actualAmt.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return actualAmt;
    }

    /**
     * ���������ʼ��������ʣ�����С�����4λ
     * 
     * @param yearRate
     * @return
     */
    public static BigDecimal calcMonthRate(String yearRate) {
        BigDecimal yr = getRateNonPercent(yearRate);
        return calcMonthRate(yr);
    }

    /**
     * ���������ʼ��������ʣ�����С�����4λ
     * 
     * @param yearRate
     * @return
     */
    public static BigDecimal calcMonthRate(BigDecimal yearRate) {
        BigDecimal monthRate = yearRate.divide(new BigDecimal("12"));
        monthRate = monthRate.setScale(4, BigDecimal.ROUND_HALF_UP);
        return monthRate;
    }

    /**
     * ��ȡû�аٷֺţ�%�������ʣ�����С�����4λ
     * 
     * @param origRate  22%������22
     * @return ���ڰٷֺţ�%�������� 0.22
     */
    public static BigDecimal getRateNonPercent(String origRate) {
        return new BigDecimal(origRate).divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���ַ���ת��ΪBigDecimal
     * 
     * @param number
     * @return
     */
    public static BigDecimal getBigDecimal(String number) {
        if (StringUtil.isBlank(number)) {
            return null;
        } else {
            return new BigDecimal(number);
        }
    }

    public static void main(String[] args) {
        System.out.println(CalculateUtil.calcAmt("1000.34", "21.06", null));
    }

}
