package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.xinshipu.CookbookUrlNoCrawledMinMaxIdDTO;
import com.rulai.spider.mapper.XinshipuCookbookUrlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for XinshipuCookbookUrl.
 */
@Component
@Mapper
public interface XinshipuCookbookUrlExtMapper extends XinshipuCookbookUrlMapper {

    CookbookUrlNoCrawledMinMaxIdDTO selectCookbookUrlNoCrawledMinMaxId();
    
}