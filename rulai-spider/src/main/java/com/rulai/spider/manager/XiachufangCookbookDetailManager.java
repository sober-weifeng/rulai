package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.XiachufangCookbookDetailDO;
import com.rulai.spider.bean.query.XiachufangCookbookDetailQuery;
import com.rulai.spider.mapper.ext.XiachufangCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for XiachufangCookbookDetail.
 */
@Component
public class XiachufangCookbookDetailManager {

    @Autowired
    private XiachufangCookbookDetailExtMapper xiachufangCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(XiachufangCookbookDetailQuery query){
        return xiachufangCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return xiachufangCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(XiachufangCookbookDetailQuery query) {
        return xiachufangCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return xiachufangCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(XiachufangCookbookDetailDO record) {
        return xiachufangCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<XiachufangCookbookDetailDO> records) {
        return xiachufangCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<XiachufangCookbookDetailDO> selectByQuery(XiachufangCookbookDetailQuery query) {
        return xiachufangCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<XiachufangCookbookDetailDO> selectByQueryWithPage(XiachufangCookbookDetailQuery query) {
        PageResult<XiachufangCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public XiachufangCookbookDetailDO selectByPrimaryKey(Long id) {
        return xiachufangCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(XiachufangCookbookDetailDO record, XiachufangCookbookDetailQuery query) {
        return xiachufangCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(XiachufangCookbookDetailDO record, XiachufangCookbookDetailQuery query) {
        return xiachufangCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(XiachufangCookbookDetailDO record) {
        return xiachufangCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<XiachufangCookbookDetailDO> records) {
        return xiachufangCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<XiachufangCookbookDetailDO> records) {
        return xiachufangCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public XiachufangCookbookDetailDO selectByCookbookUrl(Long cookbookUrlId) {
        XiachufangCookbookDetailQuery query = new XiachufangCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId);
        return xiachufangCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}