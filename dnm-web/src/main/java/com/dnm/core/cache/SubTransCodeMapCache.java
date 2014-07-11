/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache;

import java.util.List;

/**
 * ҵ�����������ӽ�����ӳ�仺��
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubTransCodeMapCache.java, v 0.1 2014-6-10 ����10:34:16 hongmin.zhonghm Exp $
 */
public interface SubTransCodeMapCache {

    /**
     * ����ҵ����ӽ������������ӽ�����
     * 
     * @param transSubCode
     * @return
     */
    public List<String> getAccountTransSubCodes(String transSubCode);

}
