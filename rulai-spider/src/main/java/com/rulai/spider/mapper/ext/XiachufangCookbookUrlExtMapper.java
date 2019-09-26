package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.XiachufangCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for XiachufangCookbookUrl.
 */
@Component
@Mapper
public interface XiachufangCookbookUrlExtMapper extends XiachufangCookbookUrlMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}