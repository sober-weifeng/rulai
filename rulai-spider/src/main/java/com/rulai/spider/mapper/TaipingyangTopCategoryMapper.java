package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TaipingyangTopCategoryDO;
import com.rulai.spider.bean.query.TaipingyangTopCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TaipingyangTopCategory.
 */
@Component
@Mapper
public interface TaipingyangTopCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TaipingyangTopCategoryQuery query);
    
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
    int deleteByQuery(TaipingyangTopCategoryQuery query);

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
    int insertSelective(TaipingyangTopCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TaipingyangTopCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TaipingyangTopCategoryDO> selectByQuery(TaipingyangTopCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TaipingyangTopCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TaipingyangTopCategoryDO record, @Param("query") TaipingyangTopCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TaipingyangTopCategoryDO record, @Param("query") TaipingyangTopCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TaipingyangTopCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TaipingyangTopCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TaipingyangTopCategoryDO> records);
    
}