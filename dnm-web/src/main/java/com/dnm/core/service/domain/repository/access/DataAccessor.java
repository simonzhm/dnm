/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access;

import com.dnm.core.service.domain.model.DomainModel;

/**
 * 数据对象访问器。
 * <p>
 * 主要提供以下服务:
 * <ul>
 *  <li>从领域模型中取出ACCESSOR对应的数据对象进行存储
 *  <li>将ACCESSOR操作的数据对象填充到模型对象
 * </ul>
 * 从模型对象中取出对应数据
 * 
 * @author hongmin.zhonghm
 * @version $Id: DataAccessor.java, v 0.1 2014-4-13 上午12:40:14 hongmin.zhonghm Exp $
 */
public interface DataAccessor {
    /** 删除记录个数 */
    public static final int DELETE_RECORD_NUM = 1;

    /** 更新记录个数 */
    public static final int UPDATE_RECORD_NUM = 1;

    /**
     * 储存领域模型。
     *
     * @param model
     */
    public void store(DomainModel model);

    /**
     * 储存更新后的领域模型。
     *
     * @param model
     */
    public void reStore(DomainModel model);

    /**
     * 废弃(删除)部分信息。
     *
     * @param model
     */
    public void deprecate(DomainModel model);

    /**
     * 填充模型
     * <p>
     * 注意：对于<code>Collection</code>类型对象的填充，必须保证已初始化。否则异常
     *
     * @param model
     */
    public void fill(DomainModel model);

    /**
     * 以主键锁定记录，填充模型
     * <p>
     * 注意：对于<code>Collection</code>类型对象的填充，必须保证已初始化。否则异常
     *
     * @param model
     */
    public void lockFill(DomainModel model);

    /**
     * 非主键填充模型，支持幂等性请求专用。各子类视具体情况实现。
     *
     * @param model
     */
    public void reFill(DomainModel model);
}
