/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.math.BigDecimal;

/**
 * ����
 * 
 * @author hongmin.zhonghm
 * @version $Id: AmountUtil.java, v 0.1 2014-5-22 ����1:53:13 hongmin.zhonghm Exp $
 */
public class AmountUtil {

    /**
     * �жϽ���Ƿ����0
     * 
     * @param amount
     * @return
     */
    public static boolean isGreaterThanZero(BigDecimal amount) {
        return amount != null && amount.compareTo(new BigDecimal(0)) > 0;
    }

    /**
     * �жϽ���Ƿ���ڻ����0
     * 
     * @param amount
     * @return
     */
    public static boolean isGreaterOrEqualZero(BigDecimal amount) {
        return amount != null && amount.compareTo(new BigDecimal(0)) >= 0;
    }

    /**
     * ���ӵ�ԭ���Ķ����ϣ��������µĶ���
     * 
     * @param origAmt
     * @param addAmt
     * @return
     */
    public static BigDecimal add(BigDecimal origAmt, BigDecimal addAmt) {
        if (origAmt == null) {
            origAmt = addAmt;
        } else {
            if (addAmt != null) {
                origAmt = origAmt.add(addAmt);
            }
        }

        return origAmt;
    }

    /**
     * ����ԭ���Ķ����ϼ�ȥ���������µĶ���
     * 
     * @param origAmt
     * @param subAmt
     * @return
     */
    public static BigDecimal substract(BigDecimal origAmt, BigDecimal subAmt) {
        if (origAmt != null && subAmt != null) {
            origAmt = origAmt.subtract(subAmt);
        }

        return origAmt;
    }
}
