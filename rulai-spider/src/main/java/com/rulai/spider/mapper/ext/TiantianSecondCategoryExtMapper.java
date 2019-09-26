package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.TiantianSecondCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for TiantianSecondCategory.
 */
@Component
@Mapper
public interface TiantianSecondCategoryExtMapper extends TiantianSecondCategoryMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}