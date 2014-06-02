/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.common.util.DateUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.factory.AccountTransLogFactory;
import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.facade.request.AccountTransferRequest;

/**
 * 账务日志领域工厂
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogFactoryImpl.java, v 0.1 2014-5-13 下午9:58:42 hongmin.zhonghm Exp $
 */
public class AccountTransLogFactoryImpl extends AbstractDomainService implements
                                                                     AccountTransLogFactory {

    /** 
     * @see com.dnm.core.service.domain.factory.AccountTransLogFactory#compose(com.dnm.facade.request.AccountTransferRequest)
     */
    @Override
    public AccountTransLogModel compose(AccountTransferRequest requestData) {

        AccountTransLogModel model = new AccountTransLogModel();

        //从上下文中取出数据
        Date now = DnmContextHolder.getTime();

        model.setId(DBKeyUtil.complete16(now, sequenceService.getDnmAccountTransLogSeq()));
        model.setUserId(requestData.getUserId());
        model.setGuid(requestData.getGuid());
        model.setBizId(requestData.getBizId());
        model.setTransCode(requestData.getTransType());
        model.setTransSubCode(requestData.getTransSubType());
        model.setTransAmt(new BigDecimal(requestData.getTransAmt()));
        model.setTransCurrency(requestData.getTransCurrency());
        model.setTransTime(DateUtil.getDate(requestData.getTransTime(), DateUtil.newFormat));
        model.setDebitAccount(requestData.getDebitAccount());
        model.setCreditAccount(requestData.getCreditAccount());
        model.setGmtCreate(now);
        model.setGmtModified(now);
        return model;
    }

}
