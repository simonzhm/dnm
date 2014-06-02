/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.adapter;

import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.facade.result.AccountResult;

/**
 * ����ģ��������
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankModelAdapter.java, v 0.1 2014-5-9 ����1:29:18 hongmin.zhonghm Exp $
 */
public interface BankModelAdapter {

    /**
     * ���ģ��
     * 
     * @param model
     * @param result
     */
    public void fillBankModel(BankModel model, AccountResult result);
}
