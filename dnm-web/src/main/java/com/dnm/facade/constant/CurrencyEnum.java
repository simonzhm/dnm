/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * ����
 * 
 * @author hongmin.zhonghm
 * @version $Id: CurrencyEnum.java, v 0.1 2014-5-5 ����1:54:09 hongmin.zhonghm Exp $
 */
public enum CurrencyEnum {
    /** ����� */
    CNY("CNY", "156"),

    /** ��Ԫ */
    USD("USD", "840"),

    ;

    /** ���ұ��� */
    private final String                     code;

    /** ���ұ�� */
    private final String                     value;

    /** ö�ٻ��� */
    private static Map<String, CurrencyEnum> enumMap;

    static {
        enumMap = new HashMap<String, CurrencyEnum>();
        CurrencyEnum[] enums = CurrencyEnum.values();
        for (CurrencyEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private CurrencyEnum(String code, String description) {
        this.code = code;
        this.value = description;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>value</tt>.
     * 
     * @return property value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * ͨ��ö��<code>code</code>���ö�١�
     *
     * @param code  ����
     * @return      ö��
     */
    public static CurrencyEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
