package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.MeishiCookbookDetailDO;
import com.rulai.spider.bean.query.MeishiCookbookDetailQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for MeishiCookbookDetail.
 */
@Component
@Mapper
public interface MeishiCookbookDetailMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(MeishiCookbookDetailQuery query);
    
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
    int deleteByQuery(MeishiCookbookDetailQuery query);

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
    int insertSelective(MeishiCookbookDetailDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<MeishiCookbookDetailDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<MeishiCookbookDetailDO> selectByQuery(MeishiCookbookDetailQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    MeishiCookbookDetailDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") MeishiCookbookDetailDO record, @Param("query") MeishiCookbookDetailQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") MeishiCookbookDetailDO record, @Param("query") MeishiCookbookDetailQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MeishiCookbookDetailDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<MeishiCookbookDetailDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<MeishiCookbookDetailDO> records);
    
}