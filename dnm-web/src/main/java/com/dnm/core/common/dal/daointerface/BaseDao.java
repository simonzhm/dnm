/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.dal.daointerface;

import java.util.List;

/**
 * 基础数据操作接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseDao.java, v 0.1 2014-4-7 下午8:24:51 hongmin.zhonghm Exp $
 */
public interface BaseDao {

    public <T> int executeBatch(final String sql, final List<T> datas);
}
