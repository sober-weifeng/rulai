package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.MeishiCategoryDO;
import com.rulai.spider.bean.query.MeishiCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for MeishiCategory.
 */
@Component
@Mapper
public interface MeishiCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(MeishiCategoryQuery query);
    
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
    int deleteByQuery(MeishiCategoryQuery query);

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
    int insertSelective(MeishiCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<MeishiCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<MeishiCategoryDO> selectByQuery(MeishiCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    MeishiCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") MeishiCategoryDO record, @Param("query") MeishiCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") MeishiCategoryDO record, @Param("query") MeishiCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MeishiCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<MeishiCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<MeishiCategoryDO> records);
    
}