/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * �˻�����
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTypeEnum.java, v 0.1 2014-5-5 ����11:22:38 hongmin.zhonghm Exp $
 */
public enum AccountTypeEnum {

    /** ���� */
    BANK("10", "����"),

    /** ƽ̨ */
    PLATFORM("20", "ƽ̨"),

    ;

    /** ö�ٱ��� */
    private final String                        code;

    /** ����˵�� */
    private final String                        description;

    /** ö�ٻ��� */
    private static Map<String, AccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, AccountTypeEnum>();
        AccountTypeEnum[] enums = AccountTypeEnum.values();
        for (AccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private AccountTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
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
     * Getter method for property <tt>description</tt>.
     * 
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * ͨ��ö��<code>code</code>���ö�١�
     *
     * @param code  ����
     * @return      ö��
     */
    public static AccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
