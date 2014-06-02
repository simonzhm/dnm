/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access;

import com.dnm.core.common.exception.DnmException;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: AbstractDataAccessor.java, v 0.1 2014-4-13 上午12:53:39 hongmin.zhonghm Exp $
 */
public abstract class AbstractDataAccessor implements DataAccessor {

    /** 
     * @see com.dnm.core.service.domain.repository.access.DataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        throw new DnmException();
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.DataAccessor#reStore(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void reStore(DomainModel model) {
        throw new DnmException();
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.DataAccessor#deprecate(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void deprecate(DomainModel model) {
        throw new DnmException();
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.DataAccessor#fill(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void fill(DomainModel model) {
        throw new DnmException();
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.DataAccessor#lockFill(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void lockFill(DomainModel model) {
        throw new DnmException();
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.DataAccessor#reFill(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void reFill(DomainModel model) {
        throw new DnmException();
    }

    /**
     * 取得方法签名，以便于方法调试时使用。
     *
     * @param accessName
     * @return
     */
    protected String getAccessSignature(String accessName) {
        String accessSignature = getClass().getSimpleName() + "." + accessName;

        return accessSignature;
    }
}
