package com.rulai.spider.manager;

import com.rulai.spider.bean.model.TaipingyangMainPageDO;
import com.rulai.spider.bean.query.TaipingyangMainPageQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.mapper.ext.TaipingyangMainPageExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TaipingyangMainPage.
 */
@Component
public class TaipingyangMainPageManager {

    @Autowired
    private TaipingyangMainPageExtMapper taipingyangMainPageMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TaipingyangMainPageQuery query){
        return taipingyangMainPageMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return taipingyangMainPageMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TaipingyangMainPageQuery query) {
        return taipingyangMainPageMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return taipingyangMainPageMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TaipingyangMainPageDO record) {
        return taipingyangMainPageMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TaipingyangMainPageDO> records) {
        return taipingyangMainPageMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TaipingyangMainPageDO> selectByQuery(TaipingyangMainPageQuery query) {
        return taipingyangMainPageMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TaipingyangMainPageDO> selectByQueryWithPage(TaipingyangMainPageQuery query) {
        PageResult<TaipingyangMainPageDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TaipingyangMainPageDO selectByPrimaryKey(Long id) {
        return taipingyangMainPageMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( TaipingyangMainPageDO record, TaipingyangMainPageQuery query) {
        return taipingyangMainPageMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TaipingyangMainPageDO record, TaipingyangMainPageQuery query) {
        return taipingyangMainPageMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TaipingyangMainPageDO record) {
        return taipingyangMainPageMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TaipingyangMainPageDO> records) {
        return taipingyangMainPageMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TaipingyangMainPageDO> records) {
        return taipingyangMainPageMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public TaipingyangMainPageDO selectMainPage() {
        List<TaipingyangMainPageDO> taipingyangMainPageDOS = taipingyangMainPageMapper.selectByQuery(new TaipingyangMainPageQuery());
        return taipingyangMainPageDOS.stream().findFirst().orElse(null);
    }
    
}