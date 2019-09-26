package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TaipingyangCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.TaipingyangCategoryCookbookRelationQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TaipingyangCategoryCookbookRelation.
 */
@Component
@Mapper
public interface TaipingyangCategoryCookbookRelationMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TaipingyangCategoryCookbookRelationQuery query);
    
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
    int deleteByQuery(TaipingyangCategoryCookbookRelationQuery query);

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
    int insertSelective(TaipingyangCategoryCookbookRelationDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TaipingyangCategoryCookbookRelationDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TaipingyangCategoryCookbookRelationDO> selectByQuery(TaipingyangCategoryCookbookRelationQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TaipingyangCategoryCookbookRelationDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TaipingyangCategoryCookbookRelationDO record, @Param("query") TaipingyangCategoryCookbookRelationQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TaipingyangCategoryCookbookRelationDO record, @Param("query") TaipingyangCategoryCookbookRelationQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TaipingyangCategoryCookbookRelationDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TaipingyangCategoryCookbookRelationDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TaipingyangCategoryCookbookRelationDO> records);
    
}