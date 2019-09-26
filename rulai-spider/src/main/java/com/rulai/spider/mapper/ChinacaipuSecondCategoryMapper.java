package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.ChinacaipuSecondCategoryDO;
import com.rulai.spider.bean.query.ChinacaipuSecondCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for ChinacaipuSecondCategory.
 */
@Component
@Mapper
public interface ChinacaipuSecondCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(ChinacaipuSecondCategoryQuery query);
    
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
    int deleteByQuery(ChinacaipuSecondCategoryQuery query);

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
    int insertSelective(ChinacaipuSecondCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<ChinacaipuSecondCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<ChinacaipuSecondCategoryDO> selectByQuery(ChinacaipuSecondCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    ChinacaipuSecondCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") ChinacaipuSecondCategoryDO record, @Param("query") ChinacaipuSecondCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") ChinacaipuSecondCategoryDO record, @Param("query") ChinacaipuSecondCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChinacaipuSecondCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<ChinacaipuSecondCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<ChinacaipuSecondCategoryDO> records);
    
}