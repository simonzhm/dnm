/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service;

/**
 * 数据库sequence服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: SequenceService.java, v 0.1 2014-4-14 上午11:42:40 hongmin.zhonghm Exp $
 */
public interface SequenceService {

    /**
     * 获取dnm_user表seq
     * 
     * @return
     */
    public long getDnmUserSeq();

    /**
     * 获取dnm_account表seq
     * 
     * @return
     */
    public long getDnmAccountSeq();

    /**
     * 获取dnm_bank表seq
     * 
     * @return
     */
    public long getDnmBankSeq();

    /**
     * 获取dnm_platform表seq
     * 
     * @return
     */
    public long getDnmPlatformSeq();

    /**
     * 获取dnm_platform_user表seq
     * 
     * @return
     */
    public long getDnmPlatformUserSeq();

    /**
     * 获取dnm_account_trans_log表seq
     * 
     * @return
     */
    public long getDnmAccountTransLogSeq();

    /**
     * 获取dnm_account_log表seq
     * 
     * @return
     */
    public long getDnmAccountLogSeq();

    /**
     * 获取dnm_invest_price_cost表seq
     * 
     * @return
     */
    public long getDnmInvestPriceCostSeq();

    /**
     * 获取dnm_invest_rcd表seq
     * 
     * @return
     */
    public long getDnmInvestRcdSeq();

    /**
     * 获取dnm_invest_duein_rcd表seq
     * 
     * @return
     */
    public long getDnmInvestDueinRcdSeq();

}
