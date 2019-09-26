package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.XianghaCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for XianghaCategory.
 */
@Component
@Mapper
public interface XianghaCategoryExtMapper extends XianghaCategoryMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}