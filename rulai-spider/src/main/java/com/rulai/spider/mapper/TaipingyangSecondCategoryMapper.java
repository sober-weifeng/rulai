package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TaipingyangSecondCategoryDO;
import com.rulai.spider.bean.query.TaipingyangSecondCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TaipingyangSecondCategory.
 */
@Component
@Mapper
public interface TaipingyangSecondCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TaipingyangSecondCategoryQuery query);
    
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
    int deleteByQuery(TaipingyangSecondCategoryQuery query);

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
    int insertSelective(TaipingyangSecondCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TaipingyangSecondCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TaipingyangSecondCategoryDO> selectByQuery(TaipingyangSecondCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TaipingyangSecondCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TaipingyangSecondCategoryDO record, @Param("query") TaipingyangSecondCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TaipingyangSecondCategoryDO record, @Param("query") TaipingyangSecondCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TaipingyangSecondCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TaipingyangSecondCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TaipingyangSecondCategoryDO> records);
    
}