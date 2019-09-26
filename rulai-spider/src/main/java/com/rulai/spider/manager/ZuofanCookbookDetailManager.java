package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.ZuofanCookbookDetailDO;
import com.rulai.spider.bean.query.ZuofanCookbookDetailQuery;
import com.rulai.spider.mapper.ext.ZuofanCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ZuofanCookbookDetail.
 */
@Component
public class ZuofanCookbookDetailManager {

    @Autowired
    private ZuofanCookbookDetailExtMapper zuofanCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ZuofanCookbookDetailQuery query){
        return zuofanCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return zuofanCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ZuofanCookbookDetailQuery query) {
        return zuofanCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return zuofanCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ZuofanCookbookDetailDO record) {
        return zuofanCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ZuofanCookbookDetailDO> records) {
        return zuofanCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ZuofanCookbookDetailDO> selectByQuery(ZuofanCookbookDetailQuery query) {
        return zuofanCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ZuofanCookbookDetailDO> selectByQueryWithPage(ZuofanCookbookDetailQuery query) {
        PageResult<ZuofanCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ZuofanCookbookDetailDO selectByPrimaryKey(Long id) {
        return zuofanCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(ZuofanCookbookDetailDO record, ZuofanCookbookDetailQuery query) {
        return zuofanCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ZuofanCookbookDetailDO record, ZuofanCookbookDetailQuery query) {
        return zuofanCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ZuofanCookbookDetailDO record) {
        return zuofanCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ZuofanCookbookDetailDO> records) {
        return zuofanCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ZuofanCookbookDetailDO> records) {
        return zuofanCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public ZuofanCookbookDetailDO selectByCookbookUrlId(Long cookbookUrlId) {
        ZuofanCookbookDetailQuery query = new ZuofanCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId);
        return zuofanCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}