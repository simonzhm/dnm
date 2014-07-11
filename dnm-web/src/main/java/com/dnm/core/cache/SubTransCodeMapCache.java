/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache;

import java.util.List;

/**
 * 业务层与账务层子交易码映射缓存
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubTransCodeMapCache.java, v 0.1 2014-6-10 上午10:34:16 hongmin.zhonghm Exp $
 */
public interface SubTransCodeMapCache {

    /**
     * 根据业务层子交易码射账务子交易码
     * 
     * @param transSubCode
     * @return
     */
    public List<String> getAccountTransSubCodes(String transSubCode);

}
