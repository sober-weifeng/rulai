package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChinacaipuOtherCookbookDetailDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.gmt_create
     * 字段备注：
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.gmt_update
     * 字段备注：
     */
    private Date gmtUpdate;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.cookbook_url
     * 字段备注：食谱URL
     */
    private String cookbookUrl;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.cookbook_name
     * 字段备注：标题
     */
    private String cookbookName;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.title
     * 字段备注：标题
     */
    private String title;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.author
     * 字段备注：作者
     */
    private String author;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.edit_time
     * 字段备注：编辑时间
     */
    private String editTime;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.description
     * 字段备注：描述
     */
    private String description;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.cover_picture
     * 字段备注：封面图片
     */
    private String coverPicture;

    /**
     * This field corresponds to the database column chinacaipu_other_cookbook_detail.detail
     * 字段备注：明细
     */
    private String detail;

}