package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ZuofanCookbookUrlDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column zuofan_cookbook_url.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column zuofan_cookbook_url.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column zuofan_cookbook_url.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column zuofan_cookbook_url.is_crawled
     * 字段备注：1为未爬，2为已爬
     */
    private Integer isCrawled;

    /**
     * This field corresponds to the database column zuofan_cookbook_url.cookbook_name
     * 字段备注：
     */
    private String cookbookName;

    /**
     * This field corresponds to the database column zuofan_cookbook_url.cookbook_url
     * 字段备注：
     */
    private String cookbookUrl;

    /**
     * This field corresponds to the database column zuofan_cookbook_url.is_effective
     * 字段备注：1为有效，2为无效
     */
    private Integer isEffective;

}