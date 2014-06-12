/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dnm.core.cache.AbstractLocalCache;
import com.dnm.core.cache.SubTransCodeMapCache;
import com.dnm.core.common.constant.CacheConstant;
import com.dnm.core.common.util.StringUtil;
import com.dnm.facade.constant.SubAccountTransCodeEnum;
import com.dnm.facade.constant.SubTransCodeEnum;
import com.dnm.facade.constant.YesOrNoEnum;

/**
 * 业务层与账务层子交易码映射缓存
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubTransCodeMapCacheImpl.java, v 0.1 2014-6-10 上午10:38:07 hongmin.zhonghm Exp $
 */
public class SubTransCodeMapCacheImpl extends AbstractLocalCache implements SubTransCodeMapCache {

    /** 子交易码映射缓存,key为业务层子交易码+是否即时到账（可空），如420001Y*/
    private Map<String, List<String>> subCodeMap = new HashMap<String, List<String>>();

    /** 
     * @see com.dnm.core.cache.SubTransCodeMapCache#getAccountTransSubCodes(java.lang.String, java.lang.String)
     */
    @Override
    public List<String> getAccountTransSubCodes(String transSubCode, String isFinish) {
        String key = transSubCode + (StringUtil.isBlank(isFinish) ? "" : isFinish);
        return subCodeMap.get(key);
    }

    /** 
     * @see com.dnm.core.cache.DnmCache#getName()
     */
    @Override
    public String getName() {
        return CacheConstant.SUB_TRANS_CODE_MAP_CACHE;
    }

    /** 
     * @see com.dnm.core.cache.DnmCache#dump()
     */
    @Override
    public void dump() {
    }

    /** 
     * @see com.dnm.core.cache.AbstractLocalCache#doInit()
     */
    @Override
    protected void doInit() throws Exception {
        //投标奖
        List<String> investPriceList = new ArrayList<String>();
        investPriceList.add(SubAccountTransCodeEnum.INVEST_PRICE.getCode());
        subCodeMap.put(SubTransCodeEnum.INVEST_PRICE.getCode() + YesOrNoEnum.YES.getCode(),
            investPriceList);

        //待收续投奖
        List<String> dueinReInvestPriceList = new ArrayList<String>();
        investPriceList.add(SubAccountTransCodeEnum.DUEIN_REINVEST_PRICE.getCode());
        subCodeMap.put(SubTransCodeEnum.INVEST_PRICE.getCode() + YesOrNoEnum.NO.getCode(),
            dueinReInvestPriceList);

        //已收续投奖
        List<String> reInvestPriceList = new ArrayList<String>();
        investPriceList.add(SubAccountTransCodeEnum.RE_INVEST_PRICE.getCode());//发放
        investPriceList.add(SubAccountTransCodeEnum.REINVEST_PRICE_RECEIVE.getCode());//回款
        subCodeMap.put(SubTransCodeEnum.INVEST_PRICE.getCode() + YesOrNoEnum.YES.getCode(),
            reInvestPriceList);
    }
}
