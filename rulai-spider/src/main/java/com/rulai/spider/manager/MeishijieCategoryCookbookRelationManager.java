package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.MeishijieCategoryCookbookRelationDO;
import com.rulai.spider.bean.query.MeishijieCategoryCookbookRelationQuery;
import com.rulai.spider.mapper.ext.MeishijieCategoryCookbookRelationExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishijieCategoryCookbookRelation.
 */
@Component
public class MeishijieCategoryCookbookRelationManager {

    @Autowired
    private MeishijieCategoryCookbookRelationExtMapper meishijieCategoryCookbookRelationMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishijieCategoryCookbookRelationQuery query){
        return meishijieCategoryCookbookRelationMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishijieCategoryCookbookRelationMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishijieCategoryCookbookRelationQuery query) {
        return meishijieCategoryCookbookRelationMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishijieCategoryCookbookRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishijieCategoryCookbookRelationDO record) {
        return meishijieCategoryCookbookRelationMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishijieCategoryCookbookRelationDO> records) {
        return meishijieCategoryCookbookRelationMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishijieCategoryCookbookRelationDO> selectByQuery(MeishijieCategoryCookbookRelationQuery query) {
        return meishijieCategoryCookbookRelationMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishijieCategoryCookbookRelationDO> selectByQueryWithPage(MeishijieCategoryCookbookRelationQuery query) {
        PageResult<MeishijieCategoryCookbookRelationDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishijieCategoryCookbookRelationDO selectByPrimaryKey(Long id) {
        return meishijieCategoryCookbookRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( MeishijieCategoryCookbookRelationDO record, MeishijieCategoryCookbookRelationQuery query) {
        return meishijieCategoryCookbookRelationMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishijieCategoryCookbookRelationDO record, MeishijieCategoryCookbookRelationQuery query) {
        return meishijieCategoryCookbookRelationMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishijieCategoryCookbookRelationDO record) {
        return meishijieCategoryCookbookRelationMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishijieCategoryCookbookRelationDO> records) {
        return meishijieCategoryCookbookRelationMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishijieCategoryCookbookRelationDO> records) {
        return meishijieCategoryCookbookRelationMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public int countByCookbookUrlIdAndSecondCategoryId(Long cookbookUrlId, Long secondCategoryId) {
        MeishijieCategoryCookbookRelationQuery query = new MeishijieCategoryCookbookRelationQuery();
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId).andSecondCategoryIdEqualTo(secondCategoryId);
        return meishijieCategoryCookbookRelationMapper.countByQuery(query);
    }
    
}