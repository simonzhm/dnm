/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * �˻���ѯ���󵥾�
 * 
 * @author hongmin.zhonghm
 * @version $Id: QueryAccountRequest.java, v 0.1 2014-5-5 ����10:54:38 hongmin.zhonghm Exp $
 */
public class QueryAccountRequest extends BaseSessionRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -3832517615228411618L;

    /** �˻��� */
    @RequestFieldCheck(notEmpty = true, length = 20)
    private String            accountId;

    /**
     * Getter method for property <tt>accountId</tt>.
     * 
     * @return property value of accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Setter method for property <tt>accountId</tt>.
     * 
     * @param accountId value to be assigned to property accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

}
