package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.TaipingyangCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.TaipingyangCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.TaipingyangCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TaipingyangCategoryCookbookRelation.
 */
@Component
public class TaipingyangCategoryCookbookRelationManager {

    @Autowired
    private TaipingyangCategoryCookbookRelationExtMapper taipingyangCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TaipingyangCategoryCookbookRelationQuery query){
        return taipingyangCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return taipingyangCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TaipingyangCategoryCookbookRelationQuery query) {
        return taipingyangCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return taipingyangCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TaipingyangCategoryCookbookRelationDO record) {
        return taipingyangCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TaipingyangCategoryCookbookRelationDO> records) {
        return taipingyangCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TaipingyangCategoryCookbookRelationDO> selectByQuery(TaipingyangCategoryCookbookRelationQuery query) {
        return taipingyangCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TaipingyangCategoryCookbookRelationDO> selectByQueryWithPage(TaipingyangCategoryCookbookRelationQuery query) {
        PageResult<TaipingyangCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TaipingyangCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return taipingyangCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( TaipingyangCategoryCookbookRelationDO record, TaipingyangCategoryCookbookRelationQuery query) {
        return taipingyangCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TaipingyangCategoryCookbookRelationDO record, TaipingyangCategoryCookbookRelationQuery query) {
        return taipingyangCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TaipingyangCategoryCookbookRelationDO record) {
        return taipingyangCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TaipingyangCategoryCookbookRelationDO> records) {
        return taipingyangCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TaipingyangCategoryCookbookRelationDO> records) {
        return taipingyangCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public TaipingyangCategoryCookbookRelationDO selectByThirdCategoryIdAndCookbookUrlId(Long cookbookUrlId, Long thirdCategoryId) {
        TaipingyangCategoryCookbookRelationQuery query = new TaipingyangCategoryCookbookRelationQuery();
        query.createCriteria().andThirdCategoryIdEqualTo(thirdCategoryId)
                .andCookbookUrlIdEqualTo(cookbookUrlId);
        return taipingyangCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}