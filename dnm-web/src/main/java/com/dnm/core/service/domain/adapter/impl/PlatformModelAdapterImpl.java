/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.adapter.impl;

import java.util.HashMap;
import java.util.Map;

import com.dnm.core.service.domain.adapter.PlatformModelAdapter;
import com.dnm.core.service.domain.model.bill.PlatformUserAccountModel;
import com.dnm.core.service.domain.model.bill.PlatformUserModel;
import com.dnm.facade.result.AccountResult;
import com.dnm.facade.vo.AccountVO;

/**
 * 平台模型适配器
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformModelAdapterImpl.java, v 0.1 2014-5-9 上午1:29:18 hongmin.zhonghm Exp $
 */
public class PlatformModelAdapterImpl implements PlatformModelAdapter {

    /** 
     * @see com.dnm.core.service.domain.adapter.PlatformModelAdapter#fillPlatformUserModel(com.dnm.core.service.domain.model.bill.PlatformUserModel, com.dnm.facade.result.AccountResult)
     */
    @Override
    public void fillPlatformUserModel(PlatformUserModel model, AccountResult result) {
        if (result != null && result.isSuccess()) {
            Map<String, PlatformUserAccountModel> userAccountMap = model
                .getPlatformUserAccountModel();
            if (userAccountMap == null) {
                userAccountMap = new HashMap<String, PlatformUserAccountModel>();
                model.setPlatformUserAccountModel(userAccountMap);
            }
            AccountVO account = result.getAccount();
            userAccountMap.put(account.getSubAccountType(),
                genPlatformUserAccountModel(model, account));
        }
    }

    /**
     * 生成平台用户领域模形
     * 
     * @param model
     * @param account
     * @return
     */
    private PlatformUserAccountModel genPlatformUserAccountModel(PlatformUserModel model,
                                                                 AccountVO account) {
        PlatformUserAccountModel userAccountModel = new PlatformUserAccountModel();
        userAccountModel.setAccountId(account.getAccountId());
        userAccountModel.setSubAccountType(account.getSubAccountType());
        userAccountModel.setPlatformUserId(model.getId());
        return userAccountModel;
    }

}
