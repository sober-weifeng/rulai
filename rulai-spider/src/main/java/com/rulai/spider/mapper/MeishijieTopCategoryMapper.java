package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.MeishijieTopCategoryDO;
import com.rulai.spider.bean.query.MeishijieTopCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for MeishijieTopCategory.
 */
@Component
@Mapper
public interface MeishijieTopCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(MeishijieTopCategoryQuery query);
    
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
    int deleteByQuery(MeishijieTopCategoryQuery query);

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
    int insertSelective(MeishijieTopCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<MeishijieTopCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<MeishijieTopCategoryDO> selectByQuery(MeishijieTopCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    MeishijieTopCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") MeishijieTopCategoryDO record, @Param("query") MeishijieTopCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") MeishijieTopCategoryDO record, @Param("query") MeishijieTopCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MeishijieTopCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<MeishijieTopCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<MeishijieTopCategoryDO> records);
    
}