package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.MeishiCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for MeishiCookbookUrl.
 */
@Component
@Mapper
public interface MeishiCookbookUrlExtMapper extends MeishiCookbookUrlMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}