package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>XiachufangCookbookDetailQuery</p>
 * @date 2019-09-17 10:06:12
 */
public class XiachufangCookbookDetailQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PROP_KEY_ID = "id";
    
    public static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    public static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    public static final String PROP_KEY_COOKBOOK_URL_ID = "cookbookUrlId";
    
    public static final String PROP_KEY_TITLE = "title";
    
    public static final String PROP_KEY_COVER_PICTURE = "coverPicture";
    
    public static final String PROP_KEY_INGREDIENTS = "ingredients";
    
    public static final String PROP_KEY_STEPS = "steps";
    
    public static final String PROP_KEY_TIP = "tip";
    
    public XiachufangCookbookDetailQuery() {
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
     * This class corresponds to the database table xiachufang_cookbook_detail
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

        public Criteria andIngredientsIsNull() {
            addCriterion("ingredients is null");
            return (Criteria) this;
        }

        public Criteria andIngredientsIsNotNull() {
            addCriterion("ingredients is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientsEqualToIgnoreCase(String value) {
            addCriterion("UPPER(ingredients) =", value.trim().toUpperCase(), PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andIngredientsEqualTo(String value) {
            addCriterion("ingredients =", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsNotEqualTo(String value) {
            addCriterion("ingredients <>", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andIngredientsNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(ingredients) <>", value.trim().toUpperCase(), PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andIngredientsGreaterThan(String value) {
            addCriterion("ingredients >", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsGreaterThanOrEqualTo(String value) {
            addCriterion("ingredients >=", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsLessThan(String value) {
            addCriterion("ingredients <", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsLessThanOrEqualTo(String value) {
            addCriterion("ingredients <=", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsLike(String value) {
            addCriterion("ingredients like", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsLikeIgnoreCase(String value) {
            addCriterion("UPPER(ingredients) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andIngredientsNotLike(String value) {
            addCriterion("ingredients not like", value, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }
        
        public Criteria andIngredientsNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(ingredients) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }
        

        public Criteria andIngredientsIn(List<String> values) {
            addCriterion("ingredients in", values, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsNotIn(List<String> values) {
            addCriterion("ingredients not in", values, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsBetween(String value1, String value2) {
            addCriterion("ingredients between", value1, value2, PROP_KEY_INGREDIENTS);
            return (Criteria) this;
        }

        public Criteria andIngredientsNotBetween(String value1, String value2) {
            addCriterion("ingredients not between", value1, value2, PROP_KEY_INGREDIENTS);
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
     * This class corresponds to the database table xiachufang_cookbook_detail
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