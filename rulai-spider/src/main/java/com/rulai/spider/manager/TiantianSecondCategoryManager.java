package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.TiantianSecondCategoryDO;
import com.rulai.spider.bean.query.TiantianSecondCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.TiantianSecondCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TiantianSecondCategory.
 */
@Component
public class TiantianSecondCategoryManager {

    @Autowired
    private TiantianSecondCategoryExtMapper tiantianSecondCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(TiantianSecondCategoryQuery query){
        return tiantianSecondCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return tiantianSecondCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(TiantianSecondCategoryQuery query) {
        return tiantianSecondCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return tiantianSecondCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(TiantianSecondCategoryDO record) {
        return tiantianSecondCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<TiantianSecondCategoryDO> records) {
        return tiantianSecondCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<TiantianSecondCategoryDO> selectByQuery(TiantianSecondCategoryQuery query) {
        return tiantianSecondCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<TiantianSecondCategoryDO> selectByQueryWithPage(TiantianSecondCategoryQuery query) {
        PageResult<TiantianSecondCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public TiantianSecondCategoryDO selectByPrimaryKey(Long id) {
        return tiantianSecondCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(TiantianSecondCategoryDO record, TiantianSecondCategoryQuery query) {
        return tiantianSecondCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(TiantianSecondCategoryDO record, TiantianSecondCategoryQuery query) {
        return tiantianSecondCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(TiantianSecondCategoryDO record) {
        return tiantianSecondCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<TiantianSecondCategoryDO> records) {
        return tiantianSecondCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<TiantianSecondCategoryDO> records) {
        return tiantianSecondCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public TiantianSecondCategoryDO selectByCategoryUrl(String categoryUrl, Long topCategoryId) {
        TiantianSecondCategoryQuery query = new TiantianSecondCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl).andTopCategoryIdEqualTo(topCategoryId);
        return tiantianSecondCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return tiantianSecondCategoryMapper.selectNoCrawledMinMaxId();
    }

    public List<TiantianSecondCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        TiantianSecondCategoryQuery query = new TiantianSecondCategoryQuery();
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .addCondition(splitterClause);
        return tiantianSecondCategoryMapper.selectByQuery(query);
    }
    
}