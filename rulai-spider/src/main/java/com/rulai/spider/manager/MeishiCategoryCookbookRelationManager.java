package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.MeishiCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.MeishiCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.MeishiCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishiCategoryCookbookRelation.
 */
@Component
public class MeishiCategoryCookbookRelationManager {

    @Autowired
    private MeishiCategoryCookbookRelationExtMapper meishiCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishiCategoryCookbookRelationQuery query){
        return meishiCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishiCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishiCategoryCookbookRelationQuery query) {
        return meishiCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishiCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishiCategoryCookbookRelationDO record) {
        return meishiCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishiCategoryCookbookRelationDO> records) {
        return meishiCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishiCategoryCookbookRelationDO> selectByQuery(MeishiCategoryCookbookRelationQuery query) {
        return meishiCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishiCategoryCookbookRelationDO> selectByQueryWithPage(MeishiCategoryCookbookRelationQuery query) {
        PageResult<MeishiCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishiCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return meishiCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(MeishiCategoryCookbookRelationDO record, MeishiCategoryCookbookRelationQuery query) {
        return meishiCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishiCategoryCookbookRelationDO record, MeishiCategoryCookbookRelationQuery query) {
        return meishiCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishiCategoryCookbookRelationDO record) {
        return meishiCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishiCategoryCookbookRelationDO> records) {
        return meishiCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishiCategoryCookbookRelationDO> records) {
        return meishiCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public MeishiCategoryCookbookRelationDO selectByCookbookUrlIdAndCategoryId(Long cookbookUrlId, Long categoryId) {
        MeishiCategoryCookbookRelationQuery query = new MeishiCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andCategoryIdEqualTo(categoryId);
        return meishiCategoryCookbookRelationMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}