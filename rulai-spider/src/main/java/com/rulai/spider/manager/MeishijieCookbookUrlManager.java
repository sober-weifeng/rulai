package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.crawl.meishijie.CookbookDetailPage;
import com.rulai.spider.bean.model.MeishijieCookbookUrlDO;
import com.rulai.spider.bean.query.MeishijieCookbookUrlQuery;
import com.rulai.spider.enums.CrawlTypeEnum;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.MeishijieCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishijieCookbookUrl.
 */
@Component
public class MeishijieCookbookUrlManager {

    @Autowired
    private MeishijieCookbookUrlExtMapper meishijieCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishijieCookbookUrlQuery query){
        return meishijieCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishijieCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishijieCookbookUrlQuery query) {
        return meishijieCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishijieCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishijieCookbookUrlDO record) {
        return meishijieCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishijieCookbookUrlDO> records) {
        return meishijieCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishijieCookbookUrlDO> selectByQuery(MeishijieCookbookUrlQuery query) {
        return meishijieCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishijieCookbookUrlDO> selectByQueryWithPage(MeishijieCookbookUrlQuery query) {
        PageResult<MeishijieCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishijieCookbookUrlDO selectByPrimaryKey(Long id) {
        return meishijieCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( MeishijieCookbookUrlDO record, MeishijieCookbookUrlQuery query) {
        return meishijieCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishijieCookbookUrlDO record, MeishijieCookbookUrlQuery query) {
        return meishijieCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishijieCookbookUrlDO record) {
        return meishijieCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishijieCookbookUrlDO> records) {
        return meishijieCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishijieCookbookUrlDO> records) {
        return meishijieCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public MeishijieCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        MeishijieCookbookUrlQuery query = new MeishijieCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return meishijieCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<MeishijieCookbookUrlDO> selectNotCrawled() {
        MeishijieCookbookUrlQuery query = new MeishijieCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .andCrawlTypeEqualTo(CrawlTypeEnum.ORIGIN.getCode())
                .andCookbookUrlLike(CookbookDetailPage.HTTP_PREFIX.concat("%"));
        return meishijieCookbookUrlMapper.selectByQuery(query);
    }
    
}