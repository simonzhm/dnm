/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service;

import java.util.List;

import com.dnm.core.service.domain.model.bill.AccountModel;

/**
 * �˻��ڲ�����ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountService.java, v 0.1 2014-5-22 ����11:30:46 hongmin.zhonghm Exp $
 */
public interface AccountService {

    /**
     * ��ȡ�����˻�����ȡ˳���˻�ID��С�������򣬷�ֹ����
     * 
     * @param accountId
     * @return �����˻�����һ��Ϊ����˻����ڶ���Ϊ�����˻�
     */
    public List<AccountModel> lockTransferAccounts(String inAccountId, String outAccountId);
}
