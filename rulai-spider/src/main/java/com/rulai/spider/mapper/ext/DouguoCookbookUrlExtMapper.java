package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.DouguoCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for DouguoCookbookUrl.
 */
@Component
@Mapper
public interface DouguoCookbookUrlExtMapper extends DouguoCookbookUrlMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}