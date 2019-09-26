package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.XinshipuCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.XinshipuCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.XinshipuCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XinshipuCategoryCookbookRelation.
 */
@Component
public class XinshipuCategoryCookbookRelationManager {

    @Autowired
    private XinshipuCategoryCookbookRelationExtMapper xinshipuCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XinshipuCategoryCookbookRelationQuery query){
        return xinshipuCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xinshipuCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XinshipuCategoryCookbookRelationQuery query) {
        return xinshipuCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xinshipuCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XinshipuCategoryCookbookRelationDO record) {
        return xinshipuCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XinshipuCategoryCookbookRelationDO> records) {
        return xinshipuCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XinshipuCategoryCookbookRelationDO> selectByQuery(XinshipuCategoryCookbookRelationQuery query) {
        return xinshipuCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XinshipuCategoryCookbookRelationDO> selectByQueryWithPage(XinshipuCategoryCookbookRelationQuery query) {
        PageResult<XinshipuCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XinshipuCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return xinshipuCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( XinshipuCategoryCookbookRelationDO record, XinshipuCategoryCookbookRelationQuery query) {
        return xinshipuCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XinshipuCategoryCookbookRelationDO record, XinshipuCategoryCookbookRelationQuery query) {
        return xinshipuCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XinshipuCategoryCookbookRelationDO record) {
        return xinshipuCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XinshipuCategoryCookbookRelationDO> records) {
        return xinshipuCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XinshipuCategoryCookbookRelationDO> records) {
        return xinshipuCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public int countByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        XinshipuCategoryCookbookRelationQuery query = new XinshipuCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return xinshipuCategoryCookbookRelationMapper.countByQuery(query);
    }

    public XinshipuCategoryCookbookRelationDO selectByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        XinshipuCategoryCookbookRelationQuery query = new XinshipuCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return xinshipuCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}