package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>XiachufangCategoryCookbookRelationQuery</p>
 * @date 2019-09-17 10:06:11
 */
public class XiachufangCategoryCookbookRelationQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PROP_KEY_ID = "id";
    
    public static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    public static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    public static final String PROP_KEY_CATEGORY_ID = "categoryId";
    
    public static final String PROP_KEY_COOKBOOK_URL_ID = "cookbookUrlId";
    
    public static final String PROP_KEY_CATEGORY_LOCATION_URL = "categoryLocationUrl";
    
    public XiachufangCategoryCookbookRelationQuery() {
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
     * This class corresponds to the database table xiachufang_category_cookbook_relation
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }
        

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(Long value) {
            addCriterion("category_id like", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }


        public Criteria andCategoryIdNotLike(Long value) {
            addCriterion("category_id not like", value, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }
        

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, PROP_KEY_CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdIsNull() {
            addCriterion("cookbook_url_id is null");
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdIsNotNull() {
            addCriterion("cookbook_url_id is not null");
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdEqualTo(Long value) {
            addCriterion("cookbook_url_id =", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdNotEqualTo(Long value) {
            addCriterion("cookbook_url_id <>", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }
        

        public Criteria andCookbookUrlIdGreaterThan(Long value) {
            addCriterion("cookbook_url_id >", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cookbook_url_id >=", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdLessThan(Long value) {
            addCriterion("cookbook_url_id <", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdLessThanOrEqualTo(Long value) {
            addCriterion("cookbook_url_id <=", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdLike(Long value) {
            addCriterion("cookbook_url_id like", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }


        public Criteria andCookbookUrlIdNotLike(Long value) {
            addCriterion("cookbook_url_id not like", value, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }
        

        public Criteria andCookbookUrlIdIn(List<Long> values) {
            addCriterion("cookbook_url_id in", values, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdNotIn(List<Long> values) {
            addCriterion("cookbook_url_id not in", values, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdBetween(Long value1, Long value2) {
            addCriterion("cookbook_url_id between", value1, value2, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIdNotBetween(Long value1, Long value2) {
            addCriterion("cookbook_url_id not between", value1, value2, PROP_KEY_COOKBOOK_URL_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlIsNull() {
            addCriterion("category_location_url is null");
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlIsNotNull() {
            addCriterion("category_location_url is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlEqualToIgnoreCase(String value) {
            addCriterion("UPPER(category_location_url) =", value.trim().toUpperCase(), PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andCategoryLocationUrlEqualTo(String value) {
            addCriterion("category_location_url =", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlNotEqualTo(String value) {
            addCriterion("category_location_url <>", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andCategoryLocationUrlNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(category_location_url) <>", value.trim().toUpperCase(), PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andCategoryLocationUrlGreaterThan(String value) {
            addCriterion("category_location_url >", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlGreaterThanOrEqualTo(String value) {
            addCriterion("category_location_url >=", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlLessThan(String value) {
            addCriterion("category_location_url <", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlLessThanOrEqualTo(String value) {
            addCriterion("category_location_url <=", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlLike(String value) {
            addCriterion("category_location_url like", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlLikeIgnoreCase(String value) {
            addCriterion("UPPER(category_location_url) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andCategoryLocationUrlNotLike(String value) {
            addCriterion("category_location_url not like", value, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andCategoryLocationUrlNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(category_location_url) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andCategoryLocationUrlIn(List<String> values) {
            addCriterion("category_location_url in", values, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlNotIn(List<String> values) {
            addCriterion("category_location_url not in", values, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlBetween(String value1, String value2) {
            addCriterion("category_location_url between", value1, value2, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andCategoryLocationUrlNotBetween(String value1, String value2) {
            addCriterion("category_location_url not between", value1, value2, PROP_KEY_CATEGORY_LOCATION_URL);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table xiachufang_category_cookbook_relation
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