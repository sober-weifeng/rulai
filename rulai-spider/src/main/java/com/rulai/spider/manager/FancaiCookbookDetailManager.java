package com.rulai.spider.manager;

import com.rulai.common.component.PageResult;
import com.rulai.spider.bean.model.FancaiCookbookDetailDO;
import com.rulai.spider.bean.query.FancaiCookbookDetailQuery;
import com.rulai.spider.mapper.ext.FancaiCookbookDetailExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FancaiCookbookDetail.
 */
@Component
public class FancaiCookbookDetailManager {

    @Autowired
    private FancaiCookbookDetailExtMapper fancaiCookbookDetailMapper;

    /**
     * query count by query condition.
     */
    public int countByQuery(FancaiCookbookDetailQuery query) {
        return fancaiCookbookDetailMapper.countByQuery(query);
    }

    /**
     * query count by primary key.
     */
    public int countByPrimaryKey(Long id) {
        return fancaiCookbookDetailMapper.countByPrimaryKey(id);
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
    public int deleteByQuery(FancaiCookbookDetailQuery query) {
        return fancaiCookbookDetailMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    public int deleteByPrimaryKey(Long id) {
        return fancaiCookbookDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert selective.
     */
    public int insertSelective(FancaiCookbookDetailDO record) {
        return fancaiCookbookDetailMapper.insertSelective(record);
    }

    /**
     * insert selective.
     */
    public int batchInsert(List<FancaiCookbookDetailDO> records) {
        return fancaiCookbookDetailMapper.batchInsert(records);
    }

    /**
     * select by query condition.
     */
    public List<FancaiCookbookDetailDO> selectByQuery(FancaiCookbookDetailQuery query) {
        return fancaiCookbookDetailMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
     */
    public PageResult<FancaiCookbookDetailDO> selectByQueryWithPage(FancaiCookbookDetailQuery query) {
        PageResult<FancaiCookbookDetailDO> result = new PageResult<>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    public FancaiCookbookDetailDO selectByPrimaryKey(Long id) {
        return fancaiCookbookDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    public int updateByQuerySelective(FancaiCookbookDetailDO record, FancaiCookbookDetailQuery query) {
        return fancaiCookbookDetailMapper.updateByQuerySelective(record, query);
    }

    /**
     * update by query condition.
     */
    public int updateByQuery(FancaiCookbookDetailDO record, FancaiCookbookDetailQuery query) {
        return fancaiCookbookDetailMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    public int updateByPrimaryKeySelective(FancaiCookbookDetailDO record) {
        return fancaiCookbookDetailMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * batch update by primary key.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKey(List<FancaiCookbookDetailDO> records) {
        return fancaiCookbookDetailMapper.batchUpdateByPrimaryKey(records);
    }

    /**
     * batch update by primary key selective.
     * @param records
     * @return
     */
    public int batchUpdateByPrimaryKeySelective(List<FancaiCookbookDetailDO> records) {
        return fancaiCookbookDetailMapper.batchUpdateByPrimaryKeySelective(records);
    }

    public FancaiCookbookDetailDO selectByCookbookUrlId(Long cookbookUrlId) {
        FancaiCookbookDetailQuery query = new FancaiCookbookDetailQuery();
        query.setPageSize(1);
        query.setPageOffset(0);
        query.createCriteria().andCookbookUrlIdEqualTo(cookbookUrlId);
        return fancaiCookbookDetailMapper.selectByQuery(query).stream().findFirst().orElse(null);
    }

}