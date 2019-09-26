package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChinacaipuCookbookDetailDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.cookbook_url
     * 字段备注：食谱URL
     */
    private String cookbookUrl;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.cookbook_name
     * 字段备注：标题
     */
    private String cookbookName;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.title
     * 字段备注：标题
     */
    private String title;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.cover_picture
     * 字段备注：封面图片
     */
    private String coverPicture;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.description
     * 字段备注：描述
     */
    private String description;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.cook_difficult
     * 字段备注：烹饪时间
     */
    private String cookDifficult;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.cook_time
     * 字段备注：忌食人群
     */
    private String cookTime;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.main_ingredients
     * 字段备注：主料
     */
    private String mainIngredients;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.seasonings
     * 字段备注：调料
     */
    private String seasonings;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.steps
     * 字段备注：步骤
     */
    private String steps;

    /**
     * This field corresponds to the database column chinacaipu_cookbook_detail.tips
     * 字段备注：烹饪小贴士
     */
    private String tips;

}