/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmPlatformUserDAO;
import com.dnm.core.common.dal.dataobject.DnmPlatformUserDO;
import com.dnm.core.common.dal.ibatis.IbatisExtraDAO;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.core.service.domain.model.bill.PlatformUserModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 平台用户数据访问器
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformUserAccessor.java, v 0.1 2014-5-6 下午11:59:35 hongmin.zhonghm Exp $
 */
public class PlatformUserAccessor extends AbstractDataAccessor {

    /** 平台用户DAO */
    @Resource
    private DnmPlatformUserDAO dnmPlatformUserDAO;

    /** 扩展DAO */
    @Resource
    private IbatisExtraDAO     extraDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        PlatformModel platfromModel = (PlatformModel) model;
        List<PlatformUserModel> puModels = platfromModel.getNewPlatformUserModels();
        List<DnmPlatformUserDO> puDOs = new ArrayList<DnmPlatformUserDO>();
        for (PlatformUserModel puModel : puModels) {
            puDOs.add(convert2DO(puModel));
        }
        Integer count = extraDAO.batchAddPlatformUsers(puDOs);
        AssertUtil.isTrue(count > 0, ResultCodeEnum.DB_UPDATE_COUNT_ERROR,
            "batch inser platform user error");
    }

    /**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmPlatformUserDO convert2DO(PlatformUserModel model) {
        DnmPlatformUserDO platformUserDO = new DnmPlatformUserDO();
        if (model != null) {
            platformUserDO.setId(model.getId());
            platformUserDO.setUserId(model.getUserId());
            platformUserDO.setPlatformId(model.getPlatformId());
            platformUserDO.setPlatformUserId(model.getPlatformUserId());
            platformUserDO.setTotalInvestAmt(model.getTotalInvestAmt());
            platformUserDO.setGmtCreate(model.getGmtCreate());
            platformUserDO.setGmtModified(model.getGmtModified());
        }
        return platformUserDO;
    }

}
