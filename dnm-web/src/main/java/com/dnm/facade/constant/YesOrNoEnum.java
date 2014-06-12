/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * �ǻ��ö��
 * 
 * @author hongmin.zhonghm
 * @version $Id: YesOrNoEnum.java, v 0.1 2014-5-5 ����1:54:09 hongmin.zhonghm Exp $
 */
public enum YesOrNoEnum {
    /** Yes */
    YES("Y", "Yes"),

    /** No */
    NO("N", "No"),

    ;

    /** ���ұ��� */
    private final String                    code;

    /** ���ұ�� */
    private final String                    value;

    /** ö�ٻ��� */
    private static Map<String, YesOrNoEnum> enumMap;

    static {
        enumMap = new HashMap<String, YesOrNoEnum>();
        YesOrNoEnum[] enums = YesOrNoEnum.values();
        for (YesOrNoEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private YesOrNoEnum(String code, String description) {
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
    public static YesOrNoEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
