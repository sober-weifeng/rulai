package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.crawl.chinacaipu.OriginalCookbookDetailPage;
import com.rulai.spider.bean.crawl.chinacaipu.OtherCookbookDetailPage;
import com.rulai.spider.bean.model.ChinacaipuCookbookUrlDO;
import com.rulai.spider.bean.query.ChinacaipuCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.ChinacaipuCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ChinacaipuCookbookUrl.
 */
@Component
public class ChinacaipuCookbookUrlManager {

    @Autowired
    private ChinacaipuCookbookUrlExtMapper chinacaipuCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ChinacaipuCookbookUrlQuery query){
        return chinacaipuCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return chinacaipuCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ChinacaipuCookbookUrlQuery query) {
        return chinacaipuCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return chinacaipuCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ChinacaipuCookbookUrlDO record) {
        return chinacaipuCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ChinacaipuCookbookUrlDO> records) {
        return chinacaipuCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ChinacaipuCookbookUrlDO> selectByQuery(ChinacaipuCookbookUrlQuery query) {
        return chinacaipuCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ChinacaipuCookbookUrlDO> selectByQueryWithPage(ChinacaipuCookbookUrlQuery query) {
        PageResult<ChinacaipuCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ChinacaipuCookbookUrlDO selectByPrimaryKey(Long id) {
        return chinacaipuCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( ChinacaipuCookbookUrlDO record, ChinacaipuCookbookUrlQuery query) {
        return chinacaipuCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ChinacaipuCookbookUrlDO record, ChinacaipuCookbookUrlQuery query) {
        return chinacaipuCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ChinacaipuCookbookUrlDO record) {
        return chinacaipuCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ChinacaipuCookbookUrlDO> records) {
        return chinacaipuCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ChinacaipuCookbookUrlDO> records) {
        return chinacaipuCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public ChinacaipuCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        ChinacaipuCookbookUrlQuery query = new ChinacaipuCookbookUrlQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return chinacaipuCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
    public List<ChinacaipuCookbookUrlDO> selectOriginalNotCrawled() {
        ChinacaipuCookbookUrlQuery query = new ChinacaipuCookbookUrlQuery();
        query.createCriteria().andCookbookUrlLike(OriginalCookbookDetailPage.PREFIX.concat("%"))
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return chinacaipuCookbookUrlMapper.selectByQuery(query);
    }

    public List<ChinacaipuCookbookUrlDO> selectOtherNotCrawled() {
        ChinacaipuCookbookUrlQuery query = new ChinacaipuCookbookUrlQuery();
        query.createCriteria().andCookbookUrlLike(OtherCookbookDetailPage.PREFIX.concat("%"))
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return chinacaipuCookbookUrlMapper.selectByQuery(query);
    }
    
}