package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.XinshipuCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.XinshipuCategoryCookbookRelationQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for XinshipuCategoryCookbookRelation.
 */
@Component
@Mapper
public interface XinshipuCategoryCookbookRelationMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(XinshipuCategoryCookbookRelationQuery query);
    
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
    int deleteByQuery(XinshipuCategoryCookbookRelationQuery query);

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
    int insertSelective(XinshipuCategoryCookbookRelationDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<XinshipuCategoryCookbookRelationDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<XinshipuCategoryCookbookRelationDO> selectByQuery(XinshipuCategoryCookbookRelationQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    XinshipuCategoryCookbookRelationDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") XinshipuCategoryCookbookRelationDO record, @Param("query") XinshipuCategoryCookbookRelationQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") XinshipuCategoryCookbookRelationDO record, @Param("query") XinshipuCategoryCookbookRelationQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(XinshipuCategoryCookbookRelationDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<XinshipuCategoryCookbookRelationDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<XinshipuCategoryCookbookRelationDO> records);
    
}