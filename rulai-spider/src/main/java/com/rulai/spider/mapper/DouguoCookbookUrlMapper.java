package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.DouguoCookbookUrlDO;
import com.rulai.spider.bean.query.DouguoCookbookUrlQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for DouguoCookbookUrl.
 */
@Component
@Mapper
public interface DouguoCookbookUrlMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(DouguoCookbookUrlQuery query);
    
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
    int deleteByQuery(DouguoCookbookUrlQuery query);

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
    int insertSelective(DouguoCookbookUrlDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<DouguoCookbookUrlDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<DouguoCookbookUrlDO> selectByQuery(DouguoCookbookUrlQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    DouguoCookbookUrlDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") DouguoCookbookUrlDO record, @Param("query") DouguoCookbookUrlQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") DouguoCookbookUrlDO record, @Param("query") DouguoCookbookUrlQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DouguoCookbookUrlDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<DouguoCookbookUrlDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<DouguoCookbookUrlDO> records);
    
}