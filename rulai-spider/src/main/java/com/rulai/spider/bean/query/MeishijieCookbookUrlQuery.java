package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>MeishijieCookbookUrlQuery</p>
 * @date 2019-09-04 14:56:11
 */
public class MeishijieCookbookUrlQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String PROP_KEY_ID = "id";
    
    private static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    private static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    private static final String PROP_KEY_IS_CRAWLED = "isCrawled";
    
    private static final String PROP_KEY_COOKBOOK_NAME = "cookbookName";
    
    private static final String PROP_KEY_COOKBOOK_URL = "cookbookUrl";
    
    private static final String PROP_KEY_SECOND_LOCATION_URL = "secondLocationUrl";
    
    private static final String PROP_KEY_TOP_LOCATION_URL = "topLocationUrl";
    
    private static final String PROP_KEY_IS_EFFECTIVE = "isEffective";
    
    private static final String PROP_KEY_CRAWL_TYPE = "crawlType";
    
    public MeishijieCookbookUrlQuery() {
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
     * This class corresponds to the database table meishijie_cookbook_url
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

        public Criteria andCookbookNameIsNull() {
            addCriterion("cookbook_name is null");
            return (Criteria) this;
        }

        public Criteria andCookbookNameIsNotNull() {
            addCriterion("cookbook_name is not null");
            return (Criteria) this;
        }

        public Criteria andCookbookNameEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_name) =", value.trim().toUpperCase(), PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }
        
        public Criteria andCookbookNameEqualTo(String value) {
            addCriterion("cookbook_name =", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameNotEqualTo(String value) {
            addCriterion("cookbook_name <>", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }
        
        public Criteria andCookbookNameNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_name) <>", value.trim().toUpperCase(), PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }
        

        public Criteria andCookbookNameGreaterThan(String value) {
            addCriterion("cookbook_name >", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameGreaterThanOrEqualTo(String value) {
            addCriterion("cookbook_name >=", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameLessThan(String value) {
            addCriterion("cookbook_name <", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameLessThanOrEqualTo(String value) {
            addCriterion("cookbook_name <=", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameLike(String value) {
            addCriterion("cookbook_name like", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameLikeIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_name) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }
        

        public Criteria andCookbookNameNotLike(String value) {
            addCriterion("cookbook_name not like", value, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }
        
        public Criteria andCookbookNameNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_name) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }
        

        public Criteria andCookbookNameIn(List<String> values) {
            addCriterion("cookbook_name in", values, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameNotIn(List<String> values) {
            addCriterion("cookbook_name not in", values, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameBetween(String value1, String value2) {
            addCriterion("cookbook_name between", value1, value2, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookNameNotBetween(String value1, String value2) {
            addCriterion("cookbook_name not between", value1, value2, PROP_KEY_COOKBOOK_NAME);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIsNull() {
            addCriterion("cookbook_url is null");
            return (Criteria) this;
        }

        public Criteria andCookbookUrlIsNotNull() {
            addCriterion("cookbook_url is not null");
            return (Criteria) this;
        }

        public Criteria andCookbookUrlEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_url) =", value.trim().toUpperCase(), PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }
        
        public Criteria andCookbookUrlEqualTo(String value) {
            addCriterion("cookbook_url =", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlNotEqualTo(String value) {
            addCriterion("cookbook_url <>", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }
        
        public Criteria andCookbookUrlNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_url) <>", value.trim().toUpperCase(), PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }
        

        public Criteria andCookbookUrlGreaterThan(String value) {
            addCriterion("cookbook_url >", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cookbook_url >=", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlLessThan(String value) {
            addCriterion("cookbook_url <", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlLessThanOrEqualTo(String value) {
            addCriterion("cookbook_url <=", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlLike(String value) {
            addCriterion("cookbook_url like", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlLikeIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_url) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }
        

        public Criteria andCookbookUrlNotLike(String value) {
            addCriterion("cookbook_url not like", value, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }
        
        public Criteria andCookbookUrlNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(cookbook_url) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }
        

        public Criteria andCookbookUrlIn(List<String> values) {
            addCriterion("cookbook_url in", values, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlNotIn(List<String> values) {
            addCriterion("cookbook_url not in", values, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlBetween(String value1, String value2) {
            addCriterion("cookbook_url between", value1, value2, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andCookbookUrlNotBetween(String value1, String value2) {
            addCriterion("cookbook_url not between", value1, value2, PROP_KEY_COOKBOOK_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlIsNull() {
            addCriterion("second_location_url is null");
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlIsNotNull() {
            addCriterion("second_location_url is not null");
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlEqualToIgnoreCase(String value) {
            addCriterion("UPPER(second_location_url) =", value.trim().toUpperCase(), PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andSecondLocationUrlEqualTo(String value) {
            addCriterion("second_location_url =", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlNotEqualTo(String value) {
            addCriterion("second_location_url <>", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andSecondLocationUrlNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(second_location_url) <>", value.trim().toUpperCase(), PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andSecondLocationUrlGreaterThan(String value) {
            addCriterion("second_location_url >", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlGreaterThanOrEqualTo(String value) {
            addCriterion("second_location_url >=", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlLessThan(String value) {
            addCriterion("second_location_url <", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlLessThanOrEqualTo(String value) {
            addCriterion("second_location_url <=", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlLike(String value) {
            addCriterion("second_location_url like", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlLikeIgnoreCase(String value) {
            addCriterion("UPPER(second_location_url) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andSecondLocationUrlNotLike(String value) {
            addCriterion("second_location_url not like", value, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andSecondLocationUrlNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(second_location_url) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andSecondLocationUrlIn(List<String> values) {
            addCriterion("second_location_url in", values, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlNotIn(List<String> values) {
            addCriterion("second_location_url not in", values, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlBetween(String value1, String value2) {
            addCriterion("second_location_url between", value1, value2, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andSecondLocationUrlNotBetween(String value1, String value2) {
            addCriterion("second_location_url not between", value1, value2, PROP_KEY_SECOND_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlIsNull() {
            addCriterion("top_location_url is null");
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlIsNotNull() {
            addCriterion("top_location_url is not null");
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlEqualToIgnoreCase(String value) {
            addCriterion("UPPER(top_location_url) =", value.trim().toUpperCase(), PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andTopLocationUrlEqualTo(String value) {
            addCriterion("top_location_url =", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlNotEqualTo(String value) {
            addCriterion("top_location_url <>", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andTopLocationUrlNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(top_location_url) <>", value.trim().toUpperCase(), PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andTopLocationUrlGreaterThan(String value) {
            addCriterion("top_location_url >", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlGreaterThanOrEqualTo(String value) {
            addCriterion("top_location_url >=", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlLessThan(String value) {
            addCriterion("top_location_url <", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlLessThanOrEqualTo(String value) {
            addCriterion("top_location_url <=", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlLike(String value) {
            addCriterion("top_location_url like", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlLikeIgnoreCase(String value) {
            addCriterion("UPPER(top_location_url) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andTopLocationUrlNotLike(String value) {
            addCriterion("top_location_url not like", value, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }
        
        public Criteria andTopLocationUrlNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(top_location_url) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }
        

        public Criteria andTopLocationUrlIn(List<String> values) {
            addCriterion("top_location_url in", values, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlNotIn(List<String> values) {
            addCriterion("top_location_url not in", values, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlBetween(String value1, String value2) {
            addCriterion("top_location_url between", value1, value2, PROP_KEY_TOP_LOCATION_URL);
            return (Criteria) this;
        }

        public Criteria andTopLocationUrlNotBetween(String value1, String value2) {
            addCriterion("top_location_url not between", value1, value2, PROP_KEY_TOP_LOCATION_URL);
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

        public Criteria andCrawlTypeIsNull() {
            addCriterion("crawl_type is null");
            return (Criteria) this;
        }

        public Criteria andCrawlTypeIsNotNull() {
            addCriterion("crawl_type is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlTypeEqualTo(Integer value) {
            addCriterion("crawl_type =", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeNotEqualTo(Integer value) {
            addCriterion("crawl_type <>", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }
        

        public Criteria andCrawlTypeGreaterThan(Integer value) {
            addCriterion("crawl_type >", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("crawl_type >=", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeLessThan(Integer value) {
            addCriterion("crawl_type <", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeLessThanOrEqualTo(Integer value) {
            addCriterion("crawl_type <=", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeLike(Integer value) {
            addCriterion("crawl_type like", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }


        public Criteria andCrawlTypeNotLike(Integer value) {
            addCriterion("crawl_type not like", value, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }
        

        public Criteria andCrawlTypeIn(List<Integer> values) {
            addCriterion("crawl_type in", values, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeNotIn(List<Integer> values) {
            addCriterion("crawl_type not in", values, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeBetween(Integer value1, Integer value2) {
            addCriterion("crawl_type between", value1, value2, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

        public Criteria andCrawlTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("crawl_type not between", value1, value2, PROP_KEY_CRAWL_TYPE);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table meishijie_cookbook_url
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