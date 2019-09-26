package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.DouguoCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.DouguoCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.DouguoCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for DouguoCategoryCookbookRelation.
 */
@Component
public class DouguoCategoryCookbookRelationManager {

    @Autowired
    private DouguoCategoryCookbookRelationExtMapper douguoCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(DouguoCategoryCookbookRelationQuery query){
        return douguoCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return douguoCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(DouguoCategoryCookbookRelationQuery query) {
        return douguoCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return douguoCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(DouguoCategoryCookbookRelationDO record) {
        return douguoCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<DouguoCategoryCookbookRelationDO> records) {
        return douguoCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<DouguoCategoryCookbookRelationDO> selectByQuery(DouguoCategoryCookbookRelationQuery query) {
        return douguoCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<DouguoCategoryCookbookRelationDO> selectByQueryWithPage(DouguoCategoryCookbookRelationQuery query) {
        PageResult<DouguoCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public DouguoCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return douguoCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(DouguoCategoryCookbookRelationDO record, DouguoCategoryCookbookRelationQuery query) {
        return douguoCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(DouguoCategoryCookbookRelationDO record, DouguoCategoryCookbookRelationQuery query) {
        return douguoCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(DouguoCategoryCookbookRelationDO record) {
        return douguoCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<DouguoCategoryCookbookRelationDO> records) {
        return douguoCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<DouguoCategoryCookbookRelationDO> records) {
        return douguoCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public DouguoCategoryCookbookRelationDO selectByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        DouguoCategoryCookbookRelationQuery query = new DouguoCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return douguoCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}