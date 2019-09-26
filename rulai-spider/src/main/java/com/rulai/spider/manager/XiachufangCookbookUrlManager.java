package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.XiachufangCookbookUrlDO;
import com.rulai.spider.bean.query.XiachufangCookbookUrlQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.XiachufangCookbookUrlExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XiachufangCookbookUrl.
 */
@Component
public class XiachufangCookbookUrlManager {

    @Autowired
    private XiachufangCookbookUrlExtMapper xiachufangCookbookUrlMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XiachufangCookbookUrlQuery query){
        return xiachufangCookbookUrlMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xiachufangCookbookUrlMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XiachufangCookbookUrlQuery query) {
        return xiachufangCookbookUrlMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xiachufangCookbookUrlMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XiachufangCookbookUrlDO record) {
        return xiachufangCookbookUrlMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XiachufangCookbookUrlDO> records) {
        return xiachufangCookbookUrlMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XiachufangCookbookUrlDO> selectByQuery(XiachufangCookbookUrlQuery query) {
        return xiachufangCookbookUrlMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XiachufangCookbookUrlDO> selectByQueryWithPage(XiachufangCookbookUrlQuery query) {
        PageResult<XiachufangCookbookUrlDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XiachufangCookbookUrlDO selectByPrimaryKey(Long id) {
        return xiachufangCookbookUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XiachufangCookbookUrlDO record, XiachufangCookbookUrlQuery query) {
        return xiachufangCookbookUrlMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XiachufangCookbookUrlDO record, XiachufangCookbookUrlQuery query) {
        return xiachufangCookbookUrlMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XiachufangCookbookUrlDO record) {
        return xiachufangCookbookUrlMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XiachufangCookbookUrlDO> records) {
        return xiachufangCookbookUrlMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XiachufangCookbookUrlDO> records) {
        return xiachufangCookbookUrlMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XiachufangCookbookUrlDO selectByCookbookUrl(String cookbookUrl) {
        XiachufangCookbookUrlQuery query = new XiachufangCookbookUrlQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return xiachufangCookbookUrlMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<XiachufangCookbookUrlDO> selectNotCrawled() {
        XiachufangCookbookUrlQuery query = new XiachufangCookbookUrlQuery();
        query.setOrderByClause("id");
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode());
        return xiachufangCookbookUrlMapper.selectByQuery(query);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return xiachufangCookbookUrlMapper.selectNoCrawledMinMaxId();
    }

    public List<XiachufangCookbookUrlDO> selectNotCrawledWithSplitter(String splitterClause) {
        XiachufangCookbookUrlQuery query = new XiachufangCookbookUrlQuery();
        query.setOrderByClause("id");
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return xiachufangCookbookUrlMapper.selectByQuery(query);
    }
    
}