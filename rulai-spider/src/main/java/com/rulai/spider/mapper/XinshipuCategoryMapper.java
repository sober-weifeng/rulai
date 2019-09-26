package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.XinshipuCategoryDO;
import com.rulai.spider.bean.query.XinshipuCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for XinshipuCategory.
 */
@Component
@Mapper
public interface XinshipuCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(XinshipuCategoryQuery query);
    
    /**
     * query count by primary key.
     * @param id
     * @return
     */
    int countByPrimaryKey(Long id);

    /**
     * delete by query condition.
     * @param query
     * @return
     */
    int deleteByQuery(XinshipuCategoryQuery query);

    /**
     * delete by primary key.
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert selective.
     * @param record
     * @return
     */
    int insertSelective(XinshipuCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<XinshipuCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<XinshipuCategoryDO> selectByQuery(XinshipuCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    XinshipuCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") XinshipuCategoryDO record, @Param("query") XinshipuCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") XinshipuCategoryDO record, @Param("query") XinshipuCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(XinshipuCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<XinshipuCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<XinshipuCategoryDO> records);
    
}