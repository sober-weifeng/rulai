package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.ZuofanCookbookUrlDO;
import com.rulai.spider.bean.query.ZuofanCookbookUrlQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for ZuofanCookbookUrl.
 */
@Component
@Mapper
public interface ZuofanCookbookUrlMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(ZuofanCookbookUrlQuery query);
    
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
    int deleteByQuery(ZuofanCookbookUrlQuery query);

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
    int insertSelective(ZuofanCookbookUrlDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<ZuofanCookbookUrlDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<ZuofanCookbookUrlDO> selectByQuery(ZuofanCookbookUrlQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    ZuofanCookbookUrlDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") ZuofanCookbookUrlDO record, @Param("query") ZuofanCookbookUrlQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") ZuofanCookbookUrlDO record, @Param("query") ZuofanCookbookUrlQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZuofanCookbookUrlDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<ZuofanCookbookUrlDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<ZuofanCookbookUrlDO> records);
    
}