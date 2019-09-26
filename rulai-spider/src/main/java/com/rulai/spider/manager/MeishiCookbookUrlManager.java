package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.MeishiCookbookUrlDO;
import com.rulai.spider.bean.query.MeishiCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.MeishiCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishiCookbookUrl.
 */
@Component
public class MeishiCookbookUrlManager {

    @Autowired
    private MeishiCookbookUrlExtMapper meishiCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishiCookbookUrlQuery query){
        return meishiCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishiCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishiCookbookUrlQuery query) {
        return meishiCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishiCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishiCookbookUrlDO record) {
        return meishiCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishiCookbookUrlDO> records) {
        return meishiCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishiCookbookUrlDO> selectByQuery(MeishiCookbookUrlQuery query) {
        return meishiCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishiCookbookUrlDO> selectByQueryWithPage(MeishiCookbookUrlQuery query) {
        PageResult<MeishiCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishiCookbookUrlDO selectByPrimaryKey(Long id) {
        return meishiCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(MeishiCookbookUrlDO record, MeishiCookbookUrlQuery query) {
        return meishiCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishiCookbookUrlDO record, MeishiCookbookUrlQuery query) {
        return meishiCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishiCookbookUrlDO record) {
        return meishiCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishiCookbookUrlDO> records) {
        return meishiCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishiCookbookUrlDO> records) {
        return meishiCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public MeishiCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        MeishiCookbookUrlQuery query = new MeishiCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return meishiCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<MeishiCookbookUrlDO> selectNotCrawled() {
        MeishiCookbookUrlQuery query = new MeishiCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return meishiCookbookUrlMapper.selectByQuery(query);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return meishiCookbookUrlMapper.selectNoCrawledMinMaxId();
    }

    public List<MeishiCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        MeishiCookbookUrlQuery query = new MeishiCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(batchSize);
//        query.setPageNo(1);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return meishiCookbookUrlMapper.selectByQuery(query);
    }
    
}