/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service;

/**
 * ���ݿ�sequence����ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: SequenceService.java, v 0.1 2014-4-14 ����11:42:40 hongmin.zhonghm Exp $
 */
public interface SequenceService {

    /**
     * ��ȡdnm_user��seq
     * 
     * @return
     */
    public long getDnmUserSeq();

    /**
     * ��ȡdnm_account��seq
     * 
     * @return
     */
    public long getDnmAccountSeq();

    /**
     * ��ȡdnm_bank��seq
     * 
     * @return
     */
    public long getDnmBankSeq();

    /**
     * ��ȡdnm_platform��seq
     * 
     * @return
     */
    public long getDnmPlatformSeq();

    /**
     * ��ȡdnm_platform_user��seq
     * 
     * @return
     */
    public long getDnmPlatformUserSeq();

    /**
     * ��ȡdnm_account_trans_log��seq
     * 
     * @return
     */
    public long getDnmAccountTransLogSeq();

    /**
     * ��ȡdnm_account_log��seq
     * 
     * @return
     */
    public long getDnmAccountLogSeq();

    /**
     * ��ȡdnm_invest_price_cost��seq
     * 
     * @return
     */
    public long getDnmInvestPriceCostSeq();

    /**
     * ��ȡdnm_invest_rcd��seq
     * 
     * @return
     */
    public long getDnmInvestRcdSeq();

    /**
     * ��ȡdnm_invest_duein_rcd��seq
     * 
     * @return
     */
    public long getDnmInvestDueinRcdSeq();

}
