/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.util.AmountUtil;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.AccountService;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.AccountTransferDomainService;
import com.dnm.core.service.domain.model.bill.AccountLogModel;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.core.service.domain.repository.AccountTransLogRepository;
import com.dnm.facade.constant.AccountDirectionEnum;

/**
 * �˻�������־�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransferDomainServiceImpl.java, v 0.1 2014-5-14 ����9:46:57 hongmin.zhonghm Exp $
 */
public class AccountTransferDomainServiceImpl extends AbstractDomainService implements
                                                                           AccountTransferDomainService {
    /** �˻�������־�ִ� */
    @Resource
    private AccountTransLogRepository accountTransLogRepository;

    /** �ڲ��˻�����ӿ� */
    @Resource
    private AccountService            accountService;

    /** 
     * @see com.dnm.core.service.domain.AccountTransferDomainService#accountTransfer(com.dnm.core.service.domain.model.bill.AccountTransLogModel)
     */
    @Override
    public void accountTransfer(AccountTransLogModel model) {
        fixModel(model);
        checkAccount(model);
        accountTrans(model);
        accountTransLogRepository.store(model);
    }

    /**
     * ���model�������˻�ģ��
     * 
     * @param model
     */
    private void fixModel(AccountTransLogModel model) {
        String debitAccountId = model.getDebitAccount();
        String creditAccountId = model.getCreditAccount();
        List<AccountModel> models = accountService.lockTransferAccounts(debitAccountId,
            creditAccountId);

        model.setDebitAccountModel(models.get(0));
        model.setCreditAccountModel(models.get(1));
    }

    /**
     * ����˻��Ϸ���
     * 
     * @param model
     */
    private void checkAccount(AccountTransLogModel model) {
    }

    /**
     * �������䶯
     * 
     * @param model
     */
    private void accountTrans(AccountTransLogModel model) {
        BigDecimal transAmt = model.getTransAmt();
        AccountModel debitAccountModel = model.getDebitAccountModel();
        AccountModel creditAccountModel = model.getCreditAccountModel();
        debitAccountModel.setBalance(AmountUtil.add(debitAccountModel.getBalance(), transAmt));
        creditAccountModel.setBalance(AmountUtil.substract(creditAccountModel.getBalance(),
            transAmt));

        AccountLogModel debitAccountLogModel = genAccountLogModel(model, debitAccountModel,
            AccountDirectionEnum.DEBIT);
        AccountLogModel creditAccountLogModel = genAccountLogModel(model, creditAccountModel,
            AccountDirectionEnum.CREDIT);

        debitAccountModel.setAccountLogModel(debitAccountLogModel);
        creditAccountModel.setAccountLogModel(creditAccountLogModel);
    }

    /**
     * �����˻�������־ģ��
     * 
     * @param accountTransLogmodel
     * @param accountModel
     * @param direction
     * @return
     */
    private AccountLogModel genAccountLogModel(AccountTransLogModel accountTransLogmodel,
                                               AccountModel accountModel,
                                               AccountDirectionEnum direction) {
        AccountLogModel model = new AccountLogModel();

        //����������ȡ������
        Date now = DnmContextHolder.getTime();

        model.setId(DBKeyUtil.complete16(now, sequenceService.getDnmAccountLogSeq()));
        model.setTransLogId(accountTransLogmodel.getId());
        model.setAccount(accountModel.getAccountId());
        model.setDirection(direction.getCode());
        if (StringUtil.equals(accountModel.getDirection(), direction.getCode())) {
            model.setTransAmt(accountTransLogmodel.getTransAmt());
        } else {
            model.setTransAmt(accountTransLogmodel.getTransAmt().negate());
        }
        model.setBalance(accountModel.getBalance());
        model.setGmtCreate(now);
        model.setGmtModified(now);

        return model;
    }
}
