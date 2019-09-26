package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.XianghaCookbookDetailDO;
import com.rulai.spider.bean.query.XianghaCookbookDetailQuery;
import com.rulai.spider.mapper.ext.XianghaCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XianghaCookbookDetail.
 */
@Component
public class XianghaCookbookDetailManager {

    @Autowired
    private XianghaCookbookDetailExtMapper xianghaCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XianghaCookbookDetailQuery query){
        return xianghaCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xianghaCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XianghaCookbookDetailQuery query) {
        return xianghaCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xianghaCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XianghaCookbookDetailDO record) {
        return xianghaCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XianghaCookbookDetailDO> records) {
        return xianghaCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XianghaCookbookDetailDO> selectByQuery(XianghaCookbookDetailQuery query) {
        return xianghaCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XianghaCookbookDetailDO> selectByQueryWithPage(XianghaCookbookDetailQuery query) {
        PageResult<XianghaCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XianghaCookbookDetailDO selectByPrimaryKey(Long id) {
        return xianghaCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XianghaCookbookDetailDO record, XianghaCookbookDetailQuery query) {
        return xianghaCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XianghaCookbookDetailDO record, XianghaCookbookDetailQuery query) {
        return xianghaCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XianghaCookbookDetailDO record) {
        return xianghaCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XianghaCookbookDetailDO> records) {
        return xianghaCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XianghaCookbookDetailDO> records) {
        return xianghaCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XianghaCookbookDetailDO selectByCookbookUrlId(Long cookbookUrlId) {
        XianghaCookbookDetailQuery query = new XianghaCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId);
        return xianghaCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}