package com.rulai.spider.manager;

import com.rulai.spider.bean.model.MeishijieTopCategoryDO;
import com.rulai.spider.bean.query.MeishijieTopCategoryQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.MeishijieTopCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishijieTopCategory.
 */
@Component
public class MeishijieTopCategoryManager {

    @Autowired
    private MeishijieTopCategoryExtMapper meishijieTopCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishijieTopCategoryQuery query){
        return meishijieTopCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishijieTopCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishijieTopCategoryQuery query) {
        return meishijieTopCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishijieTopCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishijieTopCategoryDO record) {
        return meishijieTopCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishijieTopCategoryDO> records) {
        return meishijieTopCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishijieTopCategoryDO> selectByQuery(MeishijieTopCategoryQuery query) {
        return meishijieTopCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishijieTopCategoryDO> selectByQueryWithPage(MeishijieTopCategoryQuery query) {
        PageResult<MeishijieTopCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishijieTopCategoryDO selectByPrimaryKey(Long id) {
        return meishijieTopCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( MeishijieTopCategoryDO record, MeishijieTopCategoryQuery query) {
        return meishijieTopCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishijieTopCategoryDO record, MeishijieTopCategoryQuery query) {
        return meishijieTopCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishijieTopCategoryDO record) {
        return meishijieTopCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishijieTopCategoryDO> records) {
        return meishijieTopCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishijieTopCategoryDO> records) {
        return meishijieTopCategoryMapper.batchUpdateByPrimaryKey(records);
    }
    
    public MeishijieTopCategoryDO selectByCategoryUrl(String categoryUrl) {
        MeishijieTopCategoryQuery query = new MeishijieTopCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return meishijieTopCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
    public List<MeishijieTopCategoryDO> selectNotCrawled() {
        MeishijieTopCategoryQuery query = new MeishijieTopCategoryQuery();
        query.createCriteria().andIsCrawledEqualTo(IsCrawledEnum.NO.getCode());
        return meishijieTopCategoryMapper.selectByQuery(query);
    }
    
}