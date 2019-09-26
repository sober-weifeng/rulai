package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MeishijieCookbookDetailDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.cookbook_url
     * 字段备注：食谱URL
     */
    private String cookbookUrl;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.cookbook_name
     * 字段备注：标题
     */
    private String cookbookName;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.title
     * 字段备注：标题
     */
    private String title;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.cover_picture
     * 字段备注：封面图片
     */
    private String coverPicture;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.technology
     * 字段备注：工艺
     */
    private String technology;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.difficulty
     * 字段备注：难度
     */
    private String difficulty;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.numberofpeople
     * 字段备注：人数
     */
    private String numberofpeople;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.taste
     * 字段备注：口味
     */
    private String taste;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.setuptime
     * 字段备注：准备时间
     */
    private String setuptime;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.cooktime
     * 字段备注：烹饪时间
     */
    private String cooktime;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.description
     * 字段备注：描述
     */
    private String description;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.main_ingredients
     * 字段备注：主料
     */
    private String mainIngredients;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.sup_ingredients
     * 字段备注：辅料
     */
    private String supIngredients;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.steps
     * 字段备注：步骤
     */
    private String steps;

    /**
     * This field corresponds to the database column meishijie_cookbook_detail.tip
     * 字段备注：烹饪技巧
     */
    private String tip;

}