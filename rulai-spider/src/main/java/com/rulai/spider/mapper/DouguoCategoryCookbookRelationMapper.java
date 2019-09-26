package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.DouguoCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.DouguoCategoryCookbookRelationQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for DouguoCategoryCookbookRelation.
 */
@Component
@Mapper
public interface DouguoCategoryCookbookRelationMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(DouguoCategoryCookbookRelationQuery query);
    
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
    int deleteByQuery(DouguoCategoryCookbookRelationQuery query);

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
    int insertSelective(DouguoCategoryCookbookRelationDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<DouguoCategoryCookbookRelationDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<DouguoCategoryCookbookRelationDO> selectByQuery(DouguoCategoryCookbookRelationQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    DouguoCategoryCookbookRelationDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") DouguoCategoryCookbookRelationDO record, @Param("query") DouguoCategoryCookbookRelationQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") DouguoCategoryCookbookRelationDO record, @Param("query") DouguoCategoryCookbookRelationQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DouguoCategoryCookbookRelationDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<DouguoCategoryCookbookRelationDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<DouguoCategoryCookbookRelationDO> records);
    
}