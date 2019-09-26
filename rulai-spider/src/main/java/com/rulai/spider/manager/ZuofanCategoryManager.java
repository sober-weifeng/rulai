package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.ZuofanCategoryDO;
import com.rulai.spider.bean.query.ZuofanCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.ZuofanCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ZuofanCategory.
 */
@Component
public class ZuofanCategoryManager {

    @Autowired
    private ZuofanCategoryExtMapper zuofanCategoryMapper;

    /**
     * query count by query condition.
     */
    public int countByQuery(ZuofanCategoryQuery query) {
        return zuofanCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return zuofanCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ZuofanCategoryQuery query) {
        return zuofanCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return zuofanCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ZuofanCategoryDO record) {
        return zuofanCategoryMapper.insertSelective(record);
    }

    /**
     * insert selective.
     */
    public int batchInsert(List<ZuofanCategoryDO> records) {
        return zuofanCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ZuofanCategoryDO> selectByQuery(ZuofanCategoryQuery query) {
        return zuofanCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
     */
    public PageResult<ZuofanCategoryDO> selectByQueryWithPage(ZuofanCategoryQuery query) {
        PageResult<ZuofanCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ZuofanCategoryDO selectByPrimaryKey(Long id) {
        return zuofanCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(ZuofanCategoryDO record, ZuofanCategoryQuery query) {
        return zuofanCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ZuofanCategoryDO record, ZuofanCategoryQuery query) {
        return zuofanCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ZuofanCategoryDO record) {
        return zuofanCategoryMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ZuofanCategoryDO> records) {
        return zuofanCategoryMapper.batchUpdateByPrimaryKey(records);
    }

    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ZuofanCategoryDO> records) {
        return zuofanCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public ZuofanCategoryDO selectByCategoryUrl(String categoryUrl) {
        ZuofanCategoryQuery query = new ZuofanCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return zuofanCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return zuofanCategoryMapper.selectNoCrawledMinMaxId();
    }

    public List<ZuofanCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        ZuofanCategoryQuery query = new ZuofanCategoryQuery();
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .addCondition(splitterClause);
        return zuofanCategoryMapper.selectByQuery(query);
    }

}