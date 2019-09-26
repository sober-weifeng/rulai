package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.MeishijieSecondCategoryDO;
import com.rulai.spider.bean.query.MeishijieSecondCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for MeishijieSecondCategory.
 */
@Component
@Mapper
public interface MeishijieSecondCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(MeishijieSecondCategoryQuery query);
    
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
    int deleteByQuery(MeishijieSecondCategoryQuery query);

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
    int insertSelective(MeishijieSecondCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<MeishijieSecondCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<MeishijieSecondCategoryDO> selectByQuery(MeishijieSecondCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    MeishijieSecondCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") MeishijieSecondCategoryDO record, @Param("query") MeishijieSecondCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") MeishijieSecondCategoryDO record, @Param("query") MeishijieSecondCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MeishijieSecondCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<MeishijieSecondCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<MeishijieSecondCategoryDO> records);
    
}