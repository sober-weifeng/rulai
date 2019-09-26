package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.mapper.ZuofanCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for ZuofanCookbookUrl.
 */
@Component
@Mapper
public interface ZuofanCookbookUrlExtMapper extends ZuofanCookbookUrlMapper {

    SplitterDTO selectNoCrawledMinMaxId();
    
}