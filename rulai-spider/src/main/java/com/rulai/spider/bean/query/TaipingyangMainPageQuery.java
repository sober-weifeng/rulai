package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>TaipingyangMainPageQuery</p>
 * @date 2019-08-22 17:25:57
 */
public class TaipingyangMainPageQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String PROP_KEY_ID = "id";
    
    private static final String PROP_KEY_MAIN_ORIGIN_URL = "mainOriginUrl";
    
    public TaipingyangMainPageQuery() {
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
     * This class corresponds to the database table taipingyang_main_page
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

        public Criteria andMainOriginUrlIsNull() {
            addCriterion("main_origin_url is null");
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlIsNotNull() {
            addCriterion("main_origin_url is not null");
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlEqualToIgnoreCase(String value) {
            addCriterion("UPPER(main_origin_url) =", value.trim().toUpperCase(), PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }
        
        public Criteria andMainOriginUrlEqualTo(String value) {
            addCriterion("main_origin_url =", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlNotEqualTo(String value) {
            addCriterion("main_origin_url <>", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }
        
        public Criteria andMainOriginUrlNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(main_origin_url) <>", value.trim().toUpperCase(), PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }
        

        public Criteria andMainOriginUrlGreaterThan(String value) {
            addCriterion("main_origin_url >", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlGreaterThanOrEqualTo(String value) {
            addCriterion("main_origin_url >=", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlLessThan(String value) {
            addCriterion("main_origin_url <", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlLessThanOrEqualTo(String value) {
            addCriterion("main_origin_url <=", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlLike(String value) {
            addCriterion("main_origin_url like", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlLikeIgnoreCase(String value) {
            addCriterion("UPPER(main_origin_url) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }
        

        public Criteria andMainOriginUrlNotLike(String value) {
            addCriterion("main_origin_url not like", value, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }
        
        public Criteria andMainOriginUrlNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(main_origin_url) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }
        

        public Criteria andMainOriginUrlIn(List<String> values) {
            addCriterion("main_origin_url in", values, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlNotIn(List<String> values) {
            addCriterion("main_origin_url not in", values, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlBetween(String value1, String value2) {
            addCriterion("main_origin_url between", value1, value2, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

        public Criteria andMainOriginUrlNotBetween(String value1, String value2) {
            addCriterion("main_origin_url not between", value1, value2, PROP_KEY_MAIN_ORIGIN_URL);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table taipingyang_main_page
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