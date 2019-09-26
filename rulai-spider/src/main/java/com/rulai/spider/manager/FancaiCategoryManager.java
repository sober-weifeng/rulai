package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.FancaiCategoryDO;
import com.rulai.spider.bean.query.FancaiCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.FancaiCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FancaiCategory.
 */
@Component
public class FancaiCategoryManager {

    @Autowired
    private FancaiCategoryExtMapper fancaiCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(FancaiCategoryQuery query){
        return fancaiCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return fancaiCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(FancaiCategoryQuery query) {
        return fancaiCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return fancaiCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(FancaiCategoryDO record) {
        return fancaiCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<FancaiCategoryDO> records) {
        return fancaiCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<FancaiCategoryDO> selectByQuery(FancaiCategoryQuery query) {
        return fancaiCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<FancaiCategoryDO> selectByQueryWithPage(FancaiCategoryQuery query) {
        PageResult<FancaiCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public FancaiCategoryDO selectByPrimaryKey(Long id) {
        return fancaiCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(FancaiCategoryDO record, FancaiCategoryQuery query) {
        return fancaiCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(FancaiCategoryDO record, FancaiCategoryQuery query) {
        return fancaiCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(FancaiCategoryDO record) {
        return fancaiCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<FancaiCategoryDO> records) {
        return fancaiCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<FancaiCategoryDO> records) {
        return fancaiCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public FancaiCategoryDO selectByCategoryUrl(String categoryUrl) {
        FancaiCategoryQuery query = new FancaiCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return fancaiCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return fancaiCategoryMapper.selectNoCrawledMinMaxId();
    }

    public List<FancaiCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        FancaiCategoryQuery query = new FancaiCategoryQuery();
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return fancaiCategoryMapper.selectByQuery(query);
    }
    
}