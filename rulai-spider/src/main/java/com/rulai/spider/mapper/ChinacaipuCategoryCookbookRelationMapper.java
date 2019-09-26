package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.ChinacaipuCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.ChinacaipuCategoryCookbookRelationQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for ChinacaipuCategoryCookbookRelation.
 */
@Component
@Mapper
public interface ChinacaipuCategoryCookbookRelationMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(ChinacaipuCategoryCookbookRelationQuery query);
    
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
    int deleteByQuery(ChinacaipuCategoryCookbookRelationQuery query);

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
    int insertSelective(ChinacaipuCategoryCookbookRelationDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<ChinacaipuCategoryCookbookRelationDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<ChinacaipuCategoryCookbookRelationDO> selectByQuery(ChinacaipuCategoryCookbookRelationQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    ChinacaipuCategoryCookbookRelationDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") ChinacaipuCategoryCookbookRelationDO record, @Param("query") ChinacaipuCategoryCookbookRelationQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") ChinacaipuCategoryCookbookRelationDO record, @Param("query") ChinacaipuCategoryCookbookRelationQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChinacaipuCategoryCookbookRelationDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<ChinacaipuCategoryCookbookRelationDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<ChinacaipuCategoryCookbookRelationDO> records);
    
}