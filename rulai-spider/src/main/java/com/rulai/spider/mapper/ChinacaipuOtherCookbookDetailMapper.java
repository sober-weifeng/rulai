package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.ChinacaipuOtherCookbookDetailDO;
import com.rulai.spider.bean.query.ChinacaipuOtherCookbookDetailQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for ChinacaipuOtherCookbookDetail.
 */
@Component
@Mapper
public interface ChinacaipuOtherCookbookDetailMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(ChinacaipuOtherCookbookDetailQuery query);
    
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
    int deleteByQuery(ChinacaipuOtherCookbookDetailQuery query);

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
    int insertSelective(ChinacaipuOtherCookbookDetailDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<ChinacaipuOtherCookbookDetailDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<ChinacaipuOtherCookbookDetailDO> selectByQuery(ChinacaipuOtherCookbookDetailQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    ChinacaipuOtherCookbookDetailDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") ChinacaipuOtherCookbookDetailDO record, @Param("query") ChinacaipuOtherCookbookDetailQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") ChinacaipuOtherCookbookDetailDO record, @Param("query") ChinacaipuOtherCookbookDetailQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChinacaipuOtherCookbookDetailDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<ChinacaipuOtherCookbookDetailDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<ChinacaipuOtherCookbookDetailDO> records);
    
}