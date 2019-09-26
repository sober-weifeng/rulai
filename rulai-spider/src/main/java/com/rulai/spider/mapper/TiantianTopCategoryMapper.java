package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TiantianTopCategoryDO;
import com.rulai.spider.bean.query.TiantianTopCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TiantianTopCategory.
 */
@Component
@Mapper
public interface TiantianTopCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TiantianTopCategoryQuery query);
    
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
    int deleteByQuery(TiantianTopCategoryQuery query);

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
    int insertSelective(TiantianTopCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TiantianTopCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TiantianTopCategoryDO> selectByQuery(TiantianTopCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TiantianTopCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TiantianTopCategoryDO record, @Param("query") TiantianTopCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TiantianTopCategoryDO record, @Param("query") TiantianTopCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TiantianTopCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TiantianTopCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TiantianTopCategoryDO> records);
    
}