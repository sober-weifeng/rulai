package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.XianghaCookbookUrlDO;
import com.rulai.spider.bean.query.XianghaCookbookUrlQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for XianghaCookbookUrl.
 */
@Component
@Mapper
public interface XianghaCookbookUrlMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(XianghaCookbookUrlQuery query);
    
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
    int deleteByQuery(XianghaCookbookUrlQuery query);

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
    int insertSelective(XianghaCookbookUrlDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<XianghaCookbookUrlDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<XianghaCookbookUrlDO> selectByQuery(XianghaCookbookUrlQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    XianghaCookbookUrlDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") XianghaCookbookUrlDO record, @Param("query") XianghaCookbookUrlQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") XianghaCookbookUrlDO record, @Param("query") XianghaCookbookUrlQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(XianghaCookbookUrlDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<XianghaCookbookUrlDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<XianghaCookbookUrlDO> records);
    
}