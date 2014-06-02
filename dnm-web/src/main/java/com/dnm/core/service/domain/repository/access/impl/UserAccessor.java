/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dnm.core.common.dal.daointerface.DnmUserDAO;
import com.dnm.core.common.dal.dataobject.DnmUserDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.UserModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 用户访问器
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserAccessor.java, v 0.1 2014-4-13 上午3:19:19 hongmin.zhonghm Exp $
 */
@Service(value = "userAccessor")
public class UserAccessor extends AbstractDataAccessor {

    /** 用户DAO */
    @Resource
    private DnmUserDAO dnmUserDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        UserModel userModel = (UserModel) model;
        dnmUserDAO.insert(convert2DO(userModel));
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#reFill(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void reFill(DomainModel model) {
        UserModel userModel = (UserModel) model;
        DnmUserDO userDo = dnmUserDAO.loadByUsernameAndPwd(userModel.getUsername(),
            userModel.getPassword());
        convertDo2Model(userDo, userModel);

    }

    /**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmUserDO convert2DO(UserModel model) {
        DnmUserDO userDO = new DnmUserDO();
        if (model != null) {
            userDO.setId(model.getId());
            userDO.setUsername(model.getUsername());
            userDO.setPassword(model.getPassword());
            userDO.setEmail(model.getEmail());
            userDO.setGmtCreate(model.getGmtCreate());
            userDO.setGmtModified(model.getGmtModified());
        }
        return userDO;
    }

    /**
     * 填充模型
     * 
     * @param userDO
     * @param model
     * @return
     */
    private void convertDo2Model(DnmUserDO userDO, UserModel model) {
        if (userDO != null) {
            model.setId(userDO.getId());
            model.setUsername(userDO.getUsername());
            model.setPassword(userDO.getPassword());
            model.setEmail(userDO.getEmail());
            model.setGmtCreate(userDO.getGmtCreate());
            model.setGmtModified(userDO.getGmtModified());
        }
    }

}
