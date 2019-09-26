package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class XianghaCategoryCookbookRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column xiangha_category_cookbook_relation.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column xiangha_category_cookbook_relation.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column xiangha_category_cookbook_relation.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column xiangha_category_cookbook_relation.category_id
     * 字段备注：
     */
    private Long categoryId;

    /**
     * This field corresponds to the database column xiangha_category_cookbook_relation.cookbook_url_id
     * 字段备注：
     */
    private Long cookbookUrlId;

    /**
     * This field corresponds to the database column xiangha_category_cookbook_relation.category_location_url
     * 字段备注：
     */
    private String categoryLocationUrl;

}