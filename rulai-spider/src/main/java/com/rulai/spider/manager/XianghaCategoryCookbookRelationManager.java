package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.XianghaCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.XianghaCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.XianghaCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XianghaCategoryCookbookRelation.
 */
@Component
public class XianghaCategoryCookbookRelationManager {

    @Autowired
    private XianghaCategoryCookbookRelationExtMapper xianghaCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XianghaCategoryCookbookRelationQuery query){
        return xianghaCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xianghaCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XianghaCategoryCookbookRelationQuery query) {
        return xianghaCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xianghaCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XianghaCategoryCookbookRelationDO record) {
        return xianghaCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XianghaCategoryCookbookRelationDO> records) {
        return xianghaCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XianghaCategoryCookbookRelationDO> selectByQuery(XianghaCategoryCookbookRelationQuery query) {
        return xianghaCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XianghaCategoryCookbookRelationDO> selectByQueryWithPage(XianghaCategoryCookbookRelationQuery query) {
        PageResult<XianghaCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XianghaCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return xianghaCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XianghaCategoryCookbookRelationDO record, XianghaCategoryCookbookRelationQuery query) {
        return xianghaCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XianghaCategoryCookbookRelationDO record, XianghaCategoryCookbookRelationQuery query) {
        return xianghaCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XianghaCategoryCookbookRelationDO record) {
        return xianghaCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XianghaCategoryCookbookRelationDO> records) {
        return xianghaCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XianghaCategoryCookbookRelationDO> records) {
        return xianghaCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XianghaCategoryCookbookRelationDO selectByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        XianghaCategoryCookbookRelationQuery query = new XianghaCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return xianghaCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}