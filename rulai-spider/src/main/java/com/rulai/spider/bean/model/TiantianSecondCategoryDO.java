package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TiantianSecondCategoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column tiantian_second_category.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column tiantian_second_category.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column tiantian_second_category.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column tiantian_second_category.top_category_id
     * 字段备注：
     */
    private Long topCategoryId;

    /**
     * This field corresponds to the database column tiantian_second_category.is_crawled
     * 字段备注：1为未爬，2为已爬
     */
    private Integer isCrawled;

    /**
     * This field corresponds to the database column tiantian_second_category.is_effective
     * 字段备注：
     */
    private Integer isEffective;

    /**
     * This field corresponds to the database column tiantian_second_category.father_name
     * 字段备注：
     */
    private String fatherName;

    /**
     * This field corresponds to the database column tiantian_second_category.category_name
     * 字段备注：
     */
    private String categoryName;

    /**
     * This field corresponds to the database column tiantian_second_category.category_url
     * 字段备注：
     */
    private String categoryUrl;

}