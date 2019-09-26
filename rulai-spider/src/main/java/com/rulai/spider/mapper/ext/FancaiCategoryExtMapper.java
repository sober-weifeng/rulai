package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.FancaiCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for FancaiCategory.
 */
@Component
@Mapper
public interface FancaiCategoryExtMapper extends FancaiCategoryMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}