package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.ZuofanCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for ZuofanCategory.
 */
@Component
@Mapper
public interface ZuofanCategoryExtMapper extends ZuofanCategoryMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}