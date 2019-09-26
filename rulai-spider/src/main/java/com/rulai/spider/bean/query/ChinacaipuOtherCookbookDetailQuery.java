package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>ChinacaipuOtherCookbookDetailQuery</p>
 * @date 2019-09-02 16:50:52
 */
public class ChinacaipuOtherCookbookDetailQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String PROP_KEY_ID = "id";
    
    private static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    private static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    private static final String PROP_KEY_COOKBOOK_URL = "cookbookUrl";
    
    private static final String PROP_KEY_COOKBOOK_NAME = "cookbookName";
    
    private static final String PROP_KEY_TITLE = "title";
    
    private static final String PROP_KEY_AUTHOR = "author";
    
    private static final String PROP_KEY_EDIT_TIME = "editTime";
    
    private static final String PROP_KEY_DESCRIPTION = "description";
    
    private static final String PROP_KEY_COVER_PICTURE = "coverPicture";
    
    private static final String PROP_KEY_DETAIL = "detail";
    
    public ChinacaipuOtherCookbookDetailQuery() {
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
     * This class corresponds to the database table chinacaipu_other_cookbook_detail
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualToIgnoreCase(String value) {
            addCriterion("UPPER(title) =", value.trim().toUpperCase(), PROP_KEY_TITLE);
            return (Criteria) this;
        }
        
        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }
        
        public Criteria andTitleNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(title) <>", value.trim().toUpperCase(), PROP_KEY_TITLE);
            return (Criteria) this;
        }
        

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLikeIgnoreCase(String value) {
            addCriterion("UPPER(title) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TITLE);
            return (Criteria) this;
        }
        

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, PROP_KEY_TITLE);
            return (Criteria) this;
        }
        
        public Criteria andTitleNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(title) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TITLE);
            return (Criteria) this;
        }
        

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, PROP_KEY_TITLE);
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualToIgnoreCase(String value) {
            addCriterion("UPPER(author) =", value.trim().toUpperCase(), PROP_KEY_AUTHOR);
            return (Criteria) this;
        }
        
        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }
        
        public Criteria andAuthorNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(author) <>", value.trim().toUpperCase(), PROP_KEY_AUTHOR);
            return (Criteria) this;
        }
        

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorLikeIgnoreCase(String value) {
            addCriterion("UPPER(author) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_AUTHOR);
            return (Criteria) this;
        }
        

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }
        
        public Criteria andAuthorNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(author) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_AUTHOR);
            return (Criteria) this;
        }
        

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, PROP_KEY_AUTHOR);
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualToIgnoreCase(String value) {
            addCriterion("UPPER(edit_time) =", value.trim().toUpperCase(), PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }
        
        public Criteria andEditTimeEqualTo(String value) {
            addCriterion("edit_time =", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(String value) {
            addCriterion("edit_time <>", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }
        
        public Criteria andEditTimeNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(edit_time) <>", value.trim().toUpperCase(), PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }
        

        public Criteria andEditTimeGreaterThan(String value) {
            addCriterion("edit_time >", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(String value) {
            addCriterion("edit_time >=", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(String value) {
            addCriterion("edit_time <", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(String value) {
            addCriterion("edit_time <=", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeLike(String value) {
            addCriterion("edit_time like", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeLikeIgnoreCase(String value) {
            addCriterion("UPPER(edit_time) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }
        

        public Criteria andEditTimeNotLike(String value) {
            addCriterion("edit_time not like", value, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }
        
        public Criteria andEditTimeNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(edit_time) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }
        

        public Criteria andEditTimeIn(List<String> values) {
            addCriterion("edit_time in", values, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<String> values) {
            addCriterion("edit_time not in", values, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(String value1, String value2) {
            addCriterion("edit_time between", value1, value2, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(String value1, String value2) {
            addCriterion("edit_time not between", value1, value2, PROP_KEY_EDIT_TIME);
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualToIgnoreCase(String value) {
            addCriterion("UPPER(description) =", value.trim().toUpperCase(), PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }
        
        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }
        
        public Criteria andDescriptionNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(description) <>", value.trim().toUpperCase(), PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }
        

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeIgnoreCase(String value) {
            addCriterion("UPPER(description) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }
        

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }
        
        public Criteria andDescriptionNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(description) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }
        

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, PROP_KEY_DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andCoverPictureIsNull() {
            addCriterion("cover_picture is null");
            return (Criteria) this;
        }

        public Criteria andCoverPictureIsNotNull() {
            addCriterion("cover_picture is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPictureEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cover_picture) =", value.trim().toUpperCase(), PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }
        
        public Criteria andCoverPictureEqualTo(String value) {
            addCriterion("cover_picture =", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureNotEqualTo(String value) {
            addCriterion("cover_picture <>", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }
        
        public Criteria andCoverPictureNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cover_picture) <>", value.trim().toUpperCase(), PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }
        

        public Criteria andCoverPictureGreaterThan(String value) {
            addCriterion("cover_picture >", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureGreaterThanOrEqualTo(String value) {
            addCriterion("cover_picture >=", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureLessThan(String value) {
            addCriterion("cover_picture <", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureLessThanOrEqualTo(String value) {
            addCriterion("cover_picture <=", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureLike(String value) {
            addCriterion("cover_picture like", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureLikeIgnoreCase(String value) {
            addCriterion("UPPER(cover_picture) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }
        

        public Criteria andCoverPictureNotLike(String value) {
            addCriterion("cover_picture not like", value, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }
        
        public Criteria andCoverPictureNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(cover_picture) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }
        

        public Criteria andCoverPictureIn(List<String> values) {
            addCriterion("cover_picture in", values, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureNotIn(List<String> values) {
            addCriterion("cover_picture not in", values, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureBetween(String value1, String value2) {
            addCriterion("cover_picture between", value1, value2, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andCoverPictureNotBetween(String value1, String value2) {
            addCriterion("cover_picture not between", value1, value2, PROP_KEY_COVER_PICTURE);
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualToIgnoreCase(String value) {
            addCriterion("UPPER(detail) =", value.trim().toUpperCase(), PROP_KEY_DETAIL);
            return (Criteria) this;
        }
        
        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }
        
        public Criteria andDetailNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(detail) <>", value.trim().toUpperCase(), PROP_KEY_DETAIL);
            return (Criteria) this;
        }
        

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailLikeIgnoreCase(String value) {
            addCriterion("UPPER(detail) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_DETAIL);
            return (Criteria) this;
        }
        

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, PROP_KEY_DETAIL);
            return (Criteria) this;
        }
        
        public Criteria andDetailNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(detail) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_DETAIL);
            return (Criteria) this;
        }
        

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, PROP_KEY_DETAIL);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table chinacaipu_other_cookbook_detail
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