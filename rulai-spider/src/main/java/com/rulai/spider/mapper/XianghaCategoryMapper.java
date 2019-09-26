package com.rulai.spider.mapper;

import com.rulai.spider.bean.model.XianghaCategoryDO;
import com.rulai.spider.bean.query.XianghaCategoryQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * MyBatis Mapper for XianghaCategory.
 */
@Component
@Mapper
public interface XianghaCategoryMapper {

    /**
     * query count by query condition.
     * @param query
     * @return
     */
    int countByQuery(XianghaCategoryQuery query);
    
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
    int deleteByQuery(XianghaCategoryQuery query);

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
    int insertSelective(XianghaCategoryDO record);
    
    /**
     * batch insert
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<XianghaCategoryDO> records);

    /**
     * select by query condition.
     * @param query
     * @return
     */
    List<XianghaCategoryDO> selectByQuery(XianghaCategoryQuery query);

    /**
     * select by primary key.
     * @param id
     * @return
     */
    XianghaCategoryDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     * @param record
     * @param query
     * @return
     */
    int updateByQuerySelective(@Param("record") XianghaCategoryDO record, @Param("query") XianghaCategoryQuery query);

    /**
     * update by query condition.
     * @param record
     * @param query
     * @return
     */
    int updateByQuery(@Param("record") XianghaCategoryDO record, @Param("query") XianghaCategoryQuery query);

    /**
     * update by primary key selective.
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(XianghaCategoryDO record);
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKey(@Param("records") List<XianghaCategoryDO> records);
    
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    int batchUpdateByPrimaryKeySelective(@Param("records") List<XianghaCategoryDO> records);
    
}