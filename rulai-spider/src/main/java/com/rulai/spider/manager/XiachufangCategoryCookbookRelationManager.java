package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.XiachufangCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.XiachufangCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.XiachufangCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XiachufangCategoryCookbookRelation.
 */
@Component
public class XiachufangCategoryCookbookRelationManager {

    @Autowired
    private XiachufangCategoryCookbookRelationExtMapper xiachufangCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XiachufangCategoryCookbookRelationQuery query){
        return xiachufangCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xiachufangCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XiachufangCategoryCookbookRelationQuery query) {
        return xiachufangCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xiachufangCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XiachufangCategoryCookbookRelationDO record) {
        return xiachufangCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XiachufangCategoryCookbookRelationDO> records) {
        return xiachufangCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XiachufangCategoryCookbookRelationDO> selectByQuery(XiachufangCategoryCookbookRelationQuery query) {
        return xiachufangCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XiachufangCategoryCookbookRelationDO> selectByQueryWithPage(XiachufangCategoryCookbookRelationQuery query) {
        PageResult<XiachufangCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XiachufangCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return xiachufangCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XiachufangCategoryCookbookRelationDO record, XiachufangCategoryCookbookRelationQuery query) {
        return xiachufangCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XiachufangCategoryCookbookRelationDO record, XiachufangCategoryCookbookRelationQuery query) {
        return xiachufangCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XiachufangCategoryCookbookRelationDO record) {
        return xiachufangCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XiachufangCategoryCookbookRelationDO> records) {
        return xiachufangCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XiachufangCategoryCookbookRelationDO> records) {
        return xiachufangCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XiachufangCategoryCookbookRelationDO selectByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        XiachufangCategoryCookbookRelationQuery query = new XiachufangCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return xiachufangCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}