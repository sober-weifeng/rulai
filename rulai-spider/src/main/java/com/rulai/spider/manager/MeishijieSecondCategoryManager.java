package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.MeishijieSecondCategoryDO;
import com.rulai.spider.bean.query.MeishijieSecondCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.MeishijieSecondCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishijieSecondCategory.
 */
@Component
public class MeishijieSecondCategoryManager {

    @Autowired
    private MeishijieSecondCategoryExtMapper meishijieSecondCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishijieSecondCategoryQuery query){
        return meishijieSecondCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishijieSecondCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishijieSecondCategoryQuery query) {
        return meishijieSecondCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishijieSecondCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishijieSecondCategoryDO record) {
        return meishijieSecondCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishijieSecondCategoryDO> records) {
        return meishijieSecondCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishijieSecondCategoryDO> selectByQuery(MeishijieSecondCategoryQuery query) {
        return meishijieSecondCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishijieSecondCategoryDO> selectByQueryWithPage(MeishijieSecondCategoryQuery query) {
        PageResult<MeishijieSecondCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishijieSecondCategoryDO selectByPrimaryKey(Long id) {
        return meishijieSecondCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( MeishijieSecondCategoryDO record, MeishijieSecondCategoryQuery query) {
        return meishijieSecondCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishijieSecondCategoryDO record, MeishijieSecondCategoryQuery query) {
        return meishijieSecondCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishijieSecondCategoryDO record) {
        return meishijieSecondCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishijieSecondCategoryDO> records) {
        return meishijieSecondCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishijieSecondCategoryDO> records) {
        return meishijieSecondCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public MeishijieSecondCategoryDO selectByCategoryUrl(String categoryUrl) {
        MeishijieSecondCategoryQuery query = new MeishijieSecondCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return meishijieSecondCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public List<MeishijieSecondCategoryDO> selectNotCrawled() {
        MeishijieSecondCategoryQuery query = new MeishijieSecondCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return meishijieSecondCategoryMapper.selectByQuery(query);
    }
    
}