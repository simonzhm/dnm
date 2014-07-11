/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.factory.BankFactory;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.facade.constant.AccountDirectionEnum;
import com.dnm.facade.constant.AccountTypeEnum;
import com.dnm.facade.constant.ThirdAccountTypeEnum;
import com.dnm.facade.request.AddBankRequest;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankFactoryImpl.java, v 0.1 2014-5-5 下午11:39:40 hongmin.zhonghm Exp $
 */
public class BankFactoryImpl extends AbstractDomainService implements BankFactory {

    /** 
     * @see com.dnm.core.service.domain.factory.AccountFactory#compose(com.dnm.facade.request.OpenAccountRequest)
     */
    @Override
    public BankModel compose(AddBankRequest requestData) {
        BankModel model = new BankModel();
        //从上下文中取出数据
        Date date = DnmContextHolder.getTime();

        model.setId(DBKeyUtil.complete16(date, sequenceService.getDnmBankSeq()));
        model.setUserId(requestData.getUserId());
        model.setBankId(requestData.getBankId());
        model.setBankName(requestData.getBankName());
        model.setDirection(requestData.getDirection());
        model.setBillDate(requestData.getBillDate());
        model.setRepayDate(requestData.getRepayDate());
        model.setGmtCreate(date);
        model.setGmtModified(date);

        AccountModel aModel = new AccountModel();
        AccountDirectionEnum direction = AccountDirectionEnum.getByCode(requestData.getDirection());
        String subAccontType = (direction == AccountDirectionEnum.CREDIT ? ThirdAccountTypeEnum.CREDIT_CARD
            .getCode() : ThirdAccountTypeEnum.DEBIT_CARD.getCode());
        aModel.setUserId(requestData.getUserId());
        aModel.setBalance(new BigDecimal(requestData.getBalance()));
        aModel.setCurrency(requestData.getCurrency());
        aModel.setAccountType(AccountTypeEnum.BANK.getCode());
        aModel.setSubAccountType(subAccontType);
        aModel.setAccountName(requestData.getBankName());
        aModel.setDirection(requestData.getDirection());
        aModel.setGmtCreate(date);
        aModel.setGmtModified(date);

        model.setAccountModel(aModel);

        return model;
    }
}
