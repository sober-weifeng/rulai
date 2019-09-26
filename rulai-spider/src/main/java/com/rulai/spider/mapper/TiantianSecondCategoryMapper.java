package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TiantianSecondCategoryDO;
import com.rulai.spider.bean.query.TiantianSecondCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TiantianSecondCategory.
 */
@Component
@Mapper
public interface TiantianSecondCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TiantianSecondCategoryQuery query);
    
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
    int deleteByQuery(TiantianSecondCategoryQuery query);

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
    int insertSelective(TiantianSecondCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TiantianSecondCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TiantianSecondCategoryDO> selectByQuery(TiantianSecondCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TiantianSecondCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TiantianSecondCategoryDO record, @Param("query") TiantianSecondCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TiantianSecondCategoryDO record, @Param("query") TiantianSecondCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TiantianSecondCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TiantianSecondCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TiantianSecondCategoryDO> records);
    
}