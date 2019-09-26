package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.TiantianCookbookDetailDO;
import com.rulai.spider.bean.query.TiantianCookbookDetailQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for TiantianCookbookDetail.
 */
@Component
@Mapper
public interface TiantianCookbookDetailMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(TiantianCookbookDetailQuery query);
    
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
    int deleteByQuery(TiantianCookbookDetailQuery query);

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
    int insertSelective(TiantianCookbookDetailDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<TiantianCookbookDetailDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<TiantianCookbookDetailDO> selectByQuery(TiantianCookbookDetailQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    TiantianCookbookDetailDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") TiantianCookbookDetailDO record, @Param("query") TiantianCookbookDetailQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") TiantianCookbookDetailDO record, @Param("query") TiantianCookbookDetailQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TiantianCookbookDetailDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<TiantianCookbookDetailDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<TiantianCookbookDetailDO> records);
    
}