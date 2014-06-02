/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.adapter.impl;

import com.dnm.core.service.domain.adapter.BankModelAdapter;
import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.facade.result.AccountResult;

/**
 * ����ģ��������
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankModelAdapterImpl.java, v 0.1 2014-5-9 ����1:29:18 hongmin.zhonghm Exp $
 */
public class BankModelAdapterImpl implements BankModelAdapter {

    /** 
     * @see com.dnm.core.service.domain.adapter.BankModelAdapter#fillBankModel(com.dnm.core.service.domain.model.bill.BankModel, com.dnm.facade.result.AccountResult)
     */
    @Override
    public void fillBankModel(BankModel model, AccountResult result) {
        if (result != null && result.isSuccess()) {
            model.setAccountId(result.getAccount().getAccountId());
        }
    }

}
