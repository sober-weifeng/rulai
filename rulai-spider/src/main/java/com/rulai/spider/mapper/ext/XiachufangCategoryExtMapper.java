package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.XiachufangCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for XiachufangCategory.
 */
@Component
@Mapper
public interface XiachufangCategoryExtMapper extends XiachufangCategoryMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}