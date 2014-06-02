/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.convertor;

import com.dnm.core.common.dal.dataobject.DnmAccountLogDO;
import com.dnm.core.service.domain.model.bill.AccountLogModel;

/**
 * 账户日志转换器
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountLogConvertor.java, v 0.1 2014-5-23 上午9:17:18 hongmin.zhonghm Exp $
 */
public class AccountLogConvertor {
    /**
     * 将数据对象转换成模型
     * 
     * @param dbObject
     * @return
     */
    public static AccountLogModel convert2Model(DnmAccountLogDO dbObject) {
        AccountLogModel model = new AccountLogModel();
        model.setId(dbObject.getId());
        model.setTransLogId(dbObject.getTransLogId());
        model.setAccount(dbObject.getAccount());
        model.setBalance(dbObject.getBalance());
        model.setDirection(dbObject.getDirection());
        model.setTransAmt(dbObject.getTransAmt());
        model.setMemo(dbObject.getMemo());
        model.setGmtCreate(dbObject.getGmtCreate());
        model.setGmtModified(dbObject.getGmtModified());

        return model;
    }

    /**
     * 将模型转换成数据对象
     * 
     * @param model
     */
    public static DnmAccountLogDO convert2DO(AccountLogModel model) {
        DnmAccountLogDO dbObject = new DnmAccountLogDO();
        dbObject.setId(model.getId());
        dbObject.setTransLogId(model.getTransLogId());
        dbObject.setAccount(model.getAccount());
        dbObject.setBalance(model.getBalance());
        dbObject.setDirection(model.getDirection());
        dbObject.setTransAmt(model.getTransAmt());
        dbObject.setMemo(model.getMemo());
        dbObject.setGmtCreate(model.getGmtCreate());
        dbObject.setGmtModified(model.getGmtModified());
        return dbObject;
    }
}
