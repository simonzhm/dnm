/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.api;

import com.dnm.facade.anotation.FacadeApi;
import com.dnm.facade.request.InvestRequest;
import com.dnm.facade.result.BaseResult;

/**
 * 投标服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestServiceFacade.java, v 0.1 2014-5-25 下午6:20:40 hongmin.zhonghm Exp $
 */
@FacadeApi
public interface InvestServiceFacade {

    /**
     * 投标
     * 
     * @param requestdata
     * @return
     */
    public BaseResult invest(InvestRequest requestdata);

}
