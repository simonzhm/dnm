/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * ƽ̨�û����˻�֮��ӳ���ϵ����ģ��
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformUserAccountModel.java, v 0.1 2014-5-17 ����12:53:16 hongmin.zhonghm Exp $
 */
public class PlatformUserAccountModel extends DomainModel {

    /** �˻�ID */
    private String accountId;

    /** �˻������� */
    private String subAccountType;

    /** ƽ̨�û�ID */
    private String platformUserId;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.isTrue(StringUtil.isMeetLength(accountId, 20),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "length of PlatformUserAccountModel.accountId is illegal");
        AssertUtil.isTrue(StringUtil.isMeetLength(subAccountType, 4),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "length of PlatformUserAccountModel.subAccountType is illegal");
        AssertUtil.isTrue(StringUtil.isMeetLength(platformUserId, 16),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "length of PlatformUserAccountModel.platformUserId is illegal");
    }

    /**
     * Getter method for property <tt>accountId</tt>.
     * 
     * @return property value of accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Setter method for property <tt>accountId</tt>.
     * 
     * @param accountId value to be assigned to property accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter method for property <tt>subAccountType</tt>.
     * 
     * @return property value of subAccountType
     */
    public String getSubAccountType() {
        return subAccountType;
    }

    /**
     * Setter method for property <tt>subAccountType</tt>.
     * 
     * @param subAccountType value to be assigned to property subAccountType
     */
    public void setSubAccountType(String subAccountType) {
        this.subAccountType = subAccountType;
    }

    /**
     * Getter method for property <tt>platformUserId</tt>.
     * 
     * @return property value of platformUserId
     */
    public String getPlatformUserId() {
        return platformUserId;
    }

    /**
     * Setter method for property <tt>platformUserId</tt>.
     * 
     * @param platformUserId value to be assigned to property platformUserId
     */
    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId;
    }

}
