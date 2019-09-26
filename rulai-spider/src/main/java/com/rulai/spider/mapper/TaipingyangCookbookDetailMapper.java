package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TaipingyangCookbookDetailDO;
import com.rulai.spider.bean.query.TaipingyangCookbookDetailQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TaipingyangCookbookDetail.
 */
@Component
@Mapper
public interface TaipingyangCookbookDetailMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TaipingyangCookbookDetailQuery query);
    
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
    int deleteByQuery(TaipingyangCookbookDetailQuery query);

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
    int insertSelective(TaipingyangCookbookDetailDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TaipingyangCookbookDetailDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TaipingyangCookbookDetailDO> selectByQuery(TaipingyangCookbookDetailQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TaipingyangCookbookDetailDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TaipingyangCookbookDetailDO record, @Param("query") TaipingyangCookbookDetailQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TaipingyangCookbookDetailDO record, @Param("query") TaipingyangCookbookDetailQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TaipingyangCookbookDetailDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TaipingyangCookbookDetailDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TaipingyangCookbookDetailDO> records);
    
}