package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.XinshipuCookbookDetailDO;
import com.rulai.spider.bean.query.XinshipuCookbookDetailQuery;
import com.rulai.spider.mapper.ext.XinshipuCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XinshipuCookbookDetail.
 */
@Component
public class XinshipuCookbookDetailManager {

    @Autowired
    private XinshipuCookbookDetailExtMapper xinshipuCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XinshipuCookbookDetailQuery query){
        return xinshipuCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xinshipuCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XinshipuCookbookDetailQuery query) {
        return xinshipuCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xinshipuCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XinshipuCookbookDetailDO record) {
        return xinshipuCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XinshipuCookbookDetailDO> records) {
        return xinshipuCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XinshipuCookbookDetailDO> selectByQuery(XinshipuCookbookDetailQuery query) {
        return xinshipuCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XinshipuCookbookDetailDO> selectByQueryWithPage(XinshipuCookbookDetailQuery query) {
        PageResult<XinshipuCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XinshipuCookbookDetailDO selectByPrimaryKey(Long id) {
        return xinshipuCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( XinshipuCookbookDetailDO record, XinshipuCookbookDetailQuery query) {
        return xinshipuCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XinshipuCookbookDetailDO record, XinshipuCookbookDetailQuery query) {
        return xinshipuCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XinshipuCookbookDetailDO record) {
        return xinshipuCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XinshipuCookbookDetailDO> records) {
        return xinshipuCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XinshipuCookbookDetailDO> records) {
        return xinshipuCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XinshipuCookbookDetailDO selectByCookbookUrl(String cookbookUrl) {
        XinshipuCookbookDetailQuery query = new XinshipuCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return xinshipuCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}