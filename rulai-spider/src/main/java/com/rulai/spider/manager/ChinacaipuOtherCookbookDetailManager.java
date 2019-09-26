package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.ChinacaipuOtherCookbookDetailDO;
import com.rulai.spider.bean.query.ChinacaipuOtherCookbookDetailQuery;
import com.rulai.spider.mapper.ext.ChinacaipuOtherCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ChinacaipuOtherCookbookDetail.
 */
@Component
public class ChinacaipuOtherCookbookDetailManager {

    @Autowired
    private ChinacaipuOtherCookbookDetailExtMapper chinacaipuOtherCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ChinacaipuOtherCookbookDetailQuery query){
        return chinacaipuOtherCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return chinacaipuOtherCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ChinacaipuOtherCookbookDetailQuery query) {
        return chinacaipuOtherCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return chinacaipuOtherCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ChinacaipuOtherCookbookDetailDO record) {
        return chinacaipuOtherCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ChinacaipuOtherCookbookDetailDO> records) {
        return chinacaipuOtherCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ChinacaipuOtherCookbookDetailDO> selectByQuery(ChinacaipuOtherCookbookDetailQuery query) {
        return chinacaipuOtherCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ChinacaipuOtherCookbookDetailDO> selectByQueryWithPage(ChinacaipuOtherCookbookDetailQuery query) {
        PageResult<ChinacaipuOtherCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ChinacaipuOtherCookbookDetailDO selectByPrimaryKey(Long id) {
        return chinacaipuOtherCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( ChinacaipuOtherCookbookDetailDO record, ChinacaipuOtherCookbookDetailQuery query) {
        return chinacaipuOtherCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ChinacaipuOtherCookbookDetailDO record, ChinacaipuOtherCookbookDetailQuery query) {
        return chinacaipuOtherCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ChinacaipuOtherCookbookDetailDO record) {
        return chinacaipuOtherCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ChinacaipuOtherCookbookDetailDO> records) {
        return chinacaipuOtherCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ChinacaipuOtherCookbookDetailDO> records) {
        return chinacaipuOtherCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public ChinacaipuOtherCookbookDetailDO selectByCookbookUrl(String cookbookUrl) {
        ChinacaipuOtherCookbookDetailQuery query = new ChinacaipuOtherCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return chinacaipuOtherCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}