/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.dal.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.dnm.core.common.dal.daointerface.BaseDao;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * 基础数据操作类
 * 
 * @author hongmin.zhonghm
 * @version $Id: IbatisBaseDao.java, v 0.1 2014-4-7 下午8:24:51 hongmin.zhonghm Exp $
 */
public class IbatisBaseDao extends SqlMapClientDaoSupport implements BaseDao {

    public <T> int executeBatch(final String sql, final List<T> datas) {

        SqlMapClientCallback<Integer> callback = new SqlMapClientCallback<Integer>() {

            public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                int counter = 1;
                executor.startBatch();
                for (T dto : datas) {
                    // 需要插入的语句
                    executor.insert(sql, dto);
                    counter++;
                    if (counter % 100 == 0) {
                        executor.executeBatch();
                        executor.startBatch();
                    }
                }
                executor.executeBatch();
                return counter;
            }
        };
        return this.getSqlMapClientTemplate().execute(callback);
    }

}
