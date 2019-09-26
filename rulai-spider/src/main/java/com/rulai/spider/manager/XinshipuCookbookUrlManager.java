package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.xinshipu.CookbookUrlNoCrawledMinMaxIdDTO;
import com.rulai.spider.bean.model.XinshipuCookbookUrlDO;
import com.rulai.spider.bean.query.XinshipuCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.XinshipuCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XinshipuCookbookUrl.
 */
@Component
public class XinshipuCookbookUrlManager {

    @Autowired
    private XinshipuCookbookUrlExtMapper xinshipuCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XinshipuCookbookUrlQuery query){
        return xinshipuCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xinshipuCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XinshipuCookbookUrlQuery query) {
        return xinshipuCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xinshipuCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XinshipuCookbookUrlDO record) {
        return xinshipuCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XinshipuCookbookUrlDO> records) {
        return xinshipuCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XinshipuCookbookUrlDO> selectByQuery(XinshipuCookbookUrlQuery query) {
        return xinshipuCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XinshipuCookbookUrlDO> selectByQueryWithPage(XinshipuCookbookUrlQuery query) {
        PageResult<XinshipuCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XinshipuCookbookUrlDO selectByPrimaryKey(Long id) {
        return xinshipuCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( XinshipuCookbookUrlDO record, XinshipuCookbookUrlQuery query) {
        return xinshipuCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XinshipuCookbookUrlDO record, XinshipuCookbookUrlQuery query) {
        return xinshipuCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XinshipuCookbookUrlDO record) {
        return xinshipuCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XinshipuCookbookUrlDO> records) {
        return xinshipuCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XinshipuCookbookUrlDO> records) {
        return xinshipuCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XinshipuCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        XinshipuCookbookUrlQuery query = new XinshipuCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return xinshipuCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<XinshipuCookbookUrlDO> selectNotCrawled() {
        XinshipuCookbookUrlQuery query = new XinshipuCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return xinshipuCookbookUrlMapper.selectByQuery(query);
    }
    
    public CookbookUrlNoCrawledMinMaxIdDTO selectCookbookUrlNoCrawledMinMaxId() {
        return xinshipuCookbookUrlMapper.selectCookbookUrlNoCrawledMinMaxId();
    }

    public List<XinshipuCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        XinshipuCookbookUrlQuery query = new XinshipuCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return xinshipuCookbookUrlMapper.selectByQuery(query);
    }
    
}