package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.MeishiCookbookDetailDO;
import com.rulai.spider.bean.query.MeishiCookbookDetailQuery;
import com.rulai.spider.mapper.ext.MeishiCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishiCookbookDetail.
 */
@Component
public class MeishiCookbookDetailManager {

    @Autowired
    private MeishiCookbookDetailExtMapper meishiCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishiCookbookDetailQuery query){
        return meishiCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishiCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishiCookbookDetailQuery query) {
        return meishiCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishiCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishiCookbookDetailDO record) {
        return meishiCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishiCookbookDetailDO> records) {
        return meishiCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishiCookbookDetailDO> selectByQuery(MeishiCookbookDetailQuery query) {
        return meishiCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishiCookbookDetailDO> selectByQueryWithPage(MeishiCookbookDetailQuery query) {
        PageResult<MeishiCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishiCookbookDetailDO selectByPrimaryKey(Long id) {
        return meishiCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(MeishiCookbookDetailDO record, MeishiCookbookDetailQuery query) {
        return meishiCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishiCookbookDetailDO record, MeishiCookbookDetailQuery query) {
        return meishiCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishiCookbookDetailDO record) {
        return meishiCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishiCookbookDetailDO> records) {
        return meishiCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishiCookbookDetailDO> records) {
        return meishiCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public MeishiCookbookDetailDO selectByCookbookUrlId(Long cookbookUrlId) {
        MeishiCookbookDetailQuery query = new MeishiCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId);
        return meishiCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}