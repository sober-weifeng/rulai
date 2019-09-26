package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class XianghaCategoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column xiangha_category.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column xiangha_category.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column xiangha_category.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column xiangha_category.is_crawled
     * 字段备注：1为未爬，2为已爬
     */
    private Integer isCrawled;

    /**
     * This field corresponds to the database column xiangha_category.is_effective
     * 字段备注：
     */
    private Integer isEffective;

    /**
     * This field corresponds to the database column xiangha_category.first_category_name
     * 字段备注：
     */
    private String firstCategoryName;

    /**
     * This field corresponds to the database column xiangha_category.second_category_name
     * 字段备注：
     */
    private String secondCategoryName;

    /**
     * This field corresponds to the database column xiangha_category.category_url
     * 字段备注：
     */
    private String categoryUrl;

}