package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TaipingyangThirdCategoryDO;
import com.rulai.spider.bean.query.TaipingyangThirdCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TaipingyangThirdCategory.
 */
@Component
@Mapper
public interface TaipingyangThirdCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TaipingyangThirdCategoryQuery query);
    
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
    int deleteByQuery(TaipingyangThirdCategoryQuery query);

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
    int insertSelective(TaipingyangThirdCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TaipingyangThirdCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TaipingyangThirdCategoryDO> selectByQuery(TaipingyangThirdCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TaipingyangThirdCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TaipingyangThirdCategoryDO record, @Param("query") TaipingyangThirdCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TaipingyangThirdCategoryDO record, @Param("query") TaipingyangThirdCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TaipingyangThirdCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TaipingyangThirdCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TaipingyangThirdCategoryDO> records);
    
}