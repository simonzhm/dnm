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
 * �˻���������
 * 
 * @author hongmin.zhonghm
 * @version $Id: ThirdAccountTypeEnum.java.java, v 0.1 2014-5-5 ����11:22:38 hongmin.zhonghm Exp $
 */
public enum ThirdAccountTypeEnum {
    /** ���ǿ� */
    CREDIT_CARD(SecondAccountTypeEnum.CREDIT_CARD.getCode() + "01", "���ǿ�",
                AccountDirectionEnum.CREDIT),

    /** ��ǿ� */
    DEBIT_CARD(SecondAccountTypeEnum.DEBIT_CARD.getCode() + "01", "��ǿ�", AccountDirectionEnum.DEBIT),

    /** ������� */
    PLATFORM_BALANCE(SecondAccountTypeEnum.PLATFORM_BALANCE.getCode() + "01", "�������",
                     AccountDirectionEnum.DEBIT),

    /** ������� */
    PLATFORM_DUEIN(SecondAccountTypeEnum.PLATFORM_BALANCE.getCode() + "02", "�������",
                   AccountDirectionEnum.DEBIT),

    /** ������Ϣ */
    PLATFORM_DUEIN_INTEREST(SecondAccountTypeEnum.PLATFORM_DUEIN.getCode() + "01", "������Ϣ",
                            AccountDirectionEnum.CREDIT),

    /** ���ս��� */
    PLATFORM_DUEIN_PRICE(SecondAccountTypeEnum.PLATFORM_DUEIN.getCode() + "02", "���ս��� ",
                         AccountDirectionEnum.CREDIT),

    /** ���ս��� */
    PLATFORM_PRICE(SecondAccountTypeEnum.PLATFORM_RECEIVED.getCode() + "01", "���ս��� ",
                   AccountDirectionEnum.CREDIT),

    /** ������Ϣ */
    PLATFORM_INTEREST(SecondAccountTypeEnum.PLATFORM_RECEIVED.getCode() + "02", "������Ϣ",
                      AccountDirectionEnum.CREDIT),

    /** ƽ̨���� */
    PLATFORM_COST(SecondAccountTypeEnum.PLATFORM_COST.getCode() + "01", "ƽ̨����",
                  AccountDirectionEnum.DEBIT),

    ;

    /** ö�ٱ��� */
    private final String                             code;

    /** ���� */
    private final String                             name;

    /** ������� */
    private final AccountDirectionEnum               direction;

    /** ö�ٻ��� */
    private static Map<String, ThirdAccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, ThirdAccountTypeEnum>();
        ThirdAccountTypeEnum[] enums = ThirdAccountTypeEnum.values();
        for (ThirdAccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * ��ȡƽ̨����˻�������
     * 
     * @return
     */
    public static List<ThirdAccountTypeEnum> getPlatformSubAccountTypes() {
        List<ThirdAccountTypeEnum> types = new ArrayList<ThirdAccountTypeEnum>();
        types.add(ThirdAccountTypeEnum.PLATFORM_BALANCE);
        types.add((ThirdAccountTypeEnum.PLATFORM_DUEIN));
        types.add((ThirdAccountTypeEnum.PLATFORM_DUEIN_INTEREST));
        types.add((ThirdAccountTypeEnum.PLATFORM_INTEREST));
        types.add((ThirdAccountTypeEnum.PLATFORM_DUEIN_PRICE));
        types.add((ThirdAccountTypeEnum.PLATFORM_PRICE));
        types.add((ThirdAccountTypeEnum.PLATFORM_COST));

        return types;
    }

    /**
     * @param code
     * @param name
     */
    private ThirdAccountTypeEnum(String code, String description, AccountDirectionEnum direction) {
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
    public static ThirdAccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
