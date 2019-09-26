package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.XianghaCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.XianghaCategoryCookbookRelationQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for XianghaCategoryCookbookRelation.
 */
@Component
@Mapper
public interface XianghaCategoryCookbookRelationMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(XianghaCategoryCookbookRelationQuery query);
    
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
    int deleteByQuery(XianghaCategoryCookbookRelationQuery query);

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
    int insertSelective(XianghaCategoryCookbookRelationDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<XianghaCategoryCookbookRelationDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<XianghaCategoryCookbookRelationDO> selectByQuery(XianghaCategoryCookbookRelationQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    XianghaCategoryCookbookRelationDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") XianghaCategoryCookbookRelationDO record, @Param("query") XianghaCategoryCookbookRelationQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") XianghaCategoryCookbookRelationDO record, @Param("query") XianghaCategoryCookbookRelationQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(XianghaCategoryCookbookRelationDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<XianghaCategoryCookbookRelationDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<XianghaCategoryCookbookRelationDO> records);
    
}