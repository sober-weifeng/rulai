package com.rulai.spider.manager;

import com.rulai.spider.bean.model.ChinacaipuCookbookDetailDO;
import com.rulai.spider.bean.query.ChinacaipuCookbookDetailQuery;
import com.rulai.common.component.PageResult;
import com.rulai.spider.mapper.ext.ChinacaipuCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ChinacaipuCookbookDetail.
 */
@Component
public class ChinacaipuCookbookDetailManager {

    @Autowired
    private ChinacaipuCookbookDetailExtMapper chinacaipuCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(ChinacaipuCookbookDetailQuery query){
        return chinacaipuCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return chinacaipuCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(ChinacaipuCookbookDetailQuery query) {
        return chinacaipuCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return chinacaipuCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(ChinacaipuCookbookDetailDO record) {
        return chinacaipuCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<ChinacaipuCookbookDetailDO> records) {
        return chinacaipuCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<ChinacaipuCookbookDetailDO> selectByQuery(ChinacaipuCookbookDetailQuery query) {
        return chinacaipuCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<ChinacaipuCookbookDetailDO> selectByQueryWithPage(ChinacaipuCookbookDetailQuery query) {
        PageResult<ChinacaipuCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public ChinacaipuCookbookDetailDO selectByPrimaryKey(Long id) {
        return chinacaipuCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( ChinacaipuCookbookDetailDO record, ChinacaipuCookbookDetailQuery query) {
        return chinacaipuCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(ChinacaipuCookbookDetailDO record, ChinacaipuCookbookDetailQuery query) {
        return chinacaipuCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(ChinacaipuCookbookDetailDO record) {
        return chinacaipuCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<ChinacaipuCookbookDetailDO> records) {
        return chinacaipuCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<ChinacaipuCookbookDetailDO> records) {
        return chinacaipuCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }
    
    public ChinacaipuCookbookDetailDO selectByCookbookUrl(String cookbookUrl) {
        ChinacaipuCookbookDetailQuery query = new ChinacaipuCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return chinacaipuCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}