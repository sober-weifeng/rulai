package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.XiachufangCookbookUrlDO;
import com.rulai.spider.bean.query.XiachufangCookbookUrlQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for XiachufangCookbookUrl.
 */
@Component
@Mapper
public interface XiachufangCookbookUrlMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(XiachufangCookbookUrlQuery query);
    
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
    int deleteByQuery(XiachufangCookbookUrlQuery query);

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
    int insertSelective(XiachufangCookbookUrlDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<XiachufangCookbookUrlDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<XiachufangCookbookUrlDO> selectByQuery(XiachufangCookbookUrlQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    XiachufangCookbookUrlDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") XiachufangCookbookUrlDO record, @Param("query") XiachufangCookbookUrlQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") XiachufangCookbookUrlDO record, @Param("query") XiachufangCookbookUrlQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(XiachufangCookbookUrlDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<XiachufangCookbookUrlDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<XiachufangCookbookUrlDO> records);
    
}