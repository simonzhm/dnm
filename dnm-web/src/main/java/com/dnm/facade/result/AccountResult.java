/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.result;

import com.dnm.facade.vo.AccountVO;

/**
 * 账户操作结果
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountResult.java, v 0.1 2014-5-5 下午4:39:35 hongmin.zhonghm Exp $
 */
public class AccountResult extends BaseResult {

    /** serialVersionUID */
    private static final long serialVersionUID = -4364161853364043364L;

    /** 账户 */
    private AccountVO         account;

    /**
     * Getter method for property <tt>account</tt>.
     * 
     * @return property value of account
     */
    public AccountVO getAccount() {
        return account;
    }

    /**
     * Setter method for property <tt>account</tt>.
     * 
     * @param account value to be assigned to property account
     */
    public void setAccount(AccountVO account) {
        this.account = account;
    }

}
