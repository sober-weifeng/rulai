package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.TiantianCookbookDetailDO;
import com.rulai.spider.bean.query.TiantianCookbookDetailQuery;
import com.rulai.spider.mapper.ext.TiantianCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TiantianCookbookDetail.
 */
@Component
public class TiantianCookbookDetailManager {

    @Autowired
    private TiantianCookbookDetailExtMapper tiantianCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TiantianCookbookDetailQuery query){
        return tiantianCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return tiantianCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TiantianCookbookDetailQuery query) {
        return tiantianCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return tiantianCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TiantianCookbookDetailDO record) {
        return tiantianCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TiantianCookbookDetailDO> records) {
        return tiantianCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TiantianCookbookDetailDO> selectByQuery(TiantianCookbookDetailQuery query) {
        return tiantianCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TiantianCookbookDetailDO> selectByQueryWithPage(TiantianCookbookDetailQuery query) {
        PageResult<TiantianCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TiantianCookbookDetailDO selectByPrimaryKey(Long id) {
        return tiantianCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(TiantianCookbookDetailDO record, TiantianCookbookDetailQuery query) {
        return tiantianCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TiantianCookbookDetailDO record, TiantianCookbookDetailQuery query) {
        return tiantianCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TiantianCookbookDetailDO record) {
        return tiantianCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TiantianCookbookDetailDO> records) {
        return tiantianCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TiantianCookbookDetailDO> records) {
        return tiantianCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public TiantianCookbookDetailDO selectByCookbookUrlId(Long cookbookUrlId) {
        TiantianCookbookDetailQuery query = new TiantianCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId);
        return tiantianCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}