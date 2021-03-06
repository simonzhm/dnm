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
import com.dnm.facade.constant.SubAccountTransCodeEnum;
import com.dnm.facade.constant.SubTransCodeEnum;

/**
 * 业务层与账务层子交易码映射缓存
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubTransCodeMapCacheImpl.java, v 0.1 2014-6-10 上午10:38:07 hongmin.zhonghm Exp $
 */
public class SubTransCodeMapCacheImpl extends AbstractLocalCache implements SubTransCodeMapCache {

    /** 子交易码映射缓存,key为业务层子交易码，如420001*/
    private Map<String, List<String>> subCodeMap = new HashMap<String, List<String>>();


    @Override
	public List<String> getAccountTransSubCodes(String transSubCode) {
        return subCodeMap.get(transSubCode);
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
        //投标奖（实时）
        List<String> investPriceList = new ArrayList<String>();
        investPriceList.add(SubAccountTransCodeEnum.INVEST_PRICE_IMED.getCode());
        subCodeMap.put(SubTransCodeEnum.INVEST_PRICE_IMED.getCode(),investPriceList);

        //待收续投奖
        List<String> dueinReInvestPriceList = new ArrayList<String>();
        dueinReInvestPriceList.add(SubAccountTransCodeEnum.DUEIN_REINVEST_PRICE.getCode());
        subCodeMap.put(SubTransCodeEnum.RE_INVEST_PRICE.getCode(),dueinReInvestPriceList);

        //续投奖发放（实时）
        List<String> reInvestPriceList = new ArrayList<String>();
        reInvestPriceList.add(SubAccountTransCodeEnum.RE_INVEST_PRICE_IMED.getCode());
        subCodeMap.put(SubTransCodeEnum.RE_INVEST_PRICE_IMED.getCode(), reInvestPriceList);
    }
}
