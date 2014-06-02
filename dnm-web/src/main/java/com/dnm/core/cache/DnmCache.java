/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache;

/**
 * 缓存接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmCache.java, v 0.1 2014-4-30 下午9:50:45 hongmin.zhonghm Exp $
 */
public interface DnmCache {

    /**
     * 初始化缓存
     */
    public void init() throws Exception;

    /**
     * 清空缓存
     */
    public void clear() throws Exception;

    /**
     * 获取缓存名
     * 
     * @return
     */
    public String getName();

    /**
     * 打印缓存信息
     */
    public void dump();
}
