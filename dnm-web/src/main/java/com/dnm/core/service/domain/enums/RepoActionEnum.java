/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.enums;

/**
 * �ִ���������ö��
 * 
 * @author hongmin.zhonghm
 * @version $Id: RepoActionEnum.java, v 0.1 2014-4-13 ����12:59:50 hongmin.zhonghm Exp $
 */
public enum RepoActionEnum {
    /** ������� */
    STORE("store", "�־û�����"),

    /** ���²��� */
    RESTORE("restore", "���²���"),

    /** ɾ������ */
    DEPRECATE("deprecate", "ɾ������"),

    /** ������� */
    ACTIVE("active", "�������"),

    /** ���ز��� */
    LOAD("load", "���ز���"),

    /** ���ز�������ָ���������� */
    RELOAD("reload", "���������ز���"), ;

    /** �������� */
    private final String code;

    /** ���� */
    private final String desc;

    /**
     * ���췽��
     * @param code ��������
     * @param desc ����
     */
    private RepoActionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * ͨ��ö��<code>code</code>���ö��
     * @param code ��������
     * @return ������������
     */
    public static RepoActionEnum getByCode(String code) {
        for (RepoActionEnum operateEnum : values()) {
            if (operateEnum.getCode().equals(code)) {
                return operateEnum;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>payToolCode</tt>.
     *
     * @return property value of payToolCode
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }
}
