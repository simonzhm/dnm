/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.api;

import com.dnm.facade.anotation.FacadeApi;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.request.QueryAccountByUserIdTypeRequest;
import com.dnm.facade.request.QueryAccountRequest;
import com.dnm.facade.result.AccountResult;

/**
 * �˻�����ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountServiceFacade.java, v 0.1 2014-5-5 ����10:44:25 hongmin.zhonghm Exp $
 */
@FacadeApi
public interface AccountServiceFacade {

    /**
     * ����
     * 
     * @param requestData
     * @return �˻�
     */
    public AccountResult openAccount(OpenAccountRequest requestData);

    /**
     * ��ѯ�˻�
     * 
     * @param requestData
     * @return �˻�
     */
    public AccountResult queryAccount(QueryAccountRequest requestData);

    /**
     * ����userId�����˻����Ͳ�ѯ�˻�
     * 
     * @param requestData
     * @return �˻�
     */
    public AccountResult queryAccountByUserIdType(QueryAccountByUserIdTypeRequest requestData);
}
