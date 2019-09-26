package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ZuofanCookbookDetailDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.cookbook_url_id
     * 字段备注：食谱URL ID
     */
    private Long cookbookUrlId;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.title
     * 字段备注：标题
     */
    private String title;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.cover_picture
     * 字段备注：封面图片
     */
    private String coverPicture;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.ingredients
     * 字段备注：食材
     */
    private String ingredients;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.seasonings
     * 字段备注：调料
     */
    private String seasonings;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.steps
     * 字段备注：步骤
     */
    private String steps;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.tip
     * 字段备注：烹饪技巧
     */
    private String tip;

    /**
     * This field corresponds to the database column zuofan_cookbook_detail.cryptolalia
     * 字段备注：营养密语
     */
    private String cryptolalia;

}