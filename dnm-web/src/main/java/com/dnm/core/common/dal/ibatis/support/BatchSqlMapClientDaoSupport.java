/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.dal.ibatis.support;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * ��д��һ���������������Ļ��ࡣ
 *
 * @author hongmin.zhonghm
 * @version $Id: BatchSqlMapClientDaoSupport.java,v 0.1 2014-05-11 ����10:16:02 hongmin.zhonghm Exp $
 */

public abstract class BatchSqlMapClientDaoSupport extends SqlMapClientDaoSupport {

    /**
     * �������������
     * 
     * @param statementName
     * @param parameterList
     */
    protected Integer batchInsert(final String statementName, final List<?> parameterList) {
        return getSqlMapClientTemplate().execute(new SqlMapClientCallback<Integer>() {

            @Override
            public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {

                executor.startBatch();

                for (Iterator<?> i = parameterList.iterator(); i.hasNext();) {

                    executor.insert(statementName, i.next());
                }

                return executor.executeBatch();
            }
        });
    }
}
