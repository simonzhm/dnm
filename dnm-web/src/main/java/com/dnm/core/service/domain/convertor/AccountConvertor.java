/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.convertor;

import com.dnm.core.common.dal.dataobject.DnmAccountDO;
import com.dnm.core.service.domain.model.bill.AccountModel;

/**
 * �˻�ת����
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountConvertor.java, v 0.1 2014-5-23 ����9:17:18 hongmin.zhonghm Exp $
 */
public class AccountConvertor {
    /**
     * �����ݶ���ת����ģ��
     * 
     * @param dbObject
     * @return
     */
    public static AccountModel convert2Model(DnmAccountDO dbObject) {
        AccountModel model = new AccountModel();
        //        BeanUtils.copyProperties(dbObject, model);
        model.setUserId(dbObject.getUserId());
        model.setAccountId(dbObject.getAccountId());
        model.setAccountName(dbObject.getAccountName());
        model.setAccountType(dbObject.getAccountType());
        model.setSubAccountType(dbObject.getSubAccountType());
        model.setBalance(dbObject.getBalance());
        model.setCurrency(dbObject.getCurrency());
        model.setDirection(dbObject.getDirection());
        model.setGmtCreate(dbObject.getGmtCreate());
        model.setGmtModified(dbObject.getGmtModified());
        return model;
    }

    /**
     * ��ģ��ת�������ݶ���
     * 
     * @param model
     */
    public static DnmAccountDO convert2DO(AccountModel model) {
        DnmAccountDO dbObject = new DnmAccountDO();
        dbObject.setUserId(model.getUserId());
        dbObject.setAccountId(model.getAccountId());
        dbObject.setAccountName(model.getAccountName());
        dbObject.setAccountType(model.getAccountType());
        dbObject.setSubAccountType(model.getSubAccountType());
        dbObject.setBalance(model.getBalance());
        dbObject.setCurrency(model.getCurrency());
        dbObject.setDirection(model.getDirection());
        dbObject.setGmtCreate(model.getGmtCreate());
        dbObject.setGmtModified(model.getGmtModified());
        return dbObject;
    }
}
