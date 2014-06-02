/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.UserModel;
import com.dnm.facade.request.LoginRequest;
import com.dnm.facade.request.RegisterRequest;

/**
 * �û�����ģ�͹���
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserFactory.java, v 0.1 2014-4-13 ����2:26:52 hongmin.zhonghm Exp $
 */
public interface UserFactory {

    /**
     * ����ע����Ϣ��װ�û�����ģ��
     * 
     * @param requestData
     * @return
     */
    public UserModel compose(RegisterRequest requestData);

    /**
     * ���ݵ�½��Ϣ��װ�û�����ģ��
     * 
     * @param requestData
     * @return
     */
    public UserModel compose(LoginRequest requestData);
}
