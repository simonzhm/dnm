/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.resultcode;

import com.dnm.core.common.util.StringUtil;

/**
 * <p>�ܸ������ö�١�
 * <ul>��ѭ����֧����׼������ʽ��
 * <li> <code>DNM_RS_</code> [�̶�ǰ׺]
 * <li> <code>1:INFO; 3:WARN; 5:ERROR; 7:FATAL</code> [�����뼶��]
 * <li> <code>0:�ɹ�; 1:ҵ�����; 2:ϵͳ����; 3:����������</code> [����������]
 * <li> <code>001:dnm; 002:xxx ;003:xxx</code> [ģ��]
 * <li> <code>0XXX:ͨ�ô�����; 1XXX~9XXX:ҵ�������</code> [������ϸ����]
 * </ul>
 * <ul>ҵ���������λ���壨��3λ�����벻���ƣ���000��ʼ��
 * <li> <code>1���û�ҵ����</code>
 * <li> <code>9��ͨ��ҵ����</code>
 * </ul>
 * <ul>����ͨ�ô����������
 * <li>�ɹ�:IPAY_RS_100000200
 * <li>δ֪�쳣:IPAY_RS_520000500
 * <li>��������:IPAY_RS_510000400
 * <li>�ظ��ύ:IPAY_RS_510000401
 * </ul>
 * </p>
 * 
 * @author hongmin.zhonghm
 * @version $Id: ResultCodeEnum.java, v 0.1 2014-4-7 ����8:24:51 hongmin.zhonghm Exp $
 */
public enum ResultCodeEnum {
    //========================================================================//
    //                            ���������                                                                                   //
    //========================================================================//

    /** ����ɹ� */
    SUCCESS("DNM_RS_100000200", "success"),

    /** ϵͳ�쳣 */
    SYSTEM_ERROR("DNM_RS_520000500", "system error"),

    /** �������Ϸ� */
    PARAM_ILLEGAL("DNM_RS_510000400", "request param illegal"),

    /** �ظ����� */
    REPEAT_REQUEST("DNM_RS_510000401", "repeat request"),

    //========================================================================//
    //                            ͨ�ý����                                                                                           //
    //========================================================================//
    /** ģ������������У��ʧ�� */
    MODEL_INTEGRITY_CHECK_FAIL("DNM_RS_510019000", "model integrity check fail"),

    /** ҵ�����ݲ����� */
    BIZ_PARAM_ILLEGAL("DNM_RS_510019001", "biz data not integrity"),

    /** Ψһ��Լ�� */
    DUPLICATE_KEY("DNM_RS_510019002", "duplicate key"),

    /** ���ݿ���������쳣 */
    DB_UPDATE_COUNT_ERROR("DNM_RS_510019003", "db update count error"),

    //========================================================================//
    //                            ҵ������                                                                                           //
    //========================================================================//
    /**================== �û�ҵ�������  1xxx ====================*/
    /** �û�ҵ������� */
    USER_BIZ_ERROR("DNM_RS_510011000", "user biz process error"),

    /**================== �˻�ҵ�������  2xxx ====================*/
    /** �˺Ų����� */
    ACCOUNT_NOT_EXISTS("DNM_RS_510012000", "account not exists"),
    /** �˻����Ϸ� */
    ACCOUNT_ILLEGAL("DNM_RS_510012001", "account illegal"),
    /** �˻���ѯʧ�� */
    ACCOUNT_QUERY_FAIL("DNM_RS_510012002", "account query fail"),

    /**================== Ͷ��ҵ�������  3xxx ====================*/
    /** �û�ҵ������� */
    INVEST_BIZ_ERROR("DNM_RS_510011000", "user biz process error"),

    /**================== ���������  4xxx ====================*/
    /** ����ʧ�� */
    ACCOUNT_TRANS_FAIL("DNM_RS_510014000", "account transfer fail"),

    ;

    /** ������� */
    private String code;

    /** ���� */
    private String description;

    /**
     * ˽�й��췽��
     * 
     * @param code �����
     * @param desc ������Ӧ������
     */
    private ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.description = desc;
    }

    /**
     * ��ȡ�ַ�����ʽ�Ľ������
     * 
     * @return �������
     */
    public String getCode() {
        return code;
    }

    /**
     * ��ȡ������Ӧ������
     * 
     * @return ���������
     */
    public String getDescription() {
        return description;
    }

    /**
     * ͨ��ö��<code>code</code>���ö�١�
     *
     * @param code �ַ��������
     * @return ö�ٽ���룬���û���򷵻�null
     */
    public static ResultCodeEnum getByCode(String code) {
        for (ResultCodeEnum icbResultCode : values()) {
            if (StringUtil.equals(icbResultCode.getCode(), code)) {
                return icbResultCode;
            }
        }
        return null;
    }

    /**
     * ͨ��ö��<code>name</code>���ö�١�
     *
     *
     * @param name ö����
     * @return ���ֶ�Ӧ��ö�٣����û�з���null
     */
    public static ResultCodeEnum getByName(String name) {

        for (ResultCodeEnum icbResultCode : values()) {
            if (StringUtil.equals(icbResultCode.name(), name)) {
                return icbResultCode;
            }
        }
        return null;
    }
}
