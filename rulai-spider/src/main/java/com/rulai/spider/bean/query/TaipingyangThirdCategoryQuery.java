package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>TaipingyangThirdCategoryQuery</p>
 * @date 2019-09-23 17:32:56
 */
public class TaipingyangThirdCategoryQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PROP_KEY_ID = "id";
    
    public static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    public static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    public static final String PROP_KEY_SECOND_CATEGORY_ID = "secondCategoryId";
    
    public static final String PROP_KEY_IS_CRAWLED = "isCrawled";
    
    public static final String PROP_KEY_IS_EFFECTIVE = "isEffective";
    
    public static final String PROP_KEY_CATEGORY_NAME = "categoryName";
    
    public static final String PROP_KEY_CATEGORY_URL = "categoryUrl";
    
    public TaipingyangThirdCategoryQuery() {
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
     * This class corresponds to the database table taipingyang_third_category
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

        public Criteria andSecondCategoryIdIsNull() {
            addCriterion("second_category_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdIsNotNull() {
            addCriterion("second_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdEqualTo(Long value) {
            addCriterion("second_category_id =", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdNotEqualTo(Long value) {
            addCriterion("second_category_id <>", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }
        

        public Criteria andSecondCategoryIdGreaterThan(Long value) {
            addCriterion("second_category_id >", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("second_category_id >=", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdLessThan(Long value) {
            addCriterion("second_category_id <", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("second_category_id <=", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdLike(Long value) {
            addCriterion("second_category_id like", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }


        public Criteria andSecondCategoryIdNotLike(Long value) {
            addCriterion("second_category_id not like", value, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }
        

        public Criteria andSecondCategoryIdIn(List<Long> values) {
            addCriterion("second_category_id in", values, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdNotIn(List<Long> values) {
            addCriterion("second_category_id not in", values, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdBetween(Long value1, Long value2) {
            addCriterion("second_category_id between", value1, value2, PROP_KEY_SECOND_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("second_category_id not between", value1, value2, PROP_KEY_SECOND_CATEGORY_ID);
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

        public Criteria andIsEffectiveIsNull() {
            addCriterion("is_effective is null");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveIsNotNull() {
            addCriterion("is_effective is not null");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveEqualTo(Integer value) {
            addCriterion("is_effective =", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveNotEqualTo(Integer value) {
            addCriterion("is_effective <>", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }
        

        public Criteria andIsEffectiveGreaterThan(Integer value) {
            addCriterion("is_effective >", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_effective >=", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveLessThan(Integer value) {
            addCriterion("is_effective <", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveLessThanOrEqualTo(Integer value) {
            addCriterion("is_effective <=", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveLike(Integer value) {
            addCriterion("is_effective like", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }


        public Criteria andIsEffectiveNotLike(Integer value) {
            addCriterion("is_effective not like", value, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }
        

        public Criteria andIsEffectiveIn(List<Integer> values) {
            addCriterion("is_effective in", values, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveNotIn(List<Integer> values) {
            addCriterion("is_effective not in", values, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveBetween(Integer value1, Integer value2) {
            addCriterion("is_effective between", value1, value2, PROP_KEY_IS_EFFECTIVE);
            return (Criteria) this;
        }

        public Criteria andIsEffectiveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_effective not between", value1, value2, PROP_KEY_IS_EFFECTIVE);
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
     * This class corresponds to the database table taipingyang_third_category
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