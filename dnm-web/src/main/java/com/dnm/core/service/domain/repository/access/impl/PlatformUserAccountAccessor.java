/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmPlatformUserDAO;
import com.dnm.core.common.dal.dataobject.DnmPlatformUserAccountDO;
import com.dnm.core.common.dal.ibatis.IbatisExtraDAO;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.core.service.domain.model.bill.PlatformUserAccountModel;
import com.dnm.core.service.domain.model.bill.PlatformUserModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;
import com.dnm.facade.constant.SubAccountTypeEnum;

/**
 * ƽ̨�û��˻�ӳ�����ݷ�����
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformUserAccountAccessor.java, v 0.1 2014-5-6 ����11:59:35 hongmin.zhonghm Exp $
 */
public class PlatformUserAccountAccessor extends AbstractDataAccessor {

    /** ƽ̨�û��˻�DAO */
    @Resource
    private DnmPlatformUserDAO dnmPlatformUserDAO;

    /** ��չDAO */
    @Resource
    private IbatisExtraDAO     extraDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        PlatformModel platfromModel = (PlatformModel) model;
        List<PlatformUserModel> puModels = platfromModel.getNewPlatformUserModels();
        List<DnmPlatformUserAccountDO> puaDOs = new ArrayList<DnmPlatformUserAccountDO>();
        for (PlatformUserModel puModel : puModels) {
            Map<String, PlatformUserAccountModel> accountMap = puModel
                .getPlatformUserAccountModel();
            //���ﰴ˳�򿪻�
            List<SubAccountTypeEnum> types = SubAccountTypeEnum.getPlatformSubAccountTypes();
            for (SubAccountTypeEnum type : types) {
                puaDOs.add(convert2DO(accountMap.get(type.getCode())));
            }
        }
        Integer count = extraDAO.batchAddPlatformUserAccounts(puaDOs);
        AssertUtil.isTrue(count > 0, ResultCodeEnum.DB_UPDATE_COUNT_ERROR,
            "batch inser platform user account error");
    }

    /**
     * ���DO
     * 
     * @param model
     * @return
     */
    private DnmPlatformUserAccountDO convert2DO(PlatformUserAccountModel model) {
        DnmPlatformUserAccountDO platformUserAccountDO = new DnmPlatformUserAccountDO();
        if (model != null) {
            platformUserAccountDO.setAccountId(model.getAccountId());
            platformUserAccountDO.setPlatformUserId(model.getPlatformUserId());
            platformUserAccountDO.setSubAccountType(model.getSubAccountType());
        }
        return platformUserAccountDO;
    }

}
