/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.constant;

import java.util.HashMap;
import java.util.Map;

import com.dnm.facade.constant.SubAccountTransCodeEnum;
import com.dnm.facade.constant.SubAccountTypeEnum;

/**
 * ������˹���
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransRuleEnum.java, v 0.1 2014-5-13 ����2:08:16 hongmin.zhonghm Exp $
 */
public enum AccountTransRuleEnum {

    /** ������Ϣ */
    DUEIN_INTEREST(SubAccountTransCodeEnum.DUEIN_INTEREST, SubAccountTypeEnum.PLATFORM_DUEIN,
                   SubAccountTypeEnum.PLATFORM_DUEIN_INTEREST),

    /** �������� */
    DUEIN_REINVEST_PRICE(SubAccountTransCodeEnum.DUEIN_REINVEST_PRICE,
                         SubAccountTypeEnum.PLATFORM_DUEIN, SubAccountTypeEnum.PLATFORM_DUEIN_PRICE),

    /** ��ͨͶ�� */
    NORMAL_INVEST(SubAccountTransCodeEnum.NORMAL_INVEST, SubAccountTypeEnum.PLATFORM_DUEIN,
                  SubAccountTypeEnum.PLATFORM_BALANCE),

    /** ����ؿ� */
    PRINCIPAL_RECEIVE(SubAccountTransCodeEnum.PRINCIPAL_RECEIVE,
                      SubAccountTypeEnum.PLATFORM_BALANCE, SubAccountTypeEnum.PLATFORM_DUEIN),

    /** ��Ϣ�ؿ� */
    INTEREST_RECEIVE(SubAccountTransCodeEnum.INTEREST_RECEIVE, SubAccountTypeEnum.PLATFORM_BALANCE,
                     SubAccountTypeEnum.PLATFORM_DUEIN),

    /** �����ؿ� */
    REINVEST_PRICE_RECEIVE(SubAccountTransCodeEnum.REINVEST_PRICE_RECEIVE,
                           SubAccountTypeEnum.PLATFORM_BALANCE, SubAccountTypeEnum.PLATFORM_DUEIN),

    /** ��Ϣ���� */
    INTEREST_FEE(SubAccountTransCodeEnum.INTEREST_FEE, SubAccountTypeEnum.PLATFORM_COST,
                 SubAccountTypeEnum.PLATFORM_BALANCE),

    /** ��Ա���� */
    VIP_FEE(SubAccountTransCodeEnum.VIP_FEE, SubAccountTypeEnum.PLATFORM_COST,
            SubAccountTypeEnum.PLATFORM_BALANCE),

    /** ���³�ֵ�������� */
    OFFLINE_PRICE(SubAccountTransCodeEnum.OFFLINE_PRICE, SubAccountTypeEnum.PLATFORM_BALANCE,
                  SubAccountTypeEnum.PLATFORM_PRICE),

    /** Ͷ������ */
    INVEST_PRICE(SubAccountTransCodeEnum.INVEST_PRICE, SubAccountTypeEnum.PLATFORM_BALANCE,
                 SubAccountTypeEnum.PLATFORM_PRICE),

    /** ��Ϣ���� */
    INTEREST(SubAccountTransCodeEnum.INTEREST, SubAccountTypeEnum.PLATFORM_DUEIN_INTEREST,
             SubAccountTypeEnum.PLATFORM_INTEREST),

    /** ��Ϣ���� */
    OVERDUE_INTEREST(SubAccountTransCodeEnum.OVERDUE_INTEREST, SubAccountTypeEnum.PLATFORM_BALANCE,
                     SubAccountTypeEnum.PLATFORM_INTEREST),

    /** �������� */
    RE_INVEST_PRICE(SubAccountTransCodeEnum.RE_INVEST_PRICE,
                    SubAccountTypeEnum.PLATFORM_DUEIN_PRICE, SubAccountTypeEnum.PLATFORM_PRICE),

    /** ������� */
    PROMOTION_PRICE(SubAccountTransCodeEnum.PROMOTION_PRICE, SubAccountTypeEnum.PLATFORM_BALANCE,
                    SubAccountTypeEnum.PLATFORM_PRICE),

    /** ���Ͻ�ǿ���ֵ */
    ONLINE_DEBIT_DEPOSIT(SubAccountTransCodeEnum.ONLINE_DEBIT_DEPOSIT,
                         SubAccountTypeEnum.PLATFORM_BALANCE, SubAccountTypeEnum.DEBIT_CARD),

    /** �������ÿ���ֵ */
    ONLINE_CREDIT_DEPOSIT(SubAccountTransCodeEnum.ONLINE_CREDIT_DEPOSIT,
                          SubAccountTypeEnum.PLATFORM_BALANCE, SubAccountTypeEnum.CREDIT_CARD),

    /** ���½�ǿ���ֵ */
    OFFLINE_DEPOSIT(SubAccountTransCodeEnum.OFFLINE_DEPOSIT, SubAccountTypeEnum.PLATFORM_BALANCE,
                    SubAccountTypeEnum.DEBIT_CARD),

    /** ���� */
    WITHDRAW(SubAccountTransCodeEnum.WITHDRAW, SubAccountTypeEnum.DEBIT_CARD,
             SubAccountTypeEnum.PLATFORM_BALANCE),

    ;

    /** �ӽ����� */
    private final SubAccountTransCodeEnum            subCode;

    /** �跽�˻����� */
    private final SubAccountTypeEnum                 debitSubAccountType;

    /** �����˻����� */
    private final SubAccountTypeEnum                 creditSubAccountType;

    /** ö�ٻ��� */
    private static Map<String, AccountTransRuleEnum> enumMap;

    static {
        enumMap = new HashMap<String, AccountTransRuleEnum>();
        AccountTransRuleEnum[] enums = AccountTransRuleEnum.values();
        for (AccountTransRuleEnum item : enums) {
            enumMap.put(item.getSubCode().getCode(), item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private AccountTransRuleEnum(SubAccountTransCodeEnum subCode,
                                 SubAccountTypeEnum debitSubAccountType,
                                 SubAccountTypeEnum creditSubAccountType) {
        this.subCode = subCode;
        this.debitSubAccountType = debitSubAccountType;
        this.creditSubAccountType = creditSubAccountType;
    }

    /**
     * ͨ��ö��<code>code</code>���ö�١�
     *
     * @param code  ����
     * @return      ö��
     */
    public static AccountTransRuleEnum getByCode(String code) {
        return enumMap.get(code);
    }

    /**
     * Getter method for property <tt>subCode</tt>.
     * 
     * @return property value of subCode
     */
    public SubAccountTransCodeEnum getSubCode() {
        return subCode;
    }

    /**
     * Getter method for property <tt>debitSubAccountType</tt>.
     * 
     * @return property value of debitSubAccountType
     */
    public SubAccountTypeEnum getDebitSubAccountType() {
        return debitSubAccountType;
    }

    /**
     * Getter method for property <tt>creditSubAccountType</tt>.
     * 
     * @return property value of creditSubAccountType
     */
    public SubAccountTypeEnum getCreditSubAccountType() {
        return creditSubAccountType;
    }

}
