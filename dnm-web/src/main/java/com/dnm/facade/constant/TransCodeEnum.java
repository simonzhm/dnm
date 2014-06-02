/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * ����������
 * 
 * @author hongmin.zhonghm
 * @version $Id: TransCodeEnum.java, v 0.1 2014-5-13 ����2:08:16 hongmin.zhonghm Exp $
 */
public enum TransCodeEnum {

    /** Ͷ�� */
    INVEST("31", "Ͷ��"),

    /** �ؿ� */
    CASHBACK("32", "�ؿ�"),

    /** ��ֵ */
    DEPOSIT("41", "��ֵ"),

    /** ���� */
    WITHDRAW("51", "����"),

    ;

    /** ö�ٱ��� */
    private final String                      code;

    /** ����˵�� */
    private final String                      description;

    /** ö�ٻ��� */
    private static Map<String, TransCodeEnum> enumMap;

    static {
        enumMap = new HashMap<String, TransCodeEnum>();
        TransCodeEnum[] enums = TransCodeEnum.values();
        for (TransCodeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private TransCodeEnum(String code, String description) {
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
    public static TransCodeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
