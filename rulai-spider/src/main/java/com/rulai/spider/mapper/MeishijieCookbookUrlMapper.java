package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.MeishijieCookbookUrlDO;
import com.rulai.spider.bean.query.MeishijieCookbookUrlQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for MeishijieCookbookUrl.
 */
@Component
@Mapper
public interface MeishijieCookbookUrlMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(MeishijieCookbookUrlQuery query);
    
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
    int deleteByQuery(MeishijieCookbookUrlQuery query);

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
    int insertSelective(MeishijieCookbookUrlDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<MeishijieCookbookUrlDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<MeishijieCookbookUrlDO> selectByQuery(MeishijieCookbookUrlQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    MeishijieCookbookUrlDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") MeishijieCookbookUrlDO record, @Param("query") MeishijieCookbookUrlQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") MeishijieCookbookUrlDO record, @Param("query") MeishijieCookbookUrlQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MeishijieCookbookUrlDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<MeishijieCookbookUrlDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<MeishijieCookbookUrlDO> records);
    
}