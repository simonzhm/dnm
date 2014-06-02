/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmPlatformDAO;
import com.dnm.core.common.dal.dataobject.DnmPlatformDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 平台数据访问器
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountAccessor.java, v 0.1 2014-5-6 下午11:59:35 hongmin.zhonghm Exp $
 */
public class PlatformAccessor extends AbstractDataAccessor {

    /** 平台DAO */
    @Resource
    private DnmPlatformDAO dnmPlatformDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        PlatformModel platfromModel = (PlatformModel) model;
        dnmPlatformDAO.insert(convert2DO(platfromModel));
    }

    /**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmPlatformDO convert2DO(PlatformModel model) {
        DnmPlatformDO platformDO = new DnmPlatformDO();
        if (model != null) {
            platformDO.setId(model.getId());
            platformDO.setName(model.getName());
            platformDO.setDescription(model.getDescription());
            platformDO.setUrl(model.getUrl());
            platformDO.setGmtCreate(model.getGmtCreate());
            platformDO.setGmtModified(model.getGmtModified());
        }
        return platformDO;
    }

}
