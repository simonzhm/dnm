/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.facade.request.AccountTransferRequest;

/**
 * ������־���򹤳�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogFactory.java, v 0.1 2014-5-13 ����9:57:12 hongmin.zhonghm Exp $
 */
public interface AccountTransLogFactory {
    /**
     * ��װ������־����ģ��
     * 
     * @param requestData
     * @return
     */
    public AccountTransLogModel compose(AccountTransferRequest requestData);
}
