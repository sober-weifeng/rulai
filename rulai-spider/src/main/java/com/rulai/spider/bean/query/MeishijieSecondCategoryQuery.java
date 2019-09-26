package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>MeishijieSecondCategoryQuery</p>
 * @date 2019-09-03 15:10:36
 */
public class MeishijieSecondCategoryQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String PROP_KEY_ID = "id";
    
    private static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    private static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    private static final String PROP_KEY_TOP_CATEGORY_ID = "topCategoryId";
    
    private static final String PROP_KEY_TOP_CATEGORY_TIP = "topCategoryTip";
    
    private static final String PROP_KEY_IS_CRAWLED = "isCrawled";
    
    private static final String PROP_KEY_CATEGORY_NAME = "categoryName";
    
    private static final String PROP_KEY_CATEGORY_URL = "categoryUrl";
    
    public MeishijieSecondCategoryQuery() {
        super();
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        super.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    /**
     * This class corresponds to the database table meishijie_second_category
     */
    protected abstract static class GeneratedCriteria extends BaseCriteria {
    
        private static final long serialVersionUID = 1L;

        protected GeneratedCriteria() {
            super();
        }
        
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, PROP_KEY_ID);
            return (Criteria) this;
        }
        

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdLike(Long value) {
            addCriterion("id like", value, PROP_KEY_ID);
            return (Criteria) this;
        }


        public Criteria andIdNotLike(Long value) {
            addCriterion("id not like", value, PROP_KEY_ID);
            return (Criteria) this;
        }
        

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, PROP_KEY_ID);
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }
        

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateLike(Date value) {
            addCriterion("gmt_create like", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }


        public Criteria andGmtCreateNotLike(Date value) {
            addCriterion("gmt_create not like", value, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }
        

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, PROP_KEY_GMT_CREATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateIsNull() {
            addCriterion("gmt_update is null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateIsNotNull() {
            addCriterion("gmt_update is not null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateEqualTo(Date value) {
            addCriterion("gmt_update =", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotEqualTo(Date value) {
            addCriterion("gmt_update <>", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }
        

        public Criteria andGmtUpdateGreaterThan(Date value) {
            addCriterion("gmt_update >", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_update >=", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateLessThan(Date value) {
            addCriterion("gmt_update <", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_update <=", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateLike(Date value) {
            addCriterion("gmt_update like", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }


        public Criteria andGmtUpdateNotLike(Date value) {
            addCriterion("gmt_update not like", value, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }
        

        public Criteria andGmtUpdateIn(List<Date> values) {
            addCriterion("gmt_update in", values, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotIn(List<Date> values) {
            addCriterion("gmt_update not in", values, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateBetween(Date value1, Date value2) {
            addCriterion("gmt_update between", value1, value2, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_update not between", value1, value2, PROP_KEY_GMT_UPDATE);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdIsNull() {
            addCriterion("top_category_id is null");
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdIsNotNull() {
            addCriterion("top_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdEqualTo(Long value) {
            addCriterion("top_category_id =", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdNotEqualTo(Long value) {
            addCriterion("top_category_id <>", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }
        

        public Criteria andTopCategoryIdGreaterThan(Long value) {
            addCriterion("top_category_id >", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("top_category_id >=", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdLessThan(Long value) {
            addCriterion("top_category_id <", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("top_category_id <=", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdLike(Long value) {
            addCriterion("top_category_id like", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }


        public Criteria andTopCategoryIdNotLike(Long value) {
            addCriterion("top_category_id not like", value, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }
        

        public Criteria andTopCategoryIdIn(List<Long> values) {
            addCriterion("top_category_id in", values, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdNotIn(List<Long> values) {
            addCriterion("top_category_id not in", values, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdBetween(Long value1, Long value2) {
            addCriterion("top_category_id between", value1, value2, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("top_category_id not between", value1, value2, PROP_KEY_TOP_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipIsNull() {
            addCriterion("top_category_tip is null");
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipIsNotNull() {
            addCriterion("top_category_tip is not null");
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipEqualToIgnoreCase(String value) {
            addCriterion("UPPER(top_category_tip) =", value.trim().toUpperCase(), PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }
        
        public Criteria andTopCategoryTipEqualTo(String value) {
            addCriterion("top_category_tip =", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipNotEqualTo(String value) {
            addCriterion("top_category_tip <>", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }
        
        public Criteria andTopCategoryTipNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(top_category_tip) <>", value.trim().toUpperCase(), PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }
        

        public Criteria andTopCategoryTipGreaterThan(String value) {
            addCriterion("top_category_tip >", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipGreaterThanOrEqualTo(String value) {
            addCriterion("top_category_tip >=", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipLessThan(String value) {
            addCriterion("top_category_tip <", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipLessThanOrEqualTo(String value) {
            addCriterion("top_category_tip <=", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipLike(String value) {
            addCriterion("top_category_tip like", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipLikeIgnoreCase(String value) {
            addCriterion("UPPER(top_category_tip) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }
        

        public Criteria andTopCategoryTipNotLike(String value) {
            addCriterion("top_category_tip not like", value, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }
        
        public Criteria andTopCategoryTipNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(top_category_tip) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }
        

        public Criteria andTopCategoryTipIn(List<String> values) {
            addCriterion("top_category_tip in", values, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipNotIn(List<String> values) {
            addCriterion("top_category_tip not in", values, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipBetween(String value1, String value2) {
            addCriterion("top_category_tip between", value1, value2, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andTopCategoryTipNotBetween(String value1, String value2) {
            addCriterion("top_category_tip not between", value1, value2, PROP_KEY_TOP_CATEGORY_TIP);
            return (Criteria) this;
        }

        public Criteria andIsCrawledIsNull() {
            addCriterion("is_crawled is null");
            return (Criteria) this;
        }

        public Criteria andIsCrawledIsNotNull() {
            addCriterion("is_crawled is not null");
            return (Criteria) this;
        }

        public Criteria andIsCrawledEqualTo(Integer value) {
            addCriterion("is_crawled =", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledNotEqualTo(Integer value) {
            addCriterion("is_crawled <>", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }
        

        public Criteria andIsCrawledGreaterThan(Integer value) {
            addCriterion("is_crawled >", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_crawled >=", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledLessThan(Integer value) {
            addCriterion("is_crawled <", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledLessThanOrEqualTo(Integer value) {
            addCriterion("is_crawled <=", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledLike(Integer value) {
            addCriterion("is_crawled like", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }


        public Criteria andIsCrawledNotLike(Integer value) {
            addCriterion("is_crawled not like", value, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }
        

        public Criteria andIsCrawledIn(List<Integer> values) {
            addCriterion("is_crawled in", values, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledNotIn(List<Integer> values) {
            addCriterion("is_crawled not in", values, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledBetween(Integer value1, Integer value2) {
            addCriterion("is_crawled between", value1, value2, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andIsCrawledNotBetween(Integer value1, Integer value2) {
            addCriterion("is_crawled not between", value1, value2, PROP_KEY_IS_CRAWLED);
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualToIgnoreCase(String value) {
            addCriterion("UPPER(category_name) =", value.trim().toUpperCase(), PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andCategoryNameNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(category_name) <>", value.trim().toUpperCase(), PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameLikeIgnoreCase(String value) {
            addCriterion("UPPER(category_name) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andCategoryNameNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(category_name) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, PROP_KEY_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNull() {
            addCriterion("category_url is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNotNull() {
            addCriterion("category_url is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlEqualToIgnoreCase(String value) {
            addCriterion("UPPER(category_url) =", value.trim().toUpperCase(), PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }
        
        public Criteria andCategoryUrlEqualTo(String value) {
            addCriterion("category_url =", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotEqualTo(String value) {
            addCriterion("category_url <>", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }
        
        public Criteria andCategoryUrlNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(category_url) <>", value.trim().toUpperCase(), PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }
        

        public Criteria andCategoryUrlGreaterThan(String value) {
            addCriterion("category_url >", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlGreaterThanOrEqualTo(String value) {
            addCriterion("category_url >=", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThan(String value) {
            addCriterion("category_url <", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThanOrEqualTo(String value) {
            addCriterion("category_url <=", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLike(String value) {
            addCriterion("category_url like", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLikeIgnoreCase(String value) {
            addCriterion("UPPER(category_url) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }
        

        public Criteria andCategoryUrlNotLike(String value) {
            addCriterion("category_url not like", value, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }
        
        public Criteria andCategoryUrlNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(category_url) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }
        

        public Criteria andCategoryUrlIn(List<String> values) {
            addCriterion("category_url in", values, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotIn(List<String> values) {
            addCriterion("category_url not in", values, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlBetween(String value1, String value2) {
            addCriterion("category_url between", value1, value2, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotBetween(String value1, String value2) {
            addCriterion("category_url not between", value1, value2, PROP_KEY_CATEGORY_URL);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table meishijie_second_category
    */
    public static class Criteria extends GeneratedCriteria{
    
        private static final long serialVersionUID = 1L;
    
        protected Criteria() {
            super();
        }
        
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}