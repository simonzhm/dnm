/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.facade.request.AddBankRequest;

/**
 * ��������ģ�͹���
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankFactory.java, v 0.1 2014-5-5 ����11:38:07 hongmin.zhonghm Exp $
 */
public interface BankFactory {

    /**
     * ��װ��������ģ��
     * 
     * @param requestData
     * @return
     */
    public BankModel compose(AddBankRequest requestData);
}
