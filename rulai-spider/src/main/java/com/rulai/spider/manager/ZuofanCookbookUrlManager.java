package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.ZuofanCookbookUrlDO;
import com.rulai.spider.bean.query.ZuofanCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.ZuofanCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ZuofanCookbookUrl.
 */
@Component
public class ZuofanCookbookUrlManager {

    @Autowired
    private ZuofanCookbookUrlExtMapper zuofanCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ZuofanCookbookUrlQuery query){
        return zuofanCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return zuofanCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ZuofanCookbookUrlQuery query) {
        return zuofanCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return zuofanCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ZuofanCookbookUrlDO record) {
        return zuofanCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ZuofanCookbookUrlDO> records) {
        return zuofanCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ZuofanCookbookUrlDO> selectByQuery(ZuofanCookbookUrlQuery query) {
        return zuofanCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ZuofanCookbookUrlDO> selectByQueryWithPage(ZuofanCookbookUrlQuery query) {
        PageResult<ZuofanCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ZuofanCookbookUrlDO selectByPrimaryKey(Long id) {
        return zuofanCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(ZuofanCookbookUrlDO record, ZuofanCookbookUrlQuery query) {
        return zuofanCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ZuofanCookbookUrlDO record, ZuofanCookbookUrlQuery query) {
        return zuofanCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ZuofanCookbookUrlDO record) {
        return zuofanCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ZuofanCookbookUrlDO> records) {
        return zuofanCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ZuofanCookbookUrlDO> records) {
        return zuofanCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public ZuofanCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        ZuofanCookbookUrlQuery query = new ZuofanCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return zuofanCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<ZuofanCookbookUrlDO> selectNotCrawled() {
        ZuofanCookbookUrlQuery query = new ZuofanCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return zuofanCookbookUrlMapper.selectByQuery(query);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return zuofanCookbookUrlMapper.selectNoCrawledMinMaxId();
    }

    public List<ZuofanCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        ZuofanCookbookUrlQuery query = new ZuofanCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(batchSize);
//        query.setPageNo(1);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return zuofanCookbookUrlMapper.selectByQuery(query);
    }
    
}