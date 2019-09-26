package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>XianghaCategoryQuery</p>
 * @date 2019-09-20 18:05:49
 */
public class XianghaCategoryQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PROP_KEY_ID = "id";
    
    public static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    public static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    public static final String PROP_KEY_IS_CRAWLED = "isCrawled";
    
    public static final String PROP_KEY_IS_EFFECTIVE = "isEffective";
    
    public static final String PROP_KEY_FIRST_CATEGORY_NAME = "firstCategoryName";
    
    public static final String PROP_KEY_SECOND_CATEGORY_NAME = "secondCategoryName";
    
    public static final String PROP_KEY_CATEGORY_URL = "categoryUrl";
    
    public XianghaCategoryQuery() {
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
     * This class corresponds to the database table xiangha_category
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

        public Criteria andFirstCategoryNameIsNull() {
            addCriterion("first_category_name is null");
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameIsNotNull() {
            addCriterion("first_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameEqualToIgnoreCase(String value) {
            addCriterion("UPPER(first_category_name) =", value.trim().toUpperCase(), PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andFirstCategoryNameEqualTo(String value) {
            addCriterion("first_category_name =", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameNotEqualTo(String value) {
            addCriterion("first_category_name <>", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andFirstCategoryNameNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(first_category_name) <>", value.trim().toUpperCase(), PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andFirstCategoryNameGreaterThan(String value) {
            addCriterion("first_category_name >", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("first_category_name >=", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameLessThan(String value) {
            addCriterion("first_category_name <", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("first_category_name <=", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameLike(String value) {
            addCriterion("first_category_name like", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameLikeIgnoreCase(String value) {
            addCriterion("UPPER(first_category_name) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andFirstCategoryNameNotLike(String value) {
            addCriterion("first_category_name not like", value, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andFirstCategoryNameNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(first_category_name) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andFirstCategoryNameIn(List<String> values) {
            addCriterion("first_category_name in", values, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameNotIn(List<String> values) {
            addCriterion("first_category_name not in", values, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameBetween(String value1, String value2) {
            addCriterion("first_category_name between", value1, value2, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andFirstCategoryNameNotBetween(String value1, String value2) {
            addCriterion("first_category_name not between", value1, value2, PROP_KEY_FIRST_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameIsNull() {
            addCriterion("second_category_name is null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameIsNotNull() {
            addCriterion("second_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameEqualToIgnoreCase(String value) {
            addCriterion("UPPER(second_category_name) =", value.trim().toUpperCase(), PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andSecondCategoryNameEqualTo(String value) {
            addCriterion("second_category_name =", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameNotEqualTo(String value) {
            addCriterion("second_category_name <>", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andSecondCategoryNameNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(second_category_name) <>", value.trim().toUpperCase(), PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andSecondCategoryNameGreaterThan(String value) {
            addCriterion("second_category_name >", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("second_category_name >=", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameLessThan(String value) {
            addCriterion("second_category_name <", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("second_category_name <=", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameLike(String value) {
            addCriterion("second_category_name like", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameLikeIgnoreCase(String value) {
            addCriterion("UPPER(second_category_name) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andSecondCategoryNameNotLike(String value) {
            addCriterion("second_category_name not like", value, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }
        
        public Criteria andSecondCategoryNameNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(second_category_name) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }
        

        public Criteria andSecondCategoryNameIn(List<String> values) {
            addCriterion("second_category_name in", values, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameNotIn(List<String> values) {
            addCriterion("second_category_name not in", values, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameBetween(String value1, String value2) {
            addCriterion("second_category_name between", value1, value2, PROP_KEY_SECOND_CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNameNotBetween(String value1, String value2) {
            addCriterion("second_category_name not between", value1, value2, PROP_KEY_SECOND_CATEGORY_NAME);
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
     * This class corresponds to the database table xiangha_category
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