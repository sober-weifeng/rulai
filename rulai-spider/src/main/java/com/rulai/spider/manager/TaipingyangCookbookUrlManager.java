package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.TaipingyangCookbookUrlDO;
import com.rulai.spider.bean.query.TaipingyangCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.TaipingyangCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TaipingyangCookbookUrl.
 */
@Component
public class TaipingyangCookbookUrlManager {

    @Autowired
    private TaipingyangCookbookUrlExtMapper taipingyangCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TaipingyangCookbookUrlQuery query){
        return taipingyangCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return taipingyangCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TaipingyangCookbookUrlQuery query) {
        return taipingyangCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return taipingyangCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TaipingyangCookbookUrlDO record) {
        return taipingyangCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TaipingyangCookbookUrlDO> records) {
        return taipingyangCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TaipingyangCookbookUrlDO> selectByQuery(TaipingyangCookbookUrlQuery query) {
        return taipingyangCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TaipingyangCookbookUrlDO> selectByQueryWithPage(TaipingyangCookbookUrlQuery query) {
        PageResult<TaipingyangCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TaipingyangCookbookUrlDO selectByPrimaryKey(Long id) {
        return taipingyangCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( TaipingyangCookbookUrlDO record, TaipingyangCookbookUrlQuery query) {
        return taipingyangCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TaipingyangCookbookUrlDO record, TaipingyangCookbookUrlQuery query) {
        return taipingyangCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TaipingyangCookbookUrlDO record) {
        return taipingyangCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TaipingyangCookbookUrlDO> records) {
        return taipingyangCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TaipingyangCookbookUrlDO> records) {
        return taipingyangCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public TaipingyangCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        TaipingyangCookbookUrlQuery query = new TaipingyangCookbookUrlQuery();
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return taipingyangCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
    public List<TaipingyangCookbookUrlDO> selectNotCrawled() {
        TaipingyangCookbookUrlQuery query = new TaipingyangCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return taipingyangCookbookUrlMapper.selectByQuery(query);
    }

    public int updateAllCrawledStatusToNo() {
        TaipingyangCookbookUrlDO record = new TaipingyangCookbookUrlDO();
        record.setIsCrawled(IsCrawledEnum.NO.getCode());
        TaipingyangCookbookUrlQuery query = new TaipingyangCookbookUrlQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.YES.getCode());
        return taipingyangCookbookUrlMapper.updateByQuerySelective(record, query);
    }
    
}