package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.TaipingyangThirdCategoryDO;
import com.rulai.spider.bean.query.TaipingyangThirdCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.TaipingyangThirdCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TaipingyangThirdCategory.
 */
@Component
public class TaipingyangThirdCategoryManager {

    @Autowired
    private TaipingyangThirdCategoryExtMapper taipingyangThirdCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TaipingyangThirdCategoryQuery query){
        return taipingyangThirdCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return taipingyangThirdCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TaipingyangThirdCategoryQuery query) {
        return taipingyangThirdCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return taipingyangThirdCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TaipingyangThirdCategoryDO record) {
        return taipingyangThirdCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TaipingyangThirdCategoryDO> records) {
        return taipingyangThirdCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TaipingyangThirdCategoryDO> selectByQuery(TaipingyangThirdCategoryQuery query) {
        return taipingyangThirdCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TaipingyangThirdCategoryDO> selectByQueryWithPage(TaipingyangThirdCategoryQuery query) {
        PageResult<TaipingyangThirdCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TaipingyangThirdCategoryDO selectByPrimaryKey(Long id) {
        return taipingyangThirdCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( TaipingyangThirdCategoryDO record, TaipingyangThirdCategoryQuery query) {
        return taipingyangThirdCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TaipingyangThirdCategoryDO record, TaipingyangThirdCategoryQuery query) {
        return taipingyangThirdCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TaipingyangThirdCategoryDO record) {
        return taipingyangThirdCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TaipingyangThirdCategoryDO> records) {
        return taipingyangThirdCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TaipingyangThirdCategoryDO> records) {
        return taipingyangThirdCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public TaipingyangThirdCategoryDO selectByCategoryUrl(String categoryUrl, Long secondCategoryId) {
        TaipingyangThirdCategoryQuery query = new TaipingyangThirdCategoryQuery();
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl).andSecondCategoryIdEqualTo(secondCategoryId);
        return taipingyangThirdCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
    public List<TaipingyangThirdCategoryDO> selectNotCrawled() {
        TaipingyangThirdCategoryQuery query = new TaipingyangThirdCategoryQuery();
        query.setOrderByClause("id");
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return taipingyangThirdCategoryMapper.selectByQuery(query);
    }

    public int updateAllCrawledStatusToNo() {
        TaipingyangThirdCategoryDO record = new TaipingyangThirdCategoryDO();
        record.setIsCrawled(IsCrawledEnum.NO.getCode());
        TaipingyangThirdCategoryQuery query = new TaipingyangThirdCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.YES.getCode());
        return taipingyangThirdCategoryMapper.updateByQuerySelective(record, query);
    }
    
}