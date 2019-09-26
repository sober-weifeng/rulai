package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.FancaiCookbookDetailDO;
import com.rulai.spider.bean.query.FancaiCookbookDetailQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for FancaiCookbookDetail.
 */
@Component
@Mapper
public interface FancaiCookbookDetailMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(FancaiCookbookDetailQuery query);
    
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
    int deleteByQuery(FancaiCookbookDetailQuery query);

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
    int insertSelective(FancaiCookbookDetailDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<FancaiCookbookDetailDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<FancaiCookbookDetailDO> selectByQuery(FancaiCookbookDetailQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    FancaiCookbookDetailDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") FancaiCookbookDetailDO record, @Param("query") FancaiCookbookDetailQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") FancaiCookbookDetailDO record, @Param("query") FancaiCookbookDetailQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FancaiCookbookDetailDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<FancaiCookbookDetailDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<FancaiCookbookDetailDO> records);
    
}