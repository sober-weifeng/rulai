package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.XianghaCookbookUrlDO;
import com.rulai.spider.bean.query.XianghaCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.XianghaCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XianghaCookbookUrl.
 */
@Component
public class XianghaCookbookUrlManager {

    @Autowired
    private XianghaCookbookUrlExtMapper xianghaCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XianghaCookbookUrlQuery query){
        return xianghaCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xianghaCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XianghaCookbookUrlQuery query) {
        return xianghaCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xianghaCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XianghaCookbookUrlDO record) {
        return xianghaCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XianghaCookbookUrlDO> records) {
        return xianghaCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XianghaCookbookUrlDO> selectByQuery(XianghaCookbookUrlQuery query) {
        return xianghaCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XianghaCookbookUrlDO> selectByQueryWithPage(XianghaCookbookUrlQuery query) {
        PageResult<XianghaCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XianghaCookbookUrlDO selectByPrimaryKey(Long id) {
        return xianghaCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XianghaCookbookUrlDO record, XianghaCookbookUrlQuery query) {
        return xianghaCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XianghaCookbookUrlDO record, XianghaCookbookUrlQuery query) {
        return xianghaCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XianghaCookbookUrlDO record) {
        return xianghaCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XianghaCookbookUrlDO> records) {
        return xianghaCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XianghaCookbookUrlDO> records) {
        return xianghaCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XianghaCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        XianghaCookbookUrlQuery query = new XianghaCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return xianghaCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<XianghaCookbookUrlDO> selectNotCrawled() {
        XianghaCookbookUrlQuery query = new XianghaCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return xianghaCookbookUrlMapper.selectByQuery(query);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return xianghaCookbookUrlMapper.selectNoCrawledMinMaxId();
    }

    public List<XianghaCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        XianghaCookbookUrlQuery query = new XianghaCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(batchSize);
//        query.setPageNo(1);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return xianghaCookbookUrlMapper.selectByQuery(query);
    }
    
}