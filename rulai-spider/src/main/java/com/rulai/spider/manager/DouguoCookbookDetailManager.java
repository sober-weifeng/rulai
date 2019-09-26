package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.DouguoCookbookDetailDO;
import com.rulai.spider.bean.query.DouguoCookbookDetailQuery;
import com.rulai.spider.mapper.ext.DouguoCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for DouguoCookbookDetail.
 */
@Component
public class DouguoCookbookDetailManager {

    @Autowired
    private DouguoCookbookDetailExtMapper douguoCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(DouguoCookbookDetailQuery query){
        return douguoCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return douguoCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(DouguoCookbookDetailQuery query) {
        return douguoCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return douguoCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(DouguoCookbookDetailDO record) {
        return douguoCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<DouguoCookbookDetailDO> records) {
        return douguoCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<DouguoCookbookDetailDO> selectByQuery(DouguoCookbookDetailQuery query) {
        return douguoCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<DouguoCookbookDetailDO> selectByQueryWithPage(DouguoCookbookDetailQuery query) {
        PageResult<DouguoCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public DouguoCookbookDetailDO selectByPrimaryKey(Long id) {
        return douguoCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(DouguoCookbookDetailDO record, DouguoCookbookDetailQuery query) {
        return douguoCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(DouguoCookbookDetailDO record, DouguoCookbookDetailQuery query) {
        return douguoCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(DouguoCookbookDetailDO record) {
        return douguoCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<DouguoCookbookDetailDO> records) {
        return douguoCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<DouguoCookbookDetailDO> records) {
        return douguoCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public DouguoCookbookDetailDO selectByCookbookUrl(String cookbookUrl) {
        DouguoCookbookDetailQuery query = new DouguoCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return douguoCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}