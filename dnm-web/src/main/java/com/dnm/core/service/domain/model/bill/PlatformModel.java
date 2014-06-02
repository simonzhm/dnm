/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 网贷平台领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformModel.java, v 0.1 2014-5-5 下午1:12:50 hongmin.zhonghm Exp $
 */
public class PlatformModel extends DomainModel {

    /** ID */
    private String                  id;

    /** 平台名称 */
    private String                  name;

    /** 描述 */
    private String                  description;

    /** 银行名称 */
    private String                  url;

    /** 银行方向 */
    private String                  userId;

    /** 已有平台账户列表 */
    private List<PlatformUserModel> hisPlatformUserModels;

    /** 新增平台账户列表 */
    private List<PlatformUserModel> newPlatformUserModels;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        //如果不为空，说明本次存的是平台用户模型，否则存的平台模型
        if (isAddPlatformUser()) {
            for (PlatformUserModel puModel : newPlatformUserModels) {
                puModel.dataIntegrityCheck();
            }
        } else {
            AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
                "PlatformModel.id is empty");
            AssertUtil.notBlank(name, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
                "PlatformModel.name is empty");
        }
    }

    /**
     * 是否新增平台用户模型
     * 
     * @return
     */
    public boolean isAddPlatformUser() {
        return !CollectionUtils.isEmpty(newPlatformUserModels);
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
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
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
     * Setter method for property <tt>description</tt>.
     * 
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
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
     * Getter method for property <tt>hisPlatformUserModels</tt>.
     * 
     * @return property value of hisPlatformUserModels
     */
    public List<PlatformUserModel> getHisPlatformUserModels() {
        return hisPlatformUserModels;
    }

    /**
     * Setter method for property <tt>hisPlatformUserModels</tt>.
     * 
     * @param hisPlatformUserModels value to be assigned to property hisPlatformUserModels
     */
    public void setHisPlatformUserModels(List<PlatformUserModel> hisPlatformUserModels) {
        this.hisPlatformUserModels = hisPlatformUserModels;
    }

    /**
     * Getter method for property <tt>newPlatformUserModels</tt>.
     * 
     * @return property value of newPlatformUserModels
     */
    public List<PlatformUserModel> getNewPlatformUserModels() {
        return newPlatformUserModels;
    }

    /**
     * Setter method for property <tt>newPlatformUserModels</tt>.
     * 
     * @param newPlatformUserModels value to be assigned to property newPlatformUserModels
     */
    public void setNewPlatformUserModels(List<PlatformUserModel> newPlatformUserModels) {
        this.newPlatformUserModels = newPlatformUserModels;
    }

}
