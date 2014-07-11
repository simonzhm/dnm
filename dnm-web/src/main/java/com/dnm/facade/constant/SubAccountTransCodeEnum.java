/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * �˻��ӽ�����
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubAccountTransCodeEnum.java, v 0.1 2014-5-13 ����2:07:55 hongmin.zhonghm Exp $
 */
public enum SubAccountTransCodeEnum {

    /** ������Ϣ*/
    DUEIN_INTEREST(AccountTransCodeEnum.DUEIN.getCode() + "0001", "������Ϣ"),

    /** �������� */
    DUEIN_REINVEST_PRICE(AccountTransCodeEnum.DUEIN.getCode() + "0002", "��������"),

    /** ��ͨͶ�� */
    NORMAL_INVEST(AccountTransCodeEnum.INVEST.getCode() + "0001", "��ͨͶ��"),

    /** ����ؿ� */
    PRINCIPAL_RECEIVE(AccountTransCodeEnum.RECEIVE.getCode() + "0001", "����ؿ�"),

    /** ��Ϣ�ؿ� */
    INTEREST_RECEIVE(AccountTransCodeEnum.RECEIVE.getCode() + "0002", "��Ϣ�ؿ�"),

    /** �����ؿ� */
    REINVEST_PRICE_RECEIVE(AccountTransCodeEnum.RECEIVE.getCode() + "0003", "�����ؿ�"),

    /** ��Ϣ���� */
    INTEREST_FEE(AccountTransCodeEnum.COST.getCode() + "0001", "��Ϣ����"),

    /** ��Ա���� */
    VIP_FEE(AccountTransCodeEnum.COST.getCode() + "0002", "��Ա����"),

    /** ��ֵ���� */
    DEPOSIT_FEE(AccountTransCodeEnum.COST.getCode() + "0003", "��ֵ����"),

    /** ���³�ֵ����ʵʱ���� */
    OFFLINE_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0001", "���³�ֵ����ʵʱ��"),

    /** Ͷ��ʵʱ���� */
    INVEST_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0002", "Ͷ�꽱��ʵʱ��"),

    /** ��Ϣ����  */
    INTEREST(AccountTransCodeEnum.INCOME.getCode() + "0003", "��Ϣ"),

    /** ��Ϣʵʱ����  */
    OVERDUE_INTEREST_IMED(AccountTransCodeEnum.INCOME.getCode() + "0004", "��Ϣ��ʵʱ��"),

    /** �������� */
    RE_INVEST_PRICE(AccountTransCodeEnum.INCOME.getCode() + "0005", "��Ͷ��"),

    /** ���ʵʱ���� */
    PROMOTION_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0006", "�����ʵʱ��"),
    
    /** ����ʵʱ���� */
    RE_INVEST_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0007", "��Ͷ����ʵʱ��"),

    /** ���Ͻ�ǿ���ֵ */
    ONLINE_DEBIT_DEPOSIT(AccountTransCodeEnum.DEPOSIT.getCode() + "0001", "���Ͻ�ǿ���ֵ"),

    /** �������ÿ���ֵ */
    ONLINE_CREDIT_DEPOSIT(AccountTransCodeEnum.DEPOSIT.getCode() + "0002", "�������ÿ���ֵ"),

    /** ���½�ǿ���ֵ */
    OFFLINE_DEPOSIT(AccountTransCodeEnum.DEPOSIT.getCode() + "0003", "���½�ǿ���ֵ"),

    /** ���� */
    WITHDRAW(AccountTransCodeEnum.WITHDRAW.getCode() + "0001", "����"),

    ;

    /** ö�ٱ��� */
    private final String                                code;

    /** ����˵�� */
    private final String                                description;

    /** ö�ٻ��� */
    private static Map<String, SubAccountTransCodeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SubAccountTransCodeEnum>();
        SubAccountTransCodeEnum[] enums = SubAccountTransCodeEnum.values();
        for (SubAccountTransCodeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private SubAccountTransCodeEnum(String code, String description) {
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
    public static SubAccountTransCodeEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
