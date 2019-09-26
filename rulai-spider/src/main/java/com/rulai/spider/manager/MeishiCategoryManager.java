package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.MeishiCategoryDO;
import com.rulai.spider.bean.query.MeishiCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.MeishiCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishiCategory.
 */
@Component
public class MeishiCategoryManager {

    @Autowired
    private MeishiCategoryExtMapper meishiCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishiCategoryQuery query){
        return meishiCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishiCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishiCategoryQuery query) {
        return meishiCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishiCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishiCategoryDO record) {
        return meishiCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishiCategoryDO> records) {
        return meishiCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishiCategoryDO> selectByQuery(MeishiCategoryQuery query) {
        return meishiCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishiCategoryDO> selectByQueryWithPage(MeishiCategoryQuery query) {
        PageResult<MeishiCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishiCategoryDO selectByPrimaryKey(Long id) {
        return meishiCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(MeishiCategoryDO record, MeishiCategoryQuery query) {
        return meishiCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishiCategoryDO record, MeishiCategoryQuery query) {
        return meishiCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishiCategoryDO record) {
        return meishiCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishiCategoryDO> records) {
        return meishiCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishiCategoryDO> records) {
        return meishiCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public MeishiCategoryDO selectByCategoryUrl(String categoryUrl) {
        MeishiCategoryQuery query = new MeishiCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return meishiCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return meishiCategoryMapper.selectNoCrawledMinMaxId();
    }

    public List<MeishiCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        MeishiCategoryQuery query = new MeishiCategoryQuery();
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return meishiCategoryMapper.selectByQuery(query);
    }
    
}