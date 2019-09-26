package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.TiantianTopCategoryDO;
import com.rulai.spider.bean.query.TiantianTopCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.TiantianTopCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TiantianTopCategory.
 */
@Component
public class TiantianTopCategoryManager {

    @Autowired
    private TiantianTopCategoryExtMapper tiantianTopCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TiantianTopCategoryQuery query){
        return tiantianTopCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return tiantianTopCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TiantianTopCategoryQuery query) {
        return tiantianTopCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return tiantianTopCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TiantianTopCategoryDO record) {
        return tiantianTopCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TiantianTopCategoryDO> records) {
        return tiantianTopCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TiantianTopCategoryDO> selectByQuery(TiantianTopCategoryQuery query) {
        return tiantianTopCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TiantianTopCategoryDO> selectByQueryWithPage(TiantianTopCategoryQuery query) {
        PageResult<TiantianTopCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TiantianTopCategoryDO selectByPrimaryKey(Long id) {
        return tiantianTopCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(TiantianTopCategoryDO record, TiantianTopCategoryQuery query) {
        return tiantianTopCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TiantianTopCategoryDO record, TiantianTopCategoryQuery query) {
        return tiantianTopCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TiantianTopCategoryDO record) {
        return tiantianTopCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TiantianTopCategoryDO> records) {
        return tiantianTopCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TiantianTopCategoryDO> records) {
        return tiantianTopCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public List<TiantianTopCategoryDO> selectNotCrawled() {
        TiantianTopCategoryQuery query = new TiantianTopCategoryQuery();
        query.setOrderByClause("id");
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return tiantianTopCategoryMapper.selectByQuery(query);
    }

    public TiantianTopCategoryDO selectByCategoryUrl(String categoryUrl) {
        TiantianTopCategoryQuery query = new TiantianTopCategoryQuery();
        query.setPageNo(1);
        query.setPageSize(1);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return tiantianTopCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
}