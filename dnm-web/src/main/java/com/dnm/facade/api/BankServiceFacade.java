/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.api;

import com.dnm.facade.anotation.FacadeApi;
import com.dnm.facade.request.AddBankRequest;
import com.dnm.facade.result.BaseResult;

/**
 * ���з���ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankServiceFacade.java, v 0.1 2014-5-5 ����10:44:25 hongmin.zhonghm Exp $
 */
@FacadeApi
public interface BankServiceFacade {

    /**
     * �������
     * 
     * @param requestData
     * @return 
     */
    public BaseResult addBank(AddBankRequest requestData);
}
