/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.dnm.core.common.anotation.CacheClear;
import com.dnm.core.common.util.ReflectionUtil;

/**
 * 本地缓存基类
 * 
 * @author hongmin.zhonghm
 * @version $Id: AbstractLocalCache.java, v 0.1 2014-4-30 下午9:49:48 hongmin.zhonghm Exp $
 */
public abstract class AbstractLocalCache implements DnmCache {
    /** 日志 */
    protected static final Logger LOGGER = Logger.getLogger(AbstractLocalCache.class);

    /** 
     * @see com.dnm.core.cache.DnmCache#init()
     */
    @Override
    public void init() throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute " + ReflectionUtil.getSimpleName(this));
        }
        doInit();
    }

    /** 
     * @see com.dnm.core.cache.DnmCache#clear()
     */
    @Override
    public void clear() throws Exception {
        List<Field> fields = ReflectionUtil.getDeclaredFields(this);
        CacheClear cc = null;
        for (Field field : fields) {
            cc = field.getAnnotation(CacheClear.class);
            if (cc != null) {
                Object value = field.get(this);
                if (ReflectionUtil.isAssignableFrom(Collection.class, field.getType())) {
                    ((Collection<?>) value).clear();
                }
            }
        }
    }

    /**
     * 初始化
     */
    abstract protected void doInit() throws Exception;

}
