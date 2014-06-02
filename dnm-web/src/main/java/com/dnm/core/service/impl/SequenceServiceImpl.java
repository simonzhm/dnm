/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.SequenceDAO;
import com.dnm.core.service.SequenceService;

/**
 * 数据库sequence服务实现，mysql不支持sequence
 * 
 * @author hongmin.zhonghm
 * @version $Id: SequenceServiceImpl.java, v 0.1 2014-4-14 上午11:44:30 hongmin.zhonghm Exp $
 */
public class SequenceServiceImpl implements SequenceService {

    /** sequence，比较简单的数据库操作，直接通过dao完成*/
    @Resource
    private SequenceDAO sequenceDAO;

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmUserSeq()
     */
    @Override
    public long getDnmUserSeq() {
        return sequenceDAO.getDnmUserNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmAccountSeq()
     */
    @Override
    public long getDnmAccountSeq() {
        return sequenceDAO.getDnmAccountNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmBankSeq()
     */
    @Override
    public long getDnmBankSeq() {
        return sequenceDAO.getDnmBankNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmPlatformSeq()
     */
    @Override
    public long getDnmPlatformSeq() {
        return sequenceDAO.getDnmPlatformNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmPlatformUserSeq()
     */
    @Override
    public long getDnmPlatformUserSeq() {
        return sequenceDAO.getDnmPlatformUserNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmAccountTransLogSeq()
     */
    @Override
    public long getDnmAccountTransLogSeq() {
        return sequenceDAO.getDnmAccountTransLogNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmAccountLogSeq()
     */
    @Override
    public long getDnmAccountLogSeq() {
        return sequenceDAO.getDnmAccountLogNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmInvestPriceCostSeq()
     */
    @Override
    public long getDnmInvestPriceCostSeq() {
        return sequenceDAO.getDnmInvestPriceCostNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmInvestRcdSeq()
     */
    @Override
    public long getDnmInvestRcdSeq() {
        return sequenceDAO.getDnmInvestRcdNextval();
    }

    /** 
     * @see com.dnm.core.service.SequenceService#getDnmInvestDueinRcdSeq()
     */
    @Override
    public long getDnmInvestDueinRcdSeq() {
        return sequenceDAO.getDnmInvestDueinRcdNextval();
    }

}
