/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.constant;

import java.util.HashMap;
import java.util.Map;

import com.dnm.facade.constant.SubAccountTransCodeEnum;
import com.dnm.facade.constant.ThirdAccountTypeEnum;

/**
 * 账务记账规则
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransRuleEnum.java, v 0.1 2014-5-13 下午2:08:16 hongmin.zhonghm Exp $
 */
public enum AccountTransRuleEnum {

    /** 待收利息 */
    DUEIN_INTEREST(SubAccountTransCodeEnum.DUEIN_INTEREST, ThirdAccountTypeEnum.PLATFORM_DUEIN,
                   ThirdAccountTypeEnum.PLATFORM_DUEIN_INTEREST),

    /** 待收续奖 */
    DUEIN_REINVEST_PRICE(SubAccountTransCodeEnum.DUEIN_REINVEST_PRICE,
                         ThirdAccountTypeEnum.PLATFORM_DUEIN,
                         ThirdAccountTypeEnum.PLATFORM_DUEIN_PRICE),

    /** 普通投标 */
    NORMAL_INVEST(SubAccountTransCodeEnum.NORMAL_INVEST, ThirdAccountTypeEnum.PLATFORM_DUEIN,
                  ThirdAccountTypeEnum.PLATFORM_BALANCE),

    /** 本金回款 */
    PRINCIPAL_RECEIVE(SubAccountTransCodeEnum.PRINCIPAL_RECEIVE,
                      ThirdAccountTypeEnum.PLATFORM_BALANCE, ThirdAccountTypeEnum.PLATFORM_DUEIN),

    /** 利息回款 */
    INTEREST_RECEIVE(SubAccountTransCodeEnum.INTEREST_RECEIVE,
                     ThirdAccountTypeEnum.PLATFORM_BALANCE, ThirdAccountTypeEnum.PLATFORM_DUEIN),

    /** 续奖回款 */
    REINVEST_PRICE_RECEIVE(SubAccountTransCodeEnum.REINVEST_PRICE_RECEIVE,
                           ThirdAccountTypeEnum.PLATFORM_BALANCE,
                           ThirdAccountTypeEnum.PLATFORM_DUEIN),

    /** 利息费用 */
    INTEREST_FEE(SubAccountTransCodeEnum.INTEREST_FEE, ThirdAccountTypeEnum.PLATFORM_COST,
                 ThirdAccountTypeEnum.PLATFORM_BALANCE),

    /** 会员费用 */
    VIP_FEE(SubAccountTransCodeEnum.VIP_FEE, ThirdAccountTypeEnum.PLATFORM_COST,
            ThirdAccountTypeEnum.PLATFORM_BALANCE),

    /** 线下充值奖励发放 */
    OFFLINE_PRICE(SubAccountTransCodeEnum.OFFLINE_PRICE, ThirdAccountTypeEnum.PLATFORM_BALANCE,
                  ThirdAccountTypeEnum.PLATFORM_PRICE),

    /** 投奖发放 */
    INVEST_PRICE(SubAccountTransCodeEnum.INVEST_PRICE, ThirdAccountTypeEnum.PLATFORM_BALANCE,
                 ThirdAccountTypeEnum.PLATFORM_PRICE),

    /** 利息发放 */
    INTEREST(SubAccountTransCodeEnum.INTEREST, ThirdAccountTypeEnum.PLATFORM_DUEIN_INTEREST,
             ThirdAccountTypeEnum.PLATFORM_INTEREST),

    /** 罚息发放 */
    OVERDUE_INTEREST(SubAccountTransCodeEnum.OVERDUE_INTEREST,
                     ThirdAccountTypeEnum.PLATFORM_BALANCE, ThirdAccountTypeEnum.PLATFORM_INTEREST),

    /** 续奖发放 */
    RE_INVEST_PRICE(SubAccountTransCodeEnum.RE_INVEST_PRICE,
                    ThirdAccountTypeEnum.PLATFORM_DUEIN_PRICE, ThirdAccountTypeEnum.PLATFORM_PRICE),

    /** 活动奖发放 */
    PROMOTION_PRICE(SubAccountTransCodeEnum.PROMOTION_PRICE, ThirdAccountTypeEnum.PLATFORM_BALANCE,
                    ThirdAccountTypeEnum.PLATFORM_PRICE),

    /** 线上借记卡充值 */
    ONLINE_DEBIT_DEPOSIT(SubAccountTransCodeEnum.ONLINE_DEBIT_DEPOSIT,
                         ThirdAccountTypeEnum.PLATFORM_BALANCE, ThirdAccountTypeEnum.DEBIT_CARD),

    /** 线上贷记卡充值 */
    ONLINE_CREDIT_DEPOSIT(SubAccountTransCodeEnum.ONLINE_CREDIT_DEPOSIT,
                          ThirdAccountTypeEnum.PLATFORM_BALANCE, ThirdAccountTypeEnum.CREDIT_CARD),

    /** 线下借记卡充值 */
    OFFLINE_DEPOSIT(SubAccountTransCodeEnum.OFFLINE_DEPOSIT, ThirdAccountTypeEnum.PLATFORM_BALANCE,
                    ThirdAccountTypeEnum.DEBIT_CARD),

    /** 提现 */
    WITHDRAW(SubAccountTransCodeEnum.WITHDRAW, ThirdAccountTypeEnum.DEBIT_CARD,
             ThirdAccountTypeEnum.PLATFORM_BALANCE),

    ;

    /** 子交易码 */
    private final SubAccountTransCodeEnum            subCode;

    /** 借方账户类型 */
    private final ThirdAccountTypeEnum               debitSubAccountType;

    /** 贷方账户类型 */
    private final ThirdAccountTypeEnum               creditSubAccountType;

    /** 枚举缓存 */
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
                                 ThirdAccountTypeEnum debitSubAccountType,
                                 ThirdAccountTypeEnum creditSubAccountType) {
        this.subCode = subCode;
        this.debitSubAccountType = debitSubAccountType;
        this.creditSubAccountType = creditSubAccountType;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code  简码
     * @return      枚举
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
    public ThirdAccountTypeEnum getDebitSubAccountType() {
        return debitSubAccountType;
    }

    /**
     * Getter method for property <tt>creditSubAccountType</tt>.
     * 
     * @return property value of creditSubAccountType
     */
    public ThirdAccountTypeEnum getCreditSubAccountType() {
        return creditSubAccountType;
    }

}
