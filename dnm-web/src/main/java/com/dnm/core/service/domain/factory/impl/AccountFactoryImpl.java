/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.factory.AccountFactory;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.request.QueryAccountRequest;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountFactoryImpl.java, v 0.1 2014-5-5 下午11:39:40 hongmin.zhonghm Exp $
 */
public class AccountFactoryImpl extends AbstractDomainService implements AccountFactory {

    /** 
     * @see com.dnm.core.service.domain.factory.AccountFactory#compose(com.dnm.facade.request.OpenAccountRequest)
     */
    @Override
    public AccountModel compose(OpenAccountRequest requestData) {
        AccountModel model = new AccountModel();
        //从上下文中取出数据
        Date date = DnmContextHolder.getTime();

        model.setAccountId(DBKeyUtil.completeAccountId(date, sequenceService.getDnmAccountSeq(),
            CurrencyEnum.getByCode(requestData.getCurrency()).getValue()));
        model.setUserId(requestData.getUserId());
        model.setAccountName(requestData.getAccountName());
        model.setAccountType(StringUtil.substring(requestData.getAccountType(), 0, 2));
        model.setSubAccountType(requestData.getAccountType());
        model.setBalance(new BigDecimal(requestData.getBalance()));
        model.setCurrency(requestData.getCurrency());
        model.setDirection(requestData.getDirection());
        model.setGmtCreate(date);
        model.setGmtModified(date);

        return model;
    }

    /** 
     * @see com.dnm.core.service.domain.factory.AccountFactory#compose(com.dnm.facade.request.QueryAccountRequest)
     */
    @Override
    public AccountModel compose(QueryAccountRequest requestData) {
        AccountModel model = new AccountModel();
        model.setAccountId(requestData.getAccountId());
        return model;
    }

}
