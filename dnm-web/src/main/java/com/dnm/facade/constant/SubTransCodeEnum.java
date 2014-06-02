/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * �ӽ�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubTransCodeEnum.java, v 0.1 2014-5-13 ����2:07:55 hongmin.zhonghm Exp $
 */
public enum SubTransCodeEnum {

    /** ��ͨͶ�� */
    NORMAL_INVEST(TransCodeEnum.INVEST.getCode() + "0001", "��ͨͶ��"),

    /** ��ͨ�ؿ� */
    NORMAL_CASHBACK(TransCodeEnum.CASHBACK.getCode() + "0001", "��ͨ�ؿ�"),

    /** ���ϳ�ֵ */
    ONLINE_DEPOSIT(TransCodeEnum.DEPOSIT.getCode() + "0001", "���ϳ�ֵ"),

    /** ���³�ֵ */
    OFFLINE_DEPOSIT(TransCodeEnum.DEPOSIT.getCode() + "0002", "���³�ֵ"),

    /** ���� */
    WITHDRAW(TransCodeEnum.WITHDRAW.getCode() + "0001", "����"),

    ;

    /** ö�ٱ��� */
    private final String                         code;

    /** ����˵�� */
    private final String                         description;

    /** ö�ٻ��� */
    private static Map<String, SubTransCodeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SubTransCodeEnum>();
        SubTransCodeEnum[] enums = SubTransCodeEnum.values();
        for (SubTransCodeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private SubTransCodeEnum(String code, String description) {
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
    public static SubTransCodeEnum getByCode(String code) {
        return enumMap.get(code);
    }
}