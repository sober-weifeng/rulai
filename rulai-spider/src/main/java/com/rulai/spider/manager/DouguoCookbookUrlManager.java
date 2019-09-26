package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.DouguoCookbookUrlDO;
import com.rulai.spider.bean.query.DouguoCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.DouguoCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for DouguoCookbookUrl.
 */
@Component
public class DouguoCookbookUrlManager {

    @Autowired
    private DouguoCookbookUrlExtMapper douguoCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(DouguoCookbookUrlQuery query){
        return douguoCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return douguoCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(DouguoCookbookUrlQuery query) {
        return douguoCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return douguoCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(DouguoCookbookUrlDO record) {
        return douguoCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<DouguoCookbookUrlDO> records) {
        return douguoCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<DouguoCookbookUrlDO> selectByQuery(DouguoCookbookUrlQuery query) {
        return douguoCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<DouguoCookbookUrlDO> selectByQueryWithPage(DouguoCookbookUrlQuery query) {
        PageResult<DouguoCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public DouguoCookbookUrlDO selectByPrimaryKey(Long id) {
        return douguoCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(DouguoCookbookUrlDO record, DouguoCookbookUrlQuery query) {
        return douguoCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(DouguoCookbookUrlDO record, DouguoCookbookUrlQuery query) {
        return douguoCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(DouguoCookbookUrlDO record) {
        return douguoCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<DouguoCookbookUrlDO> records) {
        return douguoCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<DouguoCookbookUrlDO> records) {
        return douguoCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public DouguoCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        DouguoCookbookUrlQuery query = new DouguoCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return douguoCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<DouguoCookbookUrlDO> selectNotCrawled() {
        DouguoCookbookUrlQuery query = new DouguoCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return douguoCookbookUrlMapper.selectByQuery(query);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return douguoCookbookUrlMapper.selectNoCrawledMinMaxId();
    }

    public List<DouguoCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        DouguoCookbookUrlQuery query = new DouguoCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return douguoCookbookUrlMapper.selectByQuery(query);
    }
    
}