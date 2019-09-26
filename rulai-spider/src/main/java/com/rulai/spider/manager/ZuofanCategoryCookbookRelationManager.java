package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.ZuofanCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.ZuofanCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.ZuofanCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ZuofanCategoryCookbookRelation.
 */
@Component
public class ZuofanCategoryCookbookRelationManager {

    @Autowired
    private ZuofanCategoryCookbookRelationExtMapper zuofanCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ZuofanCategoryCookbookRelationQuery query){
        return zuofanCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return zuofanCategoryCookbookRelationMapper.countByPrimaryKey(id);
    }
    
    /**
     * query count by primary key.
     */
    public boolean isExistByPrimaryKey(Long id) {
        return (countByPrimaryKey(id) > 0);
    }

    /**
     * delete by query condition.
     */
    public int deleteByQuery(ZuofanCategoryCookbookRelationQuery query) {
        return zuofanCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return zuofanCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ZuofanCategoryCookbookRelationDO record) {
        return zuofanCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ZuofanCategoryCookbookRelationDO> records) {
        return zuofanCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ZuofanCategoryCookbookRelationDO> selectByQuery(ZuofanCategoryCookbookRelationQuery query) {
        return zuofanCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ZuofanCategoryCookbookRelationDO> selectByQueryWithPage(ZuofanCategoryCookbookRelationQuery query) {
        PageResult<ZuofanCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ZuofanCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return zuofanCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(ZuofanCategoryCookbookRelationDO record, ZuofanCategoryCookbookRelationQuery query) {
        return zuofanCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ZuofanCategoryCookbookRelationDO record, ZuofanCategoryCookbookRelationQuery query) {
        return zuofanCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ZuofanCategoryCookbookRelationDO record) {
        return zuofanCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ZuofanCategoryCookbookRelationDO> records) {
        return zuofanCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ZuofanCategoryCookbookRelationDO> records) {
        return zuofanCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public ZuofanCategoryCookbookRelationDO selectByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        ZuofanCategoryCookbookRelationQuery query = new ZuofanCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return zuofanCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}