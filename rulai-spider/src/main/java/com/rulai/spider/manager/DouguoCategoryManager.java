package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.DouguoCategoryDO;
import com.rulai.spider.bean.query.DouguoCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.DouguoCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for DouguoCategory.
 */
@Component
public class DouguoCategoryManager {

    @Autowired
    private DouguoCategoryExtMapper douguoCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(DouguoCategoryQuery query){
        return douguoCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return douguoCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(DouguoCategoryQuery query) {
        return douguoCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return douguoCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(DouguoCategoryDO record) {
        return douguoCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<DouguoCategoryDO> records) {
        return douguoCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<DouguoCategoryDO> selectByQuery(DouguoCategoryQuery query) {
        return douguoCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<DouguoCategoryDO> selectByQueryWithPage(DouguoCategoryQuery query) {
        PageResult<DouguoCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public DouguoCategoryDO selectByPrimaryKey(Long id) {
        return douguoCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(DouguoCategoryDO record, DouguoCategoryQuery query) {
        return douguoCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(DouguoCategoryDO record, DouguoCategoryQuery query) {
        return douguoCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(DouguoCategoryDO record) {
        return douguoCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<DouguoCategoryDO> records) {
        return douguoCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<DouguoCategoryDO> records) {
        return douguoCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public DouguoCategoryDO selectByCategoryUrl(String categoryUrl) {
        DouguoCategoryQuery query = new DouguoCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return douguoCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return douguoCategoryMapper.selectNoCrawledMinMaxId();
    }

    public List<DouguoCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        DouguoCategoryQuery query = new DouguoCategoryQuery();
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .addCondition(splitterClause);
        return douguoCategoryMapper.selectByQuery(query);
    }
    
}