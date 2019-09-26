package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.TaipingyangTopCategoryDO;
import com.rulai.spider.bean.query.TaipingyangTopCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.TaipingyangTopCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TaipingyangTopCategory.
 */
@Component
public class TaipingyangTopCategoryManager {

    @Autowired
    private TaipingyangTopCategoryExtMapper taipingyangTopCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TaipingyangTopCategoryQuery query){
        return taipingyangTopCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return taipingyangTopCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TaipingyangTopCategoryQuery query) {
        return taipingyangTopCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return taipingyangTopCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TaipingyangTopCategoryDO record) {
        return taipingyangTopCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TaipingyangTopCategoryDO> records) {
        return taipingyangTopCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TaipingyangTopCategoryDO> selectByQuery(TaipingyangTopCategoryQuery query) {
        return taipingyangTopCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TaipingyangTopCategoryDO> selectByQueryWithPage(TaipingyangTopCategoryQuery query) {
        PageResult<TaipingyangTopCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TaipingyangTopCategoryDO selectByPrimaryKey(Long id) {
        return taipingyangTopCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( TaipingyangTopCategoryDO record, TaipingyangTopCategoryQuery query) {
        return taipingyangTopCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TaipingyangTopCategoryDO record, TaipingyangTopCategoryQuery query) {
        return taipingyangTopCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TaipingyangTopCategoryDO record) {
        return taipingyangTopCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TaipingyangTopCategoryDO> records) {
        return taipingyangTopCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TaipingyangTopCategoryDO> records) {
        return taipingyangTopCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    /**
     * 根据url获取已有数据
     * @param categoryUrl
     * @return
     */
    public TaipingyangTopCategoryDO selectByCategoryUrl(String categoryUrl) {
        TaipingyangTopCategoryQuery query = new TaipingyangTopCategoryQuery();
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return taipingyangTopCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    /**
     * 获取未爬取的数据
     * @return
     */
    public List<TaipingyangTopCategoryDO> selectNotCrawled() {
        TaipingyangTopCategoryQuery query = new TaipingyangTopCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return taipingyangTopCategoryMapper.selectByQuery(query);
    }
    
    public int updateAllCrawledStatusToNo() {
        TaipingyangTopCategoryDO record = new TaipingyangTopCategoryDO();
        record.setIsCrawled(IsCrawledEnum.NO.getCode());
        TaipingyangTopCategoryQuery query = new TaipingyangTopCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.YES.getCode());
        return taipingyangTopCategoryMapper.updateByQuerySelective(record, query);
    }
    
}