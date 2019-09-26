package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.FancaiCategoryDO;
import com.rulai.spider.bean.model.XianghaCategoryDO;
import com.rulai.spider.bean.query.FancaiCategoryQuery;
import com.rulai.spider.bean.query.XianghaCategoryQuery;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.mapper.ext.XianghaCategoryExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XianghaCategory.
 */
@Component
public class XianghaCategoryManager {

    @Autowired
    private XianghaCategoryExtMapper xianghaCategoryMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XianghaCategoryQuery query){
        return xianghaCategoryMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xianghaCategoryMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XianghaCategoryQuery query) {
        return xianghaCategoryMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xianghaCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XianghaCategoryDO record) {
        return xianghaCategoryMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XianghaCategoryDO> records) {
        return xianghaCategoryMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XianghaCategoryDO> selectByQuery(XianghaCategoryQuery query) {
        return xianghaCategoryMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XianghaCategoryDO> selectByQueryWithPage(XianghaCategoryQuery query) {
        PageResult<XianghaCategoryDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XianghaCategoryDO selectByPrimaryKey(Long id) {
        return xianghaCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XianghaCategoryDO record, XianghaCategoryQuery query) {
        return xianghaCategoryMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XianghaCategoryDO record, XianghaCategoryQuery query) {
        return xianghaCategoryMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XianghaCategoryDO record) {
        return xianghaCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XianghaCategoryDO> records) {
        return xianghaCategoryMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XianghaCategoryDO> records) {
        return xianghaCategoryMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XianghaCategoryDO selectByCategoryUrl(String categoryUrl) {
        XianghaCategoryQuery query = new XianghaCategoryQuery();
        query.setPageNo(1);
        query.setPageOffset(0);
        query.createCriteria().andCategoryUrlEqualTo(categoryUrl);
        return xianghaCategoryMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

    public SplitterDTO selectNoCrawledMinMaxId() {
        return xianghaCategoryMapper.selectNoCrawledMinMaxId();
    }

    public List<XianghaCategoryDO> selectNotCrawledWithSplitter(String splitterClause) {
        XianghaCategoryQuery query = new XianghaCategoryQuery();
//        query.setPageSize(5);
//        query.setPageOffset(0);
        query.createCriteria()
                .andIsCrawledEqualTo(IsCrawledEnum.NO.getCode())
                .andIsEffectiveEqualTo(IsEffectiveEnum.YES.getCode())
                .addCondition(splitterClause);
        return xianghaCategoryMapper.selectByQuery(query);
    }
    
}