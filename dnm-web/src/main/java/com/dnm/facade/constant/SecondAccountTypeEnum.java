/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * �˻���������
 * 
 * @author hongmin.zhonghm
 * @version $Id: SecondAccountTypeEnum.java.java, v 0.1 2014-5-5 ����11:22:38 hongmin.zhonghm Exp $
 */
public enum SecondAccountTypeEnum {

    /** ���ǿ� */
    CREDIT_CARD(AccountTypeEnum.BANK.getCode() + "01", "���ǿ�", AccountDirectionEnum.CREDIT),

    /** ��ǿ� */
    DEBIT_CARD(AccountTypeEnum.BANK.getCode() + "02", "��ǿ�", AccountDirectionEnum.DEBIT),

    /** ��� */
    PLATFORM_BALANCE(AccountTypeEnum.PLATFORM.getCode() + "01", "���", AccountDirectionEnum.DEBIT),

    /** ���� */
    PLATFORM_DUEIN(AccountTypeEnum.PLATFORM.getCode() + "02", "����", AccountDirectionEnum.CREDIT),

    /** ���� */
    PLATFORM_RECEIVED(AccountTypeEnum.PLATFORM.getCode() + "03", "����", AccountDirectionEnum.CREDIT),

    /** ���� */
    PLATFORM_COST(AccountTypeEnum.PLATFORM.getCode() + "04", "����", AccountDirectionEnum.DEBIT),

    ;

    /** ö�ٱ��� */
    private final String                              code;

    /** ���� */
    private final String                              name;

    /** ������� */
    private final AccountDirectionEnum                direction;

    /** ö�ٻ��� */
    private static Map<String, SecondAccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SecondAccountTypeEnum>();
        SecondAccountTypeEnum[] enums = SecondAccountTypeEnum.values();
        for (SecondAccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param name
     */
    private SecondAccountTypeEnum(String code, String description, AccountDirectionEnum direction) {
        this.code = code;
        this.name = description;
        this.direction = direction;
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
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>direction</tt>.
     * 
     * @return property value of direction
     */
    public AccountDirectionEnum getDirection() {
        return direction;
    }

    /**
     * ͨ��ö��<code>code</code>���ö�١�
     *
     * @param code  ����
     * @return      ö��
     */
    public static SecondAccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
