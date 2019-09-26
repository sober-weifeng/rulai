package com.rulai.spider.manager;

import com.rulai.spider.bean.model.TaipingyangSecondCategoryDO;
import com.rulai.spider.bean.query.TaipingyangSecondCategoryQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.mapper.ext.TaipingyangSecondCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TaipingyangSecondCategory.
 */
@Component
public class TaipingyangSecondCategoryManager {

    @Autowired
    private TaipingyangSecondCategoryExtMapper taipingyangSecondCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TaipingyangSecondCategoryQuery query){
        return taipingyangSecondCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return taipingyangSecondCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TaipingyangSecondCategoryQuery query) {
        return taipingyangSecondCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return taipingyangSecondCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TaipingyangSecondCategoryDO record) {
        return taipingyangSecondCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TaipingyangSecondCategoryDO> records) {
        return taipingyangSecondCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TaipingyangSecondCategoryDO> selectByQuery(TaipingyangSecondCategoryQuery query) {
        return taipingyangSecondCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TaipingyangSecondCategoryDO> selectByQueryWithPage(TaipingyangSecondCategoryQuery query) {
        PageResult<TaipingyangSecondCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TaipingyangSecondCategoryDO selectByPrimaryKey(Long id) {
        return taipingyangSecondCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( TaipingyangSecondCategoryDO record, TaipingyangSecondCategoryQuery query) {
        return taipingyangSecondCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TaipingyangSecondCategoryDO record, TaipingyangSecondCategoryQuery query) {
        return taipingyangSecondCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TaipingyangSecondCategoryDO record) {
        return taipingyangSecondCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TaipingyangSecondCategoryDO> records) {
        return taipingyangSecondCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TaipingyangSecondCategoryDO> records) {
        return taipingyangSecondCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public TaipingyangSecondCategoryDO selectByLabelId(String labelId) {
        TaipingyangSecondCategoryQuery query = new TaipingyangSecondCategoryQuery();
        query.createCriteria().andLabelIdEqualTo(labelId);
        return taipingyangSecondCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}