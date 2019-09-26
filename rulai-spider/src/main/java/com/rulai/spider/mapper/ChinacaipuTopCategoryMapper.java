package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.ChinacaipuTopCategoryDO;
import com.rulai.spider.bean.query.ChinacaipuTopCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for ChinacaipuTopCategory.
 */
@Component
@Mapper
public interface ChinacaipuTopCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(ChinacaipuTopCategoryQuery query);
    
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
    int deleteByQuery(ChinacaipuTopCategoryQuery query);

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
    int insertSelective(ChinacaipuTopCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<ChinacaipuTopCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<ChinacaipuTopCategoryDO> selectByQuery(ChinacaipuTopCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    ChinacaipuTopCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") ChinacaipuTopCategoryDO record, @Param("query") ChinacaipuTopCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") ChinacaipuTopCategoryDO record, @Param("query") ChinacaipuTopCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChinacaipuTopCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<ChinacaipuTopCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<ChinacaipuTopCategoryDO> records);
    
}