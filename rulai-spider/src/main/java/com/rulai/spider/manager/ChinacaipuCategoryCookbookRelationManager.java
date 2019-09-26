package com.rulai.spider.manager;

import com.rulai.spider.bean.model.ChinacaipuCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.ChinacaipuCategoryCookbookRelationQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.mapper.ext.ChinacaipuCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ChinacaipuCategoryCookbookRelation.
 */
@Component
public class ChinacaipuCategoryCookbookRelationManager {

    @Autowired
    private ChinacaipuCategoryCookbookRelationExtMapper chinacaipuCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ChinacaipuCategoryCookbookRelationQuery query){
        return chinacaipuCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return chinacaipuCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ChinacaipuCategoryCookbookRelationQuery query) {
        return chinacaipuCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return chinacaipuCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ChinacaipuCategoryCookbookRelationDO record) {
        return chinacaipuCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ChinacaipuCategoryCookbookRelationDO> records) {
        return chinacaipuCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ChinacaipuCategoryCookbookRelationDO> selectByQuery(ChinacaipuCategoryCookbookRelationQuery query) {
        return chinacaipuCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ChinacaipuCategoryCookbookRelationDO> selectByQueryWithPage(ChinacaipuCategoryCookbookRelationQuery query) {
        PageResult<ChinacaipuCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ChinacaipuCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return chinacaipuCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( ChinacaipuCategoryCookbookRelationDO record, ChinacaipuCategoryCookbookRelationQuery query) {
        return chinacaipuCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ChinacaipuCategoryCookbookRelationDO record, ChinacaipuCategoryCookbookRelationQuery query) {
        return chinacaipuCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ChinacaipuCategoryCookbookRelationDO record) {
        return chinacaipuCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ChinacaipuCategoryCookbookRelationDO> records) {
        return chinacaipuCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ChinacaipuCategoryCookbookRelationDO> records) {
        return chinacaipuCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public int countByCookbookUrlIdAndSecondCategoryId(Long cookbookUrlId, Long secondCategoryId) {
        ChinacaipuCategoryCookbookRelationQuery query = new ChinacaipuCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andSecondCategoryIdEqualTo(secondCategoryId);
        return chinacaipuCategoryCookbookRelationMapper.countByQuery(query);
    }

    public int countByCookbookUrlIdAndTopCategoryId(Long cookbookUrlId, Long topCategoryId) {
        ChinacaipuCategoryCookbookRelationQuery query = new ChinacaipuCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andTopCategoryIdEqualTo(topCategoryId);
        return chinacaipuCategoryCookbookRelationMapper.countByQuery(query);
    }
    
}