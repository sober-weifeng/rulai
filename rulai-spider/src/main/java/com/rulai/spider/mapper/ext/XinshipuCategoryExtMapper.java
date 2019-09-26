package com.rulai.spider.mapper.ext;

import com.rulai.spider.bean.dto.xinshipu.CategoryNoCrawledMinMaxIdDTO;
import com.rulai.spider.mapper.XinshipuCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * MyBatis Ext Mapper for XinshipuCategory.
 */
@Component
@Mapper
public interface XinshipuCategoryExtMapper extends XinshipuCategoryMapper {

    /**
     * 获取未爬取分类页面最大最小id，方便分片
     * @return
     */
    CategoryNoCrawledMinMaxIdDTO selectCategoryNoCrawledMinMaxId();
    
}