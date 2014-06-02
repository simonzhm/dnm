/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.factory.PlatformFactory;
import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.core.service.domain.model.bill.PlatformUserModel;
import com.dnm.facade.request.AddPlatformRequest;
import com.dnm.facade.request.AddPlatformUsersRequest;
import com.dnm.facade.request.PlatformUserRequest;

/**
 * 平台领域工厂
 * @author hongmin.zhonghm
 * @version $Id: PlatformFactoryImpl.java, v 0.1 2014-5-5 下午11:39:40 hongmin.zhonghm Exp $
 */
public class PlatformFactoryImpl extends AbstractDomainService implements PlatformFactory {

    /** 
     * @see com.dnm.core.service.domain.factory.PlatformFactory#compose(com.dnm.facade.request.AddPlatformRequest)
     */
    @Override
    public PlatformModel compose(AddPlatformRequest requestData) {
        PlatformModel model = new PlatformModel();
        //从上下文中取出数据
        Date date = DnmContextHolder.getTime();

        model.setId(DBKeyUtil.complete16(date, sequenceService.getDnmPlatformSeq()));
        model.setName(requestData.getName());
        model.setDescription(requestData.getDescription());
        model.setUrl(requestData.getUrl());
        model.setGmtCreate(date);
        model.setGmtModified(date);

        return model;
    }

    /** 
     * @see com.dnm.core.service.domain.factory.PlatformFactory#compose(com.dnm.facade.request.AddPlatformUsersRequest)
     */
    @Override
    public PlatformModel compose(AddPlatformUsersRequest requestData) {
        PlatformModel model = new PlatformModel();
        //从上下文中取出数据
        Date now = DnmContextHolder.getTime();

        model.setId(requestData.getPlatformId());
        model.setGmtCreate(now);
        model.setGmtModified(now);

        List<PlatformUserModel> puModels = new ArrayList<PlatformUserModel>();
        List<PlatformUserRequest> platformUsers = requestData.getPlatformUsers();
        for (PlatformUserRequest platformUser : platformUsers) {
            PlatformUserModel puModel = new PlatformUserModel();
            puModel.setId(DBKeyUtil.complete16(now, sequenceService.getDnmPlatformUserSeq()));
            puModel.setPlatformId(requestData.getPlatformId());
            puModel.setUserId(requestData.getUserId());
            puModel.setPlatformUserId(platformUser.getPlatformUserId());
            puModel.setGmtCreate(now);
            puModel.setGmtModified(now);
            puModels.add(puModel);
        }
        model.setNewPlatformUserModels(puModels);
        return model;
    }

}
