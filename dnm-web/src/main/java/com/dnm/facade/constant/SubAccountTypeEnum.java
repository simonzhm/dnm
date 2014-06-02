/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �˻�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTypeEnum.java.java, v 0.1 2014-5-5 ����11:22:38 hongmin.zhonghm Exp $
 */
public enum SubAccountTypeEnum {

    /** ���ǿ� */
    CREDIT_CARD(AccountTypeEnum.BANK.getCode() + "01", "���ǿ�", AccountDirectionEnum.CREDIT),

    /** ��ǿ� */
    DEBIT_CARD(AccountTypeEnum.BANK.getCode() + "02", "��ǿ�", AccountDirectionEnum.DEBIT),

    /** ������� */
    PLATFORM_BALANCE(AccountTypeEnum.PLATFORM.getCode() + "01", "�������", AccountDirectionEnum.DEBIT),

    /** ������� */
    PLATFORM_DUEIN(AccountTypeEnum.PLATFORM.getCode() + "02", "�������", AccountDirectionEnum.DEBIT),

    /** ������Ϣ */
    PLATFORM_DUEIN_INTEREST(AccountTypeEnum.PLATFORM.getCode() + "03", "������Ϣ",
                            AccountDirectionEnum.CREDIT),

    /** ������Ϣ */
    PLATFORM_INTEREST(AccountTypeEnum.PLATFORM.getCode() + "04", "������Ϣ",
                      AccountDirectionEnum.CREDIT),

    /** ���ս��� */
    PLATFORM_DUEIN_PRICE(AccountTypeEnum.PLATFORM.getCode() + "05", "���ս��� ",
                         AccountDirectionEnum.CREDIT),

    /** ���ս��� */
    PLATFORM_PRICE(AccountTypeEnum.PLATFORM.getCode() + "06", "���ս��� ", AccountDirectionEnum.CREDIT),

    /** ƽ̨���� */
    PLATFORM_COST(AccountTypeEnum.PLATFORM.getCode() + "07", "ƽ̨����", AccountDirectionEnum.DEBIT),

    ;

    /** ö�ٱ��� */
    private final String                           code;

    /** ���� */
    private final String                           name;

    /** ������� */
    private final AccountDirectionEnum             direction;

    /** ö�ٻ��� */
    private static Map<String, SubAccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SubAccountTypeEnum>();
        SubAccountTypeEnum[] enums = SubAccountTypeEnum.values();
        for (SubAccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * ��ȡƽ̨�൱�˻�������
     * 
     * @return
     */
    public static List<SubAccountTypeEnum> getPlatformSubAccountTypes() {
        List<SubAccountTypeEnum> types = new ArrayList<SubAccountTypeEnum>();
        types.add(SubAccountTypeEnum.PLATFORM_BALANCE);
        types.add((SubAccountTypeEnum.PLATFORM_DUEIN));
        types.add((SubAccountTypeEnum.PLATFORM_DUEIN_INTEREST));
        types.add((SubAccountTypeEnum.PLATFORM_INTEREST));
        types.add((SubAccountTypeEnum.PLATFORM_DUEIN_PRICE));
        types.add((SubAccountTypeEnum.PLATFORM_PRICE));
        types.add((SubAccountTypeEnum.PLATFORM_COST));

        return types;
    }

    /**
     * @param code
     * @param name
     */
    private SubAccountTypeEnum(String code, String description, AccountDirectionEnum direction) {
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
    public static SubAccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
