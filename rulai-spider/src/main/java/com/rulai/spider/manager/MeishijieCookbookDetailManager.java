package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.MeishijieCookbookDetailDO;
import com.rulai.spider.bean.query.MeishijieCookbookDetailQuery;
import com.rulai.spider.mapper.ext.MeishijieCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for MeishijieCookbookDetail.
 */
@Component
public class MeishijieCookbookDetailManager {

    @Autowired
    private MeishijieCookbookDetailExtMapper meishijieCookbookDetailMapper;
    
    /**
     * query count by query condition.
     */
    public int countByQuery(MeishijieCookbookDetailQuery query){
        return meishijieCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return meishijieCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(MeishijieCookbookDetailQuery query) {
        return meishijieCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return meishijieCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(MeishijieCookbookDetailDO record) {
        return meishijieCookbookDetailMapper.insertSelective(record);
    }
    
    /**
     * insert selective.
     */
    public int batchInsert(List<MeishijieCookbookDetailDO> records) {
        return meishijieCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<MeishijieCookbookDetailDO> selectByQuery(MeishijieCookbookDetailQuery query) {
        return meishijieCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    public PageResult<MeishijieCookbookDetailDO> selectByQueryWithPage(MeishijieCookbookDetailQuery query) {
        PageResult<MeishijieCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public MeishijieCookbookDetailDO selectByPrimaryKey(Long id) {
        return meishijieCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective( MeishijieCookbookDetailDO record, MeishijieCookbookDetailQuery query) {
        return meishijieCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(MeishijieCookbookDetailDO record, MeishijieCookbookDetailQuery query) {
        return meishijieCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(MeishijieCookbookDetailDO record) {
        return meishijieCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<MeishijieCookbookDetailDO> records) {
        return meishijieCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }
        
    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<MeishijieCookbookDetailDO> records) {
        return meishijieCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public MeishijieCookbookDetailDO selectByCookbookUrl(String cookbookUrl) {
        MeishijieCookbookDetailQuery query = new MeishijieCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlEqualTo(cookbookUrl);
        return meishijieCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }
    
}