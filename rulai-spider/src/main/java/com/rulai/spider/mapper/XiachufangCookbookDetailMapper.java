package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.XiachufangCookbookDetailDO;
import com.rulai.spider.bean.query.XiachufangCookbookDetailQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for XiachufangCookbookDetail.
 */
@Component
@Mapper
public interface XiachufangCookbookDetailMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(XiachufangCookbookDetailQuery query);
    
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
    int deleteByQuery(XiachufangCookbookDetailQuery query);

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
    int insertSelective(XiachufangCookbookDetailDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<XiachufangCookbookDetailDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<XiachufangCookbookDetailDO> selectByQuery(XiachufangCookbookDetailQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    XiachufangCookbookDetailDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") XiachufangCookbookDetailDO record, @Param("query") XiachufangCookbookDetailQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") XiachufangCookbookDetailDO record, @Param("query") XiachufangCookbookDetailQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(XiachufangCookbookDetailDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<XiachufangCookbookDetailDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<XiachufangCookbookDetailDO> records);
    
}