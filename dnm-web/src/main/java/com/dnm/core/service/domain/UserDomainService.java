/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.UserModel;

/**
 * �û�����ģ�ͷ���
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserDomainService.java, v 0.1 2014-4-13 ����2:38:14 hongmin.zhonghm Exp $
 */
public interface UserDomainService {

    /**
     * �û�ע��
     * 
     * @param userModel �û�����ģ��
     */
    public void regist(UserModel userModel);

    /**
     * ��½
     * 
     * @param userModel �û�����ģ��
     */
    public void login(UserModel userModel);

}
