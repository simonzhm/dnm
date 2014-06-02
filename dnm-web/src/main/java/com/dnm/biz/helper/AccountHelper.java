/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.helper;

import org.springframework.beans.BeanUtils;

import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.facade.vo.AccountVO;

/**
 * 账户帮助类
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountHelper.java, v 0.1 2014-5-14 下午10:20:44 hongmin.zhonghm Exp $
 */
public class AccountHelper {

    /**
     * 转换账户模型为业务层对象
     * 
     * @param model
     * @return
     */
    public static AccountVO convert2VO(AccountModel model) {
        AccountVO vo = new AccountVO();
        BeanUtils.copyProperties(model, vo);
        //        vo.setAccountId(model.getAccountId());
        //        vo.setUserId(model.getUserId());
        //        vo.setAccountName(model.getAccountName());
        //        vo.setAccountType(model.getAccountType());
        //        vo.setSubAccountType(model.getSubAccountType());
        //        vo.setDirection(model.getDirection());
        //        vo.setBalance(model.getBalance());
        //        vo.setCurrency(model.getCurrency());
        return vo;
    }
}
