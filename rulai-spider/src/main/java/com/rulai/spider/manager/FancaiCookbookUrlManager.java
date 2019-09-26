package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.FancaiCookbookUrlDO;
import com.rulai.spider.bean.query.FancaiCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.FancaiCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FancaiCookbookUrl.
 */
@Component
public class FancaiCookbookUrlManager {

    @Autowired
    private FancaiCookbookUrlExtMapper fancaiCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(FancaiCookbookUrlQuery query){
        return fancaiCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return fancaiCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(FancaiCookbookUrlQuery query) {
        return fancaiCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return fancaiCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(FancaiCookbookUrlDO record) {
        return fancaiCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<FancaiCookbookUrlDO> records) {
        return fancaiCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<FancaiCookbookUrlDO> selectByQuery(FancaiCookbookUrlQuery query) {
        return fancaiCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<FancaiCookbookUrlDO> selectByQueryWithPage(FancaiCookbookUrlQuery query) {
        PageResult<FancaiCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public FancaiCookbookUrlDO selectByPrimaryKey(Long id) {
        return fancaiCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(FancaiCookbookUrlDO record, FancaiCookbookUrlQuery query) {
        return fancaiCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(FancaiCookbookUrlDO record, FancaiCookbookUrlQuery query) {
        return fancaiCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(FancaiCookbookUrlDO record) {
        return fancaiCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<FancaiCookbookUrlDO> records) {
        return fancaiCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<FancaiCookbookUrlDO> records) {
        return fancaiCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public FancaiCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        FancaiCookbookUrlQuery query = new FancaiCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return fancaiCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<FancaiCookbookUrlDO> selectNotCrawled() {
        FancaiCookbookUrlQuery query = new FancaiCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return fancaiCookbookUrlMapper.selectByQuery(query);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return fancaiCookbookUrlMapper.selectNoCrawledMinMaxId();
    }

    public List<FancaiCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        FancaiCookbookUrlQuery query = new FancaiCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(batchSize);
//        query.setPageNo(1);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return fancaiCookbookUrlMapper.selectByQuery(query);
    }
    
}