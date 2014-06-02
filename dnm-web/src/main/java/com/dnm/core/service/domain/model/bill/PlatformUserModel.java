/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;
import java.util.Map;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 网贷平台用户领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformUserModel.java, v 0.1 2014-5-5 下午1:12:50 hongmin.zhonghm Exp $
 */
public class PlatformUserModel extends DomainModel {

    /** ID */
    private String                                id;

    /** 用户ID */
    private String                                userId;

    /** 平台ID */
    private String                                platformId;

    /** 平台用户ID */
    private String                                platformUserId;

    /** 投标总额 */
    private BigDecimal                            totalInvestAmt = new BigDecimal(0);

    /** 账户 */
    private Map<String, PlatformUserAccountModel> platformUserAccountModel;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "PlatformUserModel.id is empty");
        AssertUtil.notBlank(userId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "PlatformUserModel.userId is empty");
        AssertUtil.notBlank(platformId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "PlatformUserModel.platformId is empty");
        AssertUtil.isTrue(StringUtil.isMeetLength(platformId, 16),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "length of PlatformUserModel.platformId is illegal,ecpect 16");

    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>userId</tt>.
     * 
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     * 
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter method for property <tt>platformId</tt>.
     * 
     * @return property value of platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Setter method for property <tt>platformId</tt>.
     * 
     * @param platformId value to be assigned to property platformId
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
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

    /**
     * Getter method for property <tt>totalInvestAmt</tt>.
     * 
     * @return property value of totalInvestAmt
     */
    public BigDecimal getTotalInvestAmt() {
        return totalInvestAmt;
    }

    /**
     * Setter method for property <tt>totalInvestAmt</tt>.
     * 
     * @param totalInvestAmt value to be assigned to property totalInvestAmt
     */
    public void setTotalInvestAmt(BigDecimal totalInvestAmt) {
        this.totalInvestAmt = totalInvestAmt;
    }

    /**
     * Getter method for property <tt>platformUserAccountModel</tt>.
     * 
     * @return property value of platformUserAccountModel
     */
    public Map<String, PlatformUserAccountModel> getPlatformUserAccountModel() {
        return platformUserAccountModel;
    }

    /**
     * Setter method for property <tt>platformUserAccountModel</tt>.
     * 
     * @param platformUserAccountModel value to be assigned to property platformUserAccountModel
     */
    public void setPlatformUserAccountModel(Map<String, PlatformUserAccountModel> platformUserAccountModel) {
        this.platformUserAccountModel = platformUserAccountModel;
    }

}
