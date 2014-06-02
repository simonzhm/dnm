/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * �˻��������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountDirectionEnum.java, v 0.1 2014-5-5 ����3:43:55 hongmin.zhonghm Exp $
 */
public enum AccountDirectionEnum {

    /** �� */
    DEBIT("D", "DEBIT"),

    /** �� */
    CREDIT("C", "CREDIT"),

    ;

    /** ���ұ��� */
    private final String                             code;

    /** ���ұ�� */
    private final String                             value;

    /** ö�ٻ��� */
    private static Map<String, AccountDirectionEnum> enumMap;

    static {
        enumMap = new HashMap<String, AccountDirectionEnum>();
        AccountDirectionEnum[] enums = AccountDirectionEnum.values();
        for (AccountDirectionEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private AccountDirectionEnum(String code, String description) {
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
    public static AccountDirectionEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
