package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.ChinacaipuCookbookUrlDO;
import com.rulai.spider.bean.query.ChinacaipuCookbookUrlQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for ChinacaipuCookbookUrl.
 */
@Component
@Mapper
public interface ChinacaipuCookbookUrlMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(ChinacaipuCookbookUrlQuery query);
    
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
    int deleteByQuery(ChinacaipuCookbookUrlQuery query);

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
    int insertSelective(ChinacaipuCookbookUrlDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<ChinacaipuCookbookUrlDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<ChinacaipuCookbookUrlDO> selectByQuery(ChinacaipuCookbookUrlQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    ChinacaipuCookbookUrlDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") ChinacaipuCookbookUrlDO record, @Param("query") ChinacaipuCookbookUrlQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") ChinacaipuCookbookUrlDO record, @Param("query") ChinacaipuCookbookUrlQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChinacaipuCookbookUrlDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<ChinacaipuCookbookUrlDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<ChinacaipuCookbookUrlDO> records);
    
}