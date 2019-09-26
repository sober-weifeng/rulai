package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>MeishijieCookbookDetailQuery</p>
 * @date 2019-09-18 10:12:03
 */
public class MeishijieCookbookDetailQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PROP_KEY_ID = "id";
    
    public static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    public static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    public static final String PROP_KEY_COOKBOOK_URL = "cookbookUrl";
    
    public static final String PROP_KEY_COOKBOOK_NAME = "cookbookName";
    
    public static final String PROP_KEY_TITLE = "title";
    
    public static final String PROP_KEY_COVER_PICTURE = "coverPicture";
    
    public static final String PROP_KEY_TECHNOLOGY = "technology";
    
    public static final String PROP_KEY_DIFFICULTY = "difficulty";
    
    public static final String PROP_KEY_NUMBEROFPEOPLE = "numberofpeople";
    
    public static final String PROP_KEY_TASTE = "taste";
    
    public static final String PROP_KEY_SETUPTIME = "setuptime";
    
    public static final String PROP_KEY_COOKTIME = "cooktime";
    
    public static final String PROP_KEY_DESCRIPTION = "description";
    
    public static final String PROP_KEY_MAIN_INGREDIENTS = "mainIngredients";
    
    public static final String PROP_KEY_SUP_INGREDIENTS = "supIngredients";
    
    public static final String PROP_KEY_STEPS = "steps";
    
    public static final String PROP_KEY_TIP = "tip";
    
    public MeishijieCookbookDetailQuery() {
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
     * This class corresponds to the database table meishijie_cookbook_detail
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

        public Criteria andTechnologyIsNull() {
            addCriterion("technology is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyIsNotNull() {
            addCriterion("technology is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyEqualToIgnoreCase(String value) {
            addCriterion("UPPER(technology) =", value.trim().toUpperCase(), PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }
        
        public Criteria andTechnologyEqualTo(String value) {
            addCriterion("technology =", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyNotEqualTo(String value) {
            addCriterion("technology <>", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }
        
        public Criteria andTechnologyNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(technology) <>", value.trim().toUpperCase(), PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }
        

        public Criteria andTechnologyGreaterThan(String value) {
            addCriterion("technology >", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyGreaterThanOrEqualTo(String value) {
            addCriterion("technology >=", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyLessThan(String value) {
            addCriterion("technology <", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyLessThanOrEqualTo(String value) {
            addCriterion("technology <=", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyLike(String value) {
            addCriterion("technology like", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyLikeIgnoreCase(String value) {
            addCriterion("UPPER(technology) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }
        

        public Criteria andTechnologyNotLike(String value) {
            addCriterion("technology not like", value, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }
        
        public Criteria andTechnologyNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(technology) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }
        

        public Criteria andTechnologyIn(List<String> values) {
            addCriterion("technology in", values, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyNotIn(List<String> values) {
            addCriterion("technology not in", values, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyBetween(String value1, String value2) {
            addCriterion("technology between", value1, value2, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andTechnologyNotBetween(String value1, String value2) {
            addCriterion("technology not between", value1, value2, PROP_KEY_TECHNOLOGY);
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualToIgnoreCase(String value) {
            addCriterion("UPPER(difficulty) =", value.trim().toUpperCase(), PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }
        
        public Criteria andDifficultyEqualTo(String value) {
            addCriterion("difficulty =", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(String value) {
            addCriterion("difficulty <>", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }
        
        public Criteria andDifficultyNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(difficulty) <>", value.trim().toUpperCase(), PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }
        

        public Criteria andDifficultyGreaterThan(String value) {
            addCriterion("difficulty >", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(String value) {
            addCriterion("difficulty >=", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(String value) {
            addCriterion("difficulty <", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(String value) {
            addCriterion("difficulty <=", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyLike(String value) {
            addCriterion("difficulty like", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyLikeIgnoreCase(String value) {
            addCriterion("UPPER(difficulty) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }
        

        public Criteria andDifficultyNotLike(String value) {
            addCriterion("difficulty not like", value, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }
        
        public Criteria andDifficultyNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(difficulty) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }
        

        public Criteria andDifficultyIn(List<String> values) {
            addCriterion("difficulty in", values, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<String> values) {
            addCriterion("difficulty not in", values, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(String value1, String value2) {
            addCriterion("difficulty between", value1, value2, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(String value1, String value2) {
            addCriterion("difficulty not between", value1, value2, PROP_KEY_DIFFICULTY);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleIsNull() {
            addCriterion("numberofpeople is null");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleIsNotNull() {
            addCriterion("numberofpeople is not null");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleEqualToIgnoreCase(String value) {
            addCriterion("UPPER(numberofpeople) =", value.trim().toUpperCase(), PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }
        
        public Criteria andNumberofpeopleEqualTo(String value) {
            addCriterion("numberofpeople =", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleNotEqualTo(String value) {
            addCriterion("numberofpeople <>", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }
        
        public Criteria andNumberofpeopleNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(numberofpeople) <>", value.trim().toUpperCase(), PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }
        

        public Criteria andNumberofpeopleGreaterThan(String value) {
            addCriterion("numberofpeople >", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("numberofpeople >=", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleLessThan(String value) {
            addCriterion("numberofpeople <", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleLessThanOrEqualTo(String value) {
            addCriterion("numberofpeople <=", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleLike(String value) {
            addCriterion("numberofpeople like", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleLikeIgnoreCase(String value) {
            addCriterion("UPPER(numberofpeople) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }
        

        public Criteria andNumberofpeopleNotLike(String value) {
            addCriterion("numberofpeople not like", value, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }
        
        public Criteria andNumberofpeopleNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(numberofpeople) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }
        

        public Criteria andNumberofpeopleIn(List<String> values) {
            addCriterion("numberofpeople in", values, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleNotIn(List<String> values) {
            addCriterion("numberofpeople not in", values, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleBetween(String value1, String value2) {
            addCriterion("numberofpeople between", value1, value2, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleNotBetween(String value1, String value2) {
            addCriterion("numberofpeople not between", value1, value2, PROP_KEY_NUMBEROFPEOPLE);
            return (Criteria) this;
        }

        public Criteria andTasteIsNull() {
            addCriterion("taste is null");
            return (Criteria) this;
        }

        public Criteria andTasteIsNotNull() {
            addCriterion("taste is not null");
            return (Criteria) this;
        }

        public Criteria andTasteEqualToIgnoreCase(String value) {
            addCriterion("UPPER(taste) =", value.trim().toUpperCase(), PROP_KEY_TASTE);
            return (Criteria) this;
        }
        
        public Criteria andTasteEqualTo(String value) {
            addCriterion("taste =", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteNotEqualTo(String value) {
            addCriterion("taste <>", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }
        
        public Criteria andTasteNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(taste) <>", value.trim().toUpperCase(), PROP_KEY_TASTE);
            return (Criteria) this;
        }
        

        public Criteria andTasteGreaterThan(String value) {
            addCriterion("taste >", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteGreaterThanOrEqualTo(String value) {
            addCriterion("taste >=", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteLessThan(String value) {
            addCriterion("taste <", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteLessThanOrEqualTo(String value) {
            addCriterion("taste <=", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteLike(String value) {
            addCriterion("taste like", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteLikeIgnoreCase(String value) {
            addCriterion("UPPER(taste) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TASTE);
            return (Criteria) this;
        }
        

        public Criteria andTasteNotLike(String value) {
            addCriterion("taste not like", value, PROP_KEY_TASTE);
            return (Criteria) this;
        }
        
        public Criteria andTasteNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(taste) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TASTE);
            return (Criteria) this;
        }
        

        public Criteria andTasteIn(List<String> values) {
            addCriterion("taste in", values, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteNotIn(List<String> values) {
            addCriterion("taste not in", values, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteBetween(String value1, String value2) {
            addCriterion("taste between", value1, value2, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andTasteNotBetween(String value1, String value2) {
            addCriterion("taste not between", value1, value2, PROP_KEY_TASTE);
            return (Criteria) this;
        }

        public Criteria andSetuptimeIsNull() {
            addCriterion("setuptime is null");
            return (Criteria) this;
        }

        public Criteria andSetuptimeIsNotNull() {
            addCriterion("setuptime is not null");
            return (Criteria) this;
        }

        public Criteria andSetuptimeEqualToIgnoreCase(String value) {
            addCriterion("UPPER(setuptime) =", value.trim().toUpperCase(), PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }
        
        public Criteria andSetuptimeEqualTo(String value) {
            addCriterion("setuptime =", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeNotEqualTo(String value) {
            addCriterion("setuptime <>", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }
        
        public Criteria andSetuptimeNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(setuptime) <>", value.trim().toUpperCase(), PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }
        

        public Criteria andSetuptimeGreaterThan(String value) {
            addCriterion("setuptime >", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeGreaterThanOrEqualTo(String value) {
            addCriterion("setuptime >=", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeLessThan(String value) {
            addCriterion("setuptime <", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeLessThanOrEqualTo(String value) {
            addCriterion("setuptime <=", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeLike(String value) {
            addCriterion("setuptime like", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeLikeIgnoreCase(String value) {
            addCriterion("UPPER(setuptime) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }
        

        public Criteria andSetuptimeNotLike(String value) {
            addCriterion("setuptime not like", value, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }
        
        public Criteria andSetuptimeNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(setuptime) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }
        

        public Criteria andSetuptimeIn(List<String> values) {
            addCriterion("setuptime in", values, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeNotIn(List<String> values) {
            addCriterion("setuptime not in", values, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeBetween(String value1, String value2) {
            addCriterion("setuptime between", value1, value2, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andSetuptimeNotBetween(String value1, String value2) {
            addCriterion("setuptime not between", value1, value2, PROP_KEY_SETUPTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeIsNull() {
            addCriterion("cooktime is null");
            return (Criteria) this;
        }

        public Criteria andCooktimeIsNotNull() {
            addCriterion("cooktime is not null");
            return (Criteria) this;
        }

        public Criteria andCooktimeEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cooktime) =", value.trim().toUpperCase(), PROP_KEY_COOKTIME);
            return (Criteria) this;
        }
        
        public Criteria andCooktimeEqualTo(String value) {
            addCriterion("cooktime =", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeNotEqualTo(String value) {
            addCriterion("cooktime <>", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }
        
        public Criteria andCooktimeNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cooktime) <>", value.trim().toUpperCase(), PROP_KEY_COOKTIME);
            return (Criteria) this;
        }
        

        public Criteria andCooktimeGreaterThan(String value) {
            addCriterion("cooktime >", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeGreaterThanOrEqualTo(String value) {
            addCriterion("cooktime >=", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeLessThan(String value) {
            addCriterion("cooktime <", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeLessThanOrEqualTo(String value) {
            addCriterion("cooktime <=", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeLike(String value) {
            addCriterion("cooktime like", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeLikeIgnoreCase(String value) {
            addCriterion("UPPER(cooktime) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOKTIME);
            return (Criteria) this;
        }
        

        public Criteria andCooktimeNotLike(String value) {
            addCriterion("cooktime not like", value, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }
        
        public Criteria andCooktimeNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(cooktime) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOKTIME);
            return (Criteria) this;
        }
        

        public Criteria andCooktimeIn(List<String> values) {
            addCriterion("cooktime in", values, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeNotIn(List<String> values) {
            addCriterion("cooktime not in", values, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeBetween(String value1, String value2) {
            addCriterion("cooktime between", value1, value2, PROP_KEY_COOKTIME);
            return (Criteria) this;
        }

        public Criteria andCooktimeNotBetween(String value1, String value2) {
            addCriterion("cooktime not between", value1, value2, PROP_KEY_COOKTIME);
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

        public Criteria andMainIngredientsIsNull() {
            addCriterion("main_ingredients is null");
            return (Criteria) this;
        }

        public Criteria andMainIngredientsIsNotNull() {
            addCriterion("main_ingredients is not null");
            return (Criteria) this;
        }

        public Criteria andMainIngredientsEqualToIgnoreCase(String value) {
            addCriterion("UPPER(main_ingredients) =", value.trim().toUpperCase(), PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andMainIngredientsEqualTo(String value) {
            addCriterion("main_ingredients =", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsNotEqualTo(String value) {
            addCriterion("main_ingredients <>", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andMainIngredientsNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(main_ingredients) <>", value.trim().toUpperCase(), PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andMainIngredientsGreaterThan(String value) {
            addCriterion("main_ingredients >", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsGreaterThanOrEqualTo(String value) {
            addCriterion("main_ingredients >=", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsLessThan(String value) {
            addCriterion("main_ingredients <", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsLessThanOrEqualTo(String value) {
            addCriterion("main_ingredients <=", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsLike(String value) {
            addCriterion("main_ingredients like", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsLikeIgnoreCase(String value) {
            addCriterion("UPPER(main_ingredients) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andMainIngredientsNotLike(String value) {
            addCriterion("main_ingredients not like", value, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andMainIngredientsNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(main_ingredients) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andMainIngredientsIn(List<String> values) {
            addCriterion("main_ingredients in", values, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsNotIn(List<String> values) {
            addCriterion("main_ingredients not in", values, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsBetween(String value1, String value2) {
            addCriterion("main_ingredients between", value1, value2, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andMainIngredientsNotBetween(String value1, String value2) {
            addCriterion("main_ingredients not between", value1, value2, PROP_KEY_MAIN_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsIsNull() {
            addCriterion("sup_ingredients is null");
            return (Criteria) this;
        }

        public Criteria andSupIngredientsIsNotNull() {
            addCriterion("sup_ingredients is not null");
            return (Criteria) this;
        }

        public Criteria andSupIngredientsEqualToIgnoreCase(String value) {
            addCriterion("UPPER(sup_ingredients) =", value.trim().toUpperCase(), PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andSupIngredientsEqualTo(String value) {
            addCriterion("sup_ingredients =", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsNotEqualTo(String value) {
            addCriterion("sup_ingredients <>", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andSupIngredientsNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(sup_ingredients) <>", value.trim().toUpperCase(), PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andSupIngredientsGreaterThan(String value) {
            addCriterion("sup_ingredients >", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsGreaterThanOrEqualTo(String value) {
            addCriterion("sup_ingredients >=", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsLessThan(String value) {
            addCriterion("sup_ingredients <", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsLessThanOrEqualTo(String value) {
            addCriterion("sup_ingredients <=", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsLike(String value) {
            addCriterion("sup_ingredients like", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsLikeIgnoreCase(String value) {
            addCriterion("UPPER(sup_ingredients) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andSupIngredientsNotLike(String value) {
            addCriterion("sup_ingredients not like", value, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andSupIngredientsNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(sup_ingredients) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andSupIngredientsIn(List<String> values) {
            addCriterion("sup_ingredients in", values, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsNotIn(List<String> values) {
            addCriterion("sup_ingredients not in", values, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsBetween(String value1, String value2) {
            addCriterion("sup_ingredients between", value1, value2, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andSupIngredientsNotBetween(String value1, String value2) {
            addCriterion("sup_ingredients not between", value1, value2, PROP_KEY_SUP_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andStepsIsNull() {
            addCriterion("steps is null");
            return (Criteria) this;
        }

        public Criteria andStepsIsNotNull() {
            addCriterion("steps is not null");
            return (Criteria) this;
        }

        public Criteria andStepsEqualToIgnoreCase(String value) {
            addCriterion("UPPER(steps) =", value.trim().toUpperCase(), PROP_KEY_STEPS);
            return (Criteria) this;
        }
        
        public Criteria andStepsEqualTo(String value) {
            addCriterion("steps =", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsNotEqualTo(String value) {
            addCriterion("steps <>", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }
        
        public Criteria andStepsNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(steps) <>", value.trim().toUpperCase(), PROP_KEY_STEPS);
            return (Criteria) this;
        }
        

        public Criteria andStepsGreaterThan(String value) {
            addCriterion("steps >", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsGreaterThanOrEqualTo(String value) {
            addCriterion("steps >=", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsLessThan(String value) {
            addCriterion("steps <", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsLessThanOrEqualTo(String value) {
            addCriterion("steps <=", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsLike(String value) {
            addCriterion("steps like", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsLikeIgnoreCase(String value) {
            addCriterion("UPPER(steps) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_STEPS);
            return (Criteria) this;
        }
        

        public Criteria andStepsNotLike(String value) {
            addCriterion("steps not like", value, PROP_KEY_STEPS);
            return (Criteria) this;
        }
        
        public Criteria andStepsNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(steps) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_STEPS);
            return (Criteria) this;
        }
        

        public Criteria andStepsIn(List<String> values) {
            addCriterion("steps in", values, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsNotIn(List<String> values) {
            addCriterion("steps not in", values, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsBetween(String value1, String value2) {
            addCriterion("steps between", value1, value2, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andStepsNotBetween(String value1, String value2) {
            addCriterion("steps not between", value1, value2, PROP_KEY_STEPS);
            return (Criteria) this;
        }

        public Criteria andTipIsNull() {
            addCriterion("tip is null");
            return (Criteria) this;
        }

        public Criteria andTipIsNotNull() {
            addCriterion("tip is not null");
            return (Criteria) this;
        }

        public Criteria andTipEqualToIgnoreCase(String value) {
            addCriterion("UPPER(tip) =", value.trim().toUpperCase(), PROP_KEY_TIP);
            return (Criteria) this;
        }
        
        public Criteria andTipEqualTo(String value) {
            addCriterion("tip =", value, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipNotEqualTo(String value) {
            addCriterion("tip <>", value, PROP_KEY_TIP);
            return (Criteria) this;
        }
        
        public Criteria andTipNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(tip) <>", value.trim().toUpperCase(), PROP_KEY_TIP);
            return (Criteria) this;
        }
        

        public Criteria andTipGreaterThan(String value) {
            addCriterion("tip >", value, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipGreaterThanOrEqualTo(String value) {
            addCriterion("tip >=", value, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipLessThan(String value) {
            addCriterion("tip <", value, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipLessThanOrEqualTo(String value) {
            addCriterion("tip <=", value, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipLike(String value) {
            addCriterion("tip like", value, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipLikeIgnoreCase(String value) {
            addCriterion("UPPER(tip) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TIP);
            return (Criteria) this;
        }
        

        public Criteria andTipNotLike(String value) {
            addCriterion("tip not like", value, PROP_KEY_TIP);
            return (Criteria) this;
        }
        
        public Criteria andTipNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(tip) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TIP);
            return (Criteria) this;
        }
        

        public Criteria andTipIn(List<String> values) {
            addCriterion("tip in", values, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipNotIn(List<String> values) {
            addCriterion("tip not in", values, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipBetween(String value1, String value2) {
            addCriterion("tip between", value1, value2, PROP_KEY_TIP);
            return (Criteria) this;
        }

        public Criteria andTipNotBetween(String value1, String value2) {
            addCriterion("tip not between", value1, value2, PROP_KEY_TIP);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table meishijie_cookbook_detail
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