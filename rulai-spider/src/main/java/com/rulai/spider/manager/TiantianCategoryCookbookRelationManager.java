package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.TiantianCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.TiantianCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.TiantianCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TiantianCategoryCookbookRelation.
 */
@Component
public class TiantianCategoryCookbookRelationManager {

    @Autowired
    private TiantianCategoryCookbookRelationExtMapper tiantianCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TiantianCategoryCookbookRelationQuery query){
        return tiantianCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return tiantianCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TiantianCategoryCookbookRelationQuery query) {
        return tiantianCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return tiantianCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TiantianCategoryCookbookRelationDO record) {
        return tiantianCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TiantianCategoryCookbookRelationDO> records) {
        return tiantianCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TiantianCategoryCookbookRelationDO> selectByQuery(TiantianCategoryCookbookRelationQuery query) {
        return tiantianCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TiantianCategoryCookbookRelationDO> selectByQueryWithPage(TiantianCategoryCookbookRelationQuery query) {
        PageResult<TiantianCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TiantianCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return tiantianCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(TiantianCategoryCookbookRelationDO record, TiantianCategoryCookbookRelationQuery query) {
        return tiantianCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TiantianCategoryCookbookRelationDO record, TiantianCategoryCookbookRelationQuery query) {
        return tiantianCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TiantianCategoryCookbookRelationDO record) {
        return tiantianCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TiantianCategoryCookbookRelationDO> records) {
        return tiantianCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TiantianCategoryCookbookRelationDO> records) {
        return tiantianCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public TiantianCategoryCookbookRelationDO selectByCookbookUrlIdAndSecondCategoryId(Long cookbookUrlId, Long secondCategoryId) {
        TiantianCategoryCookbookRelationQuery query = new TiantianCategoryCookbookRelationQuery();
        query.createCriteria().andSecondCategoryIdEqualTo(secondCategoryId).andCookbookUrlIdEqualTo(cookbookUrlId);
        return tiantianCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}