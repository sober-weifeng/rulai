package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.xinshipu.CategoryNoCrawledMinMaxIdDTO;
import com.rulai.spider.bean.model.XinshipuCategoryDO;
import com.rulai.spider.bean.query.XinshipuCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.XinshipuCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XinshipuCategory.
 */
@Component
public class XinshipuCategoryManager {

    @Autowired
    private XinshipuCategoryExtMapper xinshipuCategoryMapper;

    /**
     * query count by query condition.
     */
    public int countByQuery(XinshipuCategoryQuery query) {
        return xinshipuCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xinshipuCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XinshipuCategoryQuery query) {
        return xinshipuCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xinshipuCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XinshipuCategoryDO record) {
        return xinshipuCategoryMapper.insertSelective(record);
    }

    /**
     * insert selective.
     */
    public int batchInsert(List<XinshipuCategoryDO> records) {
        return xinshipuCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XinshipuCategoryDO> selectByQuery(XinshipuCategoryQuery query) {
        return xinshipuCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
     */
    public PageResult<XinshipuCategoryDO> selectByQueryWithPage(XinshipuCategoryQuery query) {
        PageResult<XinshipuCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XinshipuCategoryDO selectByPrimaryKey(Long id) {
        return xinshipuCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XinshipuCategoryDO record, XinshipuCategoryQuery query) {
        return xinshipuCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XinshipuCategoryDO record, XinshipuCategoryQuery query) {
        return xinshipuCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XinshipuCategoryDO record) {
        return xinshipuCategoryMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XinshipuCategoryDO> records) {
        return xinshipuCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XinshipuCategoryDO> records) {
        return xinshipuCategoryMapper.batchUpdateByPrimaryKey(records);
    }

    public XinshipuCategoryDO selectByCategoryUrl(String categoryUrl) {
        XinshipuCategoryQuery query = new XinshipuCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return xinshipuCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<XinshipuCategoryDO> selectNotCrawled() {
        XinshipuCategoryQuery query = new XinshipuCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return xinshipuCategoryMapper.selectByQuery(query);
    }

    public List<XinshipuCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        XinshipuCategoryQuery query = new XinshipuCategoryQuery();
        query.setPageSize(5);
        query.setPageOffset(0);
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode()).addCondition(splitterClause);
        return xinshipuCategoryMapper.selectByQuery(query);
    }
    
    public CategoryNoCrawledMinMaxIdDTO selectCategoryNoCrawledMinMaxId() {
        return xinshipuCategoryMapper.selectCategoryNoCrawledMinMaxId();
    }

}