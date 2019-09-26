package com.rulai.spider.manager;

import com.rulai.spider.bean.model.TaipingyangCookbookDetailDO;
import com.rulai.spider.bean.query.TaipingyangCookbookDetailQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.mapper.ext.TaipingyangCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TaipingyangCookbookDetail.
 */
@Component
public class TaipingyangCookbookDetailManager {

    @Autowired
    private TaipingyangCookbookDetailExtMapper taipingyangCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TaipingyangCookbookDetailQuery query){
        return taipingyangCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return taipingyangCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TaipingyangCookbookDetailQuery query) {
        return taipingyangCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return taipingyangCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TaipingyangCookbookDetailDO record) {
        return taipingyangCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TaipingyangCookbookDetailDO> records) {
        return taipingyangCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TaipingyangCookbookDetailDO> selectByQuery(TaipingyangCookbookDetailQuery query) {
        return taipingyangCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TaipingyangCookbookDetailDO> selectByQueryWithPage(TaipingyangCookbookDetailQuery query) {
        PageResult<TaipingyangCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TaipingyangCookbookDetailDO selectByPrimaryKey(Long id) {
        return taipingyangCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( TaipingyangCookbookDetailDO record, TaipingyangCookbookDetailQuery query) {
        return taipingyangCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TaipingyangCookbookDetailDO record, TaipingyangCookbookDetailQuery query) {
        return taipingyangCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TaipingyangCookbookDetailDO record) {
        return taipingyangCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TaipingyangCookbookDetailDO> records) {
        return taipingyangCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TaipingyangCookbookDetailDO> records) {
        return taipingyangCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public TaipingyangCookbookDetailDO selectByCookbookUrl(String cookbookUrl) {
        TaipingyangCookbookDetailQuery query = new TaipingyangCookbookDetailQuery();
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return taipingyangCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}