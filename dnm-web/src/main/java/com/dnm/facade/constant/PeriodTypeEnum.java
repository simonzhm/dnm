/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * ���޶���
 * �������ͣ���Y����M����D����S��
 * 
 * @author hongmin.zhonghm
 * @version $Id: PeriodTypeEnum.java, v 0.1 2014-5-26 ����12:13:34 hongmin.zhonghm Exp $
 */
public enum PeriodTypeEnum {

    /** �ȶϢ */
    YEAR("Y", "��"),

    /** �ȶϢ */
    MONTH("M", "��"),

    /** �ȶ�� */
    DAY("D", "��"),

    /** ���¸�Ϣ���ڻ��� */
    SECOND("S", "��"),

    ;

    /** ���� */
    private final String                       code;

    /** ���� */
    private final String                       value;

    /** ö�ٻ��� */
    private static Map<String, PeriodTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, PeriodTypeEnum>();
        PeriodTypeEnum[] enums = PeriodTypeEnum.values();
        for (PeriodTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private PeriodTypeEnum(String code, String description) {
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
    public static PeriodTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
