/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * ���ʽ����
 * A:һ���Ի��B:�ȶϢ��C:�ȶ��D:���¸�Ϣ���ڻ���
 * 
 * @author hongmin.zhonghm
 * @version $Id: RepayMethodEnum.java, v 0.1 2014-5-25 ����10:58:00 hongmin.zhonghm Exp $
 */
public enum RepayMethodEnum {

    /** �ȶϢ */
    ALL("A", "һ���Ի���"),

    /** �ȶϢ */
    EQUALS_PRINCIPAL_INTEREST("B", "�ȶϢ"),

    /** �ȶ�� */
    EQUALS_PRINCIPAL("C", "�ȶ��"),

    /** ���¸�Ϣ���ڻ��� */
    MONTH_INTEREST("D", "���¸�Ϣ���ڻ���"),

    ;

    /** ���� */
    private final String                        code;

    /** ���� */
    private final String                        value;

    /** ö�ٻ��� */
    private static Map<String, RepayMethodEnum> enumMap;

    static {
        enumMap = new HashMap<String, RepayMethodEnum>();
        RepayMethodEnum[] enums = RepayMethodEnum.values();
        for (RepayMethodEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private RepayMethodEnum(String code, String description) {
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
    public static RepayMethodEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
