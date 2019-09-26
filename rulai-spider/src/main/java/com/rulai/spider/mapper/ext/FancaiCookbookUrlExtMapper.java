package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.FancaiCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for FancaiCookbookUrl.
 */
@Component
@Mapper
public interface FancaiCookbookUrlExtMapper extends FancaiCookbookUrlMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}