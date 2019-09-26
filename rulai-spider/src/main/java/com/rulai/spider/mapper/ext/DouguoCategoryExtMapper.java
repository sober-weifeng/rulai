package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.DouguoCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for DouguoCategory.
 */
@Component
@Mapper
public interface DouguoCategoryExtMapper extends DouguoCategoryMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}