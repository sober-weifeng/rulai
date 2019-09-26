package com.rulai.spider.manager;

import com.rulai.spider.bean.model.ChinacaipuSecondCategoryDO;
import com.rulai.spider.bean.query.ChinacaipuSecondCategoryQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.ChinacaipuSecondCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ChinacaipuSecondCategory.
 */
@Component
public class ChinacaipuSecondCategoryManager {

    @Autowired
    private ChinacaipuSecondCategoryExtMapper chinacaipuSecondCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ChinacaipuSecondCategoryQuery query){
        return chinacaipuSecondCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return chinacaipuSecondCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ChinacaipuSecondCategoryQuery query) {
        return chinacaipuSecondCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return chinacaipuSecondCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ChinacaipuSecondCategoryDO record) {
        return chinacaipuSecondCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ChinacaipuSecondCategoryDO> records) {
        return chinacaipuSecondCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ChinacaipuSecondCategoryDO> selectByQuery(ChinacaipuSecondCategoryQuery query) {
        return chinacaipuSecondCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ChinacaipuSecondCategoryDO> selectByQueryWithPage(ChinacaipuSecondCategoryQuery query) {
        PageResult<ChinacaipuSecondCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ChinacaipuSecondCategoryDO selectByPrimaryKey(Long id) {
        return chinacaipuSecondCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( ChinacaipuSecondCategoryDO record, ChinacaipuSecondCategoryQuery query) {
        return chinacaipuSecondCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ChinacaipuSecondCategoryDO record, ChinacaipuSecondCategoryQuery query) {
        return chinacaipuSecondCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ChinacaipuSecondCategoryDO record) {
        return chinacaipuSecondCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ChinacaipuSecondCategoryDO> records) {
        return chinacaipuSecondCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ChinacaipuSecondCategoryDO> records) {
        return chinacaipuSecondCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public ChinacaipuSecondCategoryDO selectByCategoryUrl(String categoryUrl) {
        ChinacaipuSecondCategoryQuery query = new ChinacaipuSecondCategoryQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return chinacaipuSecondCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
    public List<ChinacaipuSecondCategoryDO> selectNotCrawled() {
        ChinacaipuSecondCategoryQuery query = new ChinacaipuSecondCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return chinacaipuSecondCategoryMapper.selectByQuery(query);
    }
    
}