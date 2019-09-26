package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaipingyangSecondCategoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column taipingyang_second_category.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column taipingyang_second_category.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column taipingyang_second_category.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column taipingyang_second_category.top_category_id
     * 字段备注：
     */
    private Long topCategoryId;

    /**
     * This field corresponds to the database column taipingyang_second_category.category_name
     * 字段备注：
     */
    private String categoryName;

    /**
     * This field corresponds to the database column taipingyang_second_category.label_id
     * 字段备注：
     */
    private String labelId;

}