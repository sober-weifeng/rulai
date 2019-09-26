package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.TiantianCookbookUrlDO;
import com.rulai.spider.bean.query.TiantianCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.TiantianCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TiantianCookbookUrl.
 */
@Component
public class TiantianCookbookUrlManager {

    @Autowired
    private TiantianCookbookUrlExtMapper tiantianCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TiantianCookbookUrlQuery query){
        return tiantianCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return tiantianCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TiantianCookbookUrlQuery query) {
        return tiantianCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return tiantianCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TiantianCookbookUrlDO record) {
        return tiantianCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TiantianCookbookUrlDO> records) {
        return tiantianCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TiantianCookbookUrlDO> selectByQuery(TiantianCookbookUrlQuery query) {
        return tiantianCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TiantianCookbookUrlDO> selectByQueryWithPage(TiantianCookbookUrlQuery query) {
        PageResult<TiantianCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TiantianCookbookUrlDO selectByPrimaryKey(Long id) {
        return tiantianCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(TiantianCookbookUrlDO record, TiantianCookbookUrlQuery query) {
        return tiantianCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TiantianCookbookUrlDO record, TiantianCookbookUrlQuery query) {
        return tiantianCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TiantianCookbookUrlDO record) {
        return tiantianCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TiantianCookbookUrlDO> records) {
        return tiantianCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TiantianCookbookUrlDO> records) {
        return tiantianCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public TiantianCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        TiantianCookbookUrlQuery query = new TiantianCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return tiantianCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<TiantianCookbookUrlDO> selectNotCrawled() {
        TiantianCookbookUrlQuery query = new TiantianCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return tiantianCookbookUrlMapper.selectByQuery(query);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return tiantianCookbookUrlMapper.selectNoCrawledMinMaxId();
    }

    public List<TiantianCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        TiantianCookbookUrlQuery query = new TiantianCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(batchSize);
//        query.setPageNo(1);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return tiantianCookbookUrlMapper.selectByQuery(query);
    }
    
}