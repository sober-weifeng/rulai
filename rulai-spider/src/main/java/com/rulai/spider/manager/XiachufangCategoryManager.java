package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.XiachufangCategoryDO;
import com.rulai.spider.bean.query.XiachufangCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.mapper.ext.XiachufangCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XiachufangCategory.
 */
@Component
public class XiachufangCategoryManager {

    @Autowired
    private XiachufangCategoryExtMapper xiachufangCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XiachufangCategoryQuery query){
        return xiachufangCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xiachufangCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XiachufangCategoryQuery query) {
        return xiachufangCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xiachufangCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XiachufangCategoryDO record) {
        return xiachufangCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XiachufangCategoryDO> records) {
        return xiachufangCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XiachufangCategoryDO> selectByQuery(XiachufangCategoryQuery query) {
        return xiachufangCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XiachufangCategoryDO> selectByQueryWithPage(XiachufangCategoryQuery query) {
        PageResult<XiachufangCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XiachufangCategoryDO selectByPrimaryKey(Long id) {
        return xiachufangCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XiachufangCategoryDO record, XiachufangCategoryQuery query) {
        return xiachufangCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XiachufangCategoryDO record, XiachufangCategoryQuery query) {
        return xiachufangCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XiachufangCategoryDO record) {
        return xiachufangCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XiachufangCategoryDO> records) {
        return xiachufangCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XiachufangCategoryDO> records) {
        return xiachufangCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XiachufangCategoryDO selectByCategoryUrl(String categoryUrl) {
        XiachufangCategoryQuery query = new XiachufangCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return xiachufangCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return xiachufangCategoryMapper.selectNoCrawledMinMaxId();
    }

    public List<XiachufangCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        XiachufangCategoryQuery query = new XiachufangCategoryQuery();
        query.setOrderByClause("id DESC");
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .addCondition(splitterClause);
        return xiachufangCategoryMapper.selectByQuery(query);
    }
    
}