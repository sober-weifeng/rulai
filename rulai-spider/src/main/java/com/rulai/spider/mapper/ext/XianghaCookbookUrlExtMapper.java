package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.XianghaCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for XianghaCookbookUrl.
 */
@Component
@Mapper
public interface XianghaCookbookUrlExtMapper extends XianghaCookbookUrlMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}