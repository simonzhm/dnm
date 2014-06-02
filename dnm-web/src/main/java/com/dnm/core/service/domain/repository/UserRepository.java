/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.UserModel;

/**
 * �û��ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserRepository.java, v 0.1 2014-4-13 ����2:50:25 hongmin.zhonghm Exp $
 */
public interface UserRepository {

    /**
     * �־û��û�
     * 
     * @param userModel
     */
    public void store(UserModel userModel);

    /**
     * �����û�����������û�
     * 
     * @param userModel
     */
    public void loadByUserNameAndPwd(UserModel userModel);
}
