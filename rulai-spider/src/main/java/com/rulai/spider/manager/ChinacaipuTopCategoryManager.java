package com.rulai.spider.manager;

import com.rulai.spider.bean.model.ChinacaipuTopCategoryDO;
import com.rulai.spider.bean.query.ChinacaipuTopCategoryQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.ChinacaipuTopCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ChinacaipuTopCategory.
 */
@Component
public class ChinacaipuTopCategoryManager {

    @Autowired
    private ChinacaipuTopCategoryExtMapper chinacaipuTopCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ChinacaipuTopCategoryQuery query){
        return chinacaipuTopCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return chinacaipuTopCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ChinacaipuTopCategoryQuery query) {
        return chinacaipuTopCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return chinacaipuTopCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ChinacaipuTopCategoryDO record) {
        return chinacaipuTopCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ChinacaipuTopCategoryDO> records) {
        return chinacaipuTopCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ChinacaipuTopCategoryDO> selectByQuery(ChinacaipuTopCategoryQuery query) {
        return chinacaipuTopCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ChinacaipuTopCategoryDO> selectByQueryWithPage(ChinacaipuTopCategoryQuery query) {
        PageResult<ChinacaipuTopCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ChinacaipuTopCategoryDO selectByPrimaryKey(Long id) {
        return chinacaipuTopCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( ChinacaipuTopCategoryDO record, ChinacaipuTopCategoryQuery query) {
        return chinacaipuTopCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ChinacaipuTopCategoryDO record, ChinacaipuTopCategoryQuery query) {
        return chinacaipuTopCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ChinacaipuTopCategoryDO record) {
        return chinacaipuTopCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ChinacaipuTopCategoryDO> records) {
        return chinacaipuTopCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ChinacaipuTopCategoryDO> records) {
        return chinacaipuTopCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public ChinacaipuTopCategoryDO selectByCategoryUrl(String categoryUrl) {
        ChinacaipuTopCategoryQuery query = new ChinacaipuTopCategoryQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return chinacaipuTopCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
    public List<ChinacaipuTopCategoryDO> selectNotCrawled() {
        ChinacaipuTopCategoryQuery query = new ChinacaipuTopCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return chinacaipuTopCategoryMapper.selectByQuery(query);
    }
    
}