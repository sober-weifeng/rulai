package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.MeishiCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for MeishiCategory.
 */
@Component
@Mapper
public interface MeishiCategoryExtMapper extends MeishiCategoryMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}