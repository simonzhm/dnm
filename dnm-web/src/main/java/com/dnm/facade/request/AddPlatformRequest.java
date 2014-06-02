/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * 添加平台请求单据
 * 
 * @author hongmin.zhonghm
 * @version $Id: AddBankRequest.java, v 0.1 2014-5-5 上午10:54:38 hongmin.zhonghm Exp $
 */
public class AddPlatformRequest extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -3832517615228411618L;

    /** 平台名称 */
    @RequestFieldCheck(notEmpty = true)
    private String            name;

    /** 平台描述 */
    private String            description;

    /** 平台网址 */
    private String            url;

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>description</tt>.
     * 
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     * 
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
