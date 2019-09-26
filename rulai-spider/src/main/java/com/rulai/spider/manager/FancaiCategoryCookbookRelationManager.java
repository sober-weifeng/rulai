package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.FancaiCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.FancaiCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.FancaiCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FancaiCategoryCookbookRelation.
 */
@Component
public class FancaiCategoryCookbookRelationManager {

    @Autowired
    private FancaiCategoryCookbookRelationExtMapper fancaiCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(FancaiCategoryCookbookRelationQuery query){
        return fancaiCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return fancaiCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(FancaiCategoryCookbookRelationQuery query) {
        return fancaiCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return fancaiCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(FancaiCategoryCookbookRelationDO record) {
        return fancaiCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<FancaiCategoryCookbookRelationDO> records) {
        return fancaiCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<FancaiCategoryCookbookRelationDO> selectByQuery(FancaiCategoryCookbookRelationQuery query) {
        return fancaiCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<FancaiCategoryCookbookRelationDO> selectByQueryWithPage(FancaiCategoryCookbookRelationQuery query) {
        PageResult<FancaiCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public FancaiCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return fancaiCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(FancaiCategoryCookbookRelationDO record, FancaiCategoryCookbookRelationQuery query) {
        return fancaiCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(FancaiCategoryCookbookRelationDO record, FancaiCategoryCookbookRelationQuery query) {
        return fancaiCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(FancaiCategoryCookbookRelationDO record) {
        return fancaiCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<FancaiCategoryCookbookRelationDO> records) {
        return fancaiCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<FancaiCategoryCookbookRelationDO> records) {
        return fancaiCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public FancaiCategoryCookbookRelationDO selectByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        FancaiCategoryCookbookRelationQuery query = new FancaiCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return fancaiCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}