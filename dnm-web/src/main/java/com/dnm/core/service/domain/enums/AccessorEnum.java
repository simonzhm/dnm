/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.enums;

/**
 * ������ö��
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccessorEnum.java, v 0.1 2014-4-13 ����12:58:49 hongmin.zhonghm Exp $
 */
public enum AccessorEnum {

    /** �û���Ϣ������ */
    USER("USER", "�û���Ϣ������"),

    /**�˻������� */
    ACCOUNT("ACCOUNT", "�˻�������"),

    /**�˻�������(ACCOUNT_TRANS_LOG_MODEL) */
    ACCOUNT_FOR_TRANS_LOG("ACCOUNT_FOR_TRANS_LOG", "�˻�������(ACCOUNT_TRANS_LOG_MODEL)"),

    /**���з����� */
    BANK("BANK", "���з�����"),

    /**ƽ̨������ */
    PLATFORM("PLATFORM", "ƽ̨������"),

    /**ƽ̨�û������� */
    PLATFORM_USER("PLATFORM_USER", "ƽ̨�û�������"),

    /**ƽ̨�û��˻�ӳ������� */
    PLATFORM_USER_ACCOUNT("PLATFORM_USER_ACCOUNT", "ƽ̨�û��˻�ӳ�������"),
    
    /**Ͷ������� */
    INVEST_RCD("INVEST_RCD", "Ͷ�������"),
    
    /**Ͷ����ϸ������ */
    INVEST_DUEIN_RCD("INVEST_DUEIN_RCD", "Ͷ����ϸ������"),
    
    /**Ͷ����Դ�˻������� */
    INVEST_FROM_ACCOUNT("INVEST_FROM_ACCOUNT", "Ͷ����Դ�˻�������"),
    
    /**Ͷ�꽱�����÷����� */
    INVEST_PRICE_COST("INVEST_PRICE_COST", "Ͷ�꽱�����÷�����"),

    /**�˻�������־������ */
    ACCOUNT_TRANS_LOG("ACCOUNT_TRANS_LOG", "�˻�������־������"),

    /**�˻���־������ */
    ACCOUNT_LOG("ACCOUNT_LOG", "�˻���־������"),

    ;

    /** ���� */
    private final String code;

    /** ���� */
    private final String description;

    /**
     * ˽�й��췽��
     * 
     * @param code          ����
     * @param description   ����
     */
    private AccessorEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the description.
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
    public static AccessorEnum getByCode(String code) {
        for (AccessorEnum accessor : values()) {
            if (accessor.getCode().equals(code)) {
                return accessor;
            }
        }
        return null;
    }
}
