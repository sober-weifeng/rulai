package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>TaipingyangSecondCategoryQuery</p>
 * @date 2019-08-22 18:18:31
 */
public class TaipingyangSecondCategoryQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String PROP_KEY_ID = "id";
    
    private static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    private static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    private static final String PROP_KEY_TOP_CATEGORY_ID = "topCategoryId";
    
    private static final String PROP_KEY_CATEGORY_NAME = "categoryName";
    
    private static final String PROP_KEY_LABEL_ID = "labelId";
    
    public TaipingyangSecondCategoryQuery() {
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
     * This class corresponds to the database table taipingyang_second_category
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

        public Criteria andLabelIdIsNull() {
            addCriterion("label_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNotNull() {
            addCriterion("label_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdEqualToIgnoreCase(String value) {
            addCriterion("UPPER(label_id) =", value.trim().toUpperCase(), PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }
        
        public Criteria andLabelIdEqualTo(String value) {
            addCriterion("label_id =", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdNotEqualTo(String value) {
            addCriterion("label_id <>", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }
        
        public Criteria andLabelIdNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(label_id) <>", value.trim().toUpperCase(), PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }
        

        public Criteria andLabelIdGreaterThan(String value) {
            addCriterion("label_id >", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThanOrEqualTo(String value) {
            addCriterion("label_id >=", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThan(String value) {
            addCriterion("label_id <", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThanOrEqualTo(String value) {
            addCriterion("label_id <=", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdLike(String value) {
            addCriterion("label_id like", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdLikeIgnoreCase(String value) {
            addCriterion("UPPER(label_id) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }
        

        public Criteria andLabelIdNotLike(String value) {
            addCriterion("label_id not like", value, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }
        
        public Criteria andLabelIdNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(label_id) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }
        

        public Criteria andLabelIdIn(List<String> values) {
            addCriterion("label_id in", values, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdNotIn(List<String> values) {
            addCriterion("label_id not in", values, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdBetween(String value1, String value2) {
            addCriterion("label_id between", value1, value2, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

        public Criteria andLabelIdNotBetween(String value1, String value2) {
            addCriterion("label_id not between", value1, value2, PROP_KEY_LABEL_ID);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table taipingyang_second_category
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