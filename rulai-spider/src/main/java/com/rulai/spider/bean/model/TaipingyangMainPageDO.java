package com.rulai.spider.bean.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaipingyangMainPageDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column taipingyang_main_page.id
     * 字段备注：
     */
    private Long id;

    /**
     * This field corresponds to the database column taipingyang_main_page.main_origin_url
     * 字段备注：
     */
    private String mainOriginUrl;

}