package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.TiantianCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for TiantianCookbookUrl.
 */
@Component
@Mapper
public interface TiantianCookbookUrlExtMapper extends TiantianCookbookUrlMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}