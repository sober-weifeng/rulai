package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChinacaipuCategoryCookbookRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column chinacaipu_category_cookbook_relation.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column chinacaipu_category_cookbook_relation.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column chinacaipu_category_cookbook_relation.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column chinacaipu_category_cookbook_relation.top_category_id
     * 字段备注：
     */
    private Long topCategoryId;

    /**
     * This field corresponds to the database column chinacaipu_category_cookbook_relation.second_category_id
     * 字段备注：
     */
    private Long secondCategoryId;

    /**
     * This field corresponds to the database column chinacaipu_category_cookbook_relation.cookbook_url_id
     * 字段备注：
     */
    private Long cookbookUrlId;

}