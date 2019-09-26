package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>ChinacaipuCookbookDetailQuery</p>
 * @date 2019-08-27 18:14:43
 */
public class ChinacaipuCookbookDetailQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String PROP_KEY_ID = "id";
    
    private static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    private static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    private static final String PROP_KEY_COOKBOOK_URL = "cookbookUrl";
    
    private static final String PROP_KEY_COOKBOOK_NAME = "cookbookName";
    
    private static final String PROP_KEY_TITLE = "title";
    
    private static final String PROP_KEY_COVER_PICTURE = "coverPicture";
    
    private static final String PROP_KEY_DESCRIPTION = "description";
    
    private static final String PROP_KEY_COOK_DIFFICULT = "cookDifficult";
    
    private static final String PROP_KEY_COOK_TIME = "cookTime";
    
    private static final String PROP_KEY_MAIN_INGREDIENTS = "mainIngredients";
    
    private static final String PROP_KEY_SEASONINGS = "seasonings";
    
    private static final String PROP_KEY_STEPS = "steps";
    
    private static final String PROP_KEY_TIPS = "tips";
    
    public ChinacaipuCookbookDetailQuery() {
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
     * This class corresponds to the database table chinacaipu_cookbook_detail
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

        public Criteria andCookDifficultIsNull() {
            addCriterion("cook_difficult is null");
            return (Criteria) this;
        }

        public Criteria andCookDifficultIsNotNull() {
            addCriterion("cook_difficult is not null");
            return (Criteria) this;
        }

        public Criteria andCookDifficultEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cook_difficult) =", value.trim().toUpperCase(), PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }
        
        public Criteria andCookDifficultEqualTo(String value) {
            addCriterion("cook_difficult =", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultNotEqualTo(String value) {
            addCriterion("cook_difficult <>", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }
        
        public Criteria andCookDifficultNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cook_difficult) <>", value.trim().toUpperCase(), PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }
        

        public Criteria andCookDifficultGreaterThan(String value) {
            addCriterion("cook_difficult >", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultGreaterThanOrEqualTo(String value) {
            addCriterion("cook_difficult >=", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultLessThan(String value) {
            addCriterion("cook_difficult <", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultLessThanOrEqualTo(String value) {
            addCriterion("cook_difficult <=", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultLike(String value) {
            addCriterion("cook_difficult like", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultLikeIgnoreCase(String value) {
            addCriterion("UPPER(cook_difficult) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }
        

        public Criteria andCookDifficultNotLike(String value) {
            addCriterion("cook_difficult not like", value, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }
        
        public Criteria andCookDifficultNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(cook_difficult) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }
        

        public Criteria andCookDifficultIn(List<String> values) {
            addCriterion("cook_difficult in", values, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultNotIn(List<String> values) {
            addCriterion("cook_difficult not in", values, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultBetween(String value1, String value2) {
            addCriterion("cook_difficult between", value1, value2, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookDifficultNotBetween(String value1, String value2) {
            addCriterion("cook_difficult not between", value1, value2, PROP_KEY_COOK_DIFFICULT);
            return (Criteria) this;
        }

        public Criteria andCookTimeIsNull() {
            addCriterion("cook_time is null");
            return (Criteria) this;
        }

        public Criteria andCookTimeIsNotNull() {
            addCriterion("cook_time is not null");
            return (Criteria) this;
        }

        public Criteria andCookTimeEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cook_time) =", value.trim().toUpperCase(), PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }
        
        public Criteria andCookTimeEqualTo(String value) {
            addCriterion("cook_time =", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeNotEqualTo(String value) {
            addCriterion("cook_time <>", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }
        
        public Criteria andCookTimeNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(cook_time) <>", value.trim().toUpperCase(), PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }
        

        public Criteria andCookTimeGreaterThan(String value) {
            addCriterion("cook_time >", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeGreaterThanOrEqualTo(String value) {
            addCriterion("cook_time >=", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeLessThan(String value) {
            addCriterion("cook_time <", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeLessThanOrEqualTo(String value) {
            addCriterion("cook_time <=", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeLike(String value) {
            addCriterion("cook_time like", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeLikeIgnoreCase(String value) {
            addCriterion("UPPER(cook_time) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }
        

        public Criteria andCookTimeNotLike(String value) {
            addCriterion("cook_time not like", value, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }
        
        public Criteria andCookTimeNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(cook_time) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }
        

        public Criteria andCookTimeIn(List<String> values) {
            addCriterion("cook_time in", values, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeNotIn(List<String> values) {
            addCriterion("cook_time not in", values, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeBetween(String value1, String value2) {
            addCriterion("cook_time between", value1, value2, PROP_KEY_COOK_TIME);
            return (Criteria) this;
        }

        public Criteria andCookTimeNotBetween(String value1, String value2) {
            addCriterion("cook_time not between", value1, value2, PROP_KEY_COOK_TIME);
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

        public Criteria andSeasoningsIsNull() {
            addCriterion("seasonings is null");
            return (Criteria) this;
        }

        public Criteria andSeasoningsIsNotNull() {
            addCriterion("seasonings is not null");
            return (Criteria) this;
        }

        public Criteria andSeasoningsEqualToIgnoreCase(String value) {
            addCriterion("UPPER(seasonings) =", value.trim().toUpperCase(), PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }
        
        public Criteria andSeasoningsEqualTo(String value) {
            addCriterion("seasonings =", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsNotEqualTo(String value) {
            addCriterion("seasonings <>", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }
        
        public Criteria andSeasoningsNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(seasonings) <>", value.trim().toUpperCase(), PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }
        

        public Criteria andSeasoningsGreaterThan(String value) {
            addCriterion("seasonings >", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsGreaterThanOrEqualTo(String value) {
            addCriterion("seasonings >=", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsLessThan(String value) {
            addCriterion("seasonings <", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsLessThanOrEqualTo(String value) {
            addCriterion("seasonings <=", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsLike(String value) {
            addCriterion("seasonings like", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsLikeIgnoreCase(String value) {
            addCriterion("UPPER(seasonings) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }
        

        public Criteria andSeasoningsNotLike(String value) {
            addCriterion("seasonings not like", value, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }
        
        public Criteria andSeasoningsNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(seasonings) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }
        

        public Criteria andSeasoningsIn(List<String> values) {
            addCriterion("seasonings in", values, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsNotIn(List<String> values) {
            addCriterion("seasonings not in", values, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsBetween(String value1, String value2) {
            addCriterion("seasonings between", value1, value2, PROP_KEY_SEASONINGS);
            return (Criteria) this;
        }

        public Criteria andSeasoningsNotBetween(String value1, String value2) {
            addCriterion("seasonings not between", value1, value2, PROP_KEY_SEASONINGS);
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

        public Criteria andTipsIsNull() {
            addCriterion("tips is null");
            return (Criteria) this;
        }

        public Criteria andTipsIsNotNull() {
            addCriterion("tips is not null");
            return (Criteria) this;
        }

        public Criteria andTipsEqualToIgnoreCase(String value) {
            addCriterion("UPPER(tips) =", value.trim().toUpperCase(), PROP_KEY_TIPS);
            return (Criteria) this;
        }
        
        public Criteria andTipsEqualTo(String value) {
            addCriterion("tips =", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsNotEqualTo(String value) {
            addCriterion("tips <>", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }
        
        public Criteria andTipsNotEqualToIgnoreCase(String value) {
            addCriterion("UPPER(tips) <>", value.trim().toUpperCase(), PROP_KEY_TIPS);
            return (Criteria) this;
        }
        

        public Criteria andTipsGreaterThan(String value) {
            addCriterion("tips >", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThanOrEqualTo(String value) {
            addCriterion("tips >=", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsLessThan(String value) {
            addCriterion("tips <", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsLessThanOrEqualTo(String value) {
            addCriterion("tips <=", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsLike(String value) {
            addCriterion("tips like", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsLikeIgnoreCase(String value) {
            addCriterion("UPPER(tips) like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TIPS);
            return (Criteria) this;
        }
        

        public Criteria andTipsNotLike(String value) {
            addCriterion("tips not like", value, PROP_KEY_TIPS);
            return (Criteria) this;
        }
        
        public Criteria andTipsNotLikeIgnoreCase(String value) {
            addCriterion("UPPER(tips) not like", "%" + value.trim().toUpperCase() + "%", PROP_KEY_TIPS);
            return (Criteria) this;
        }
        

        public Criteria andTipsIn(List<String> values) {
            addCriterion("tips in", values, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsNotIn(List<String> values) {
            addCriterion("tips not in", values, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsBetween(String value1, String value2) {
            addCriterion("tips between", value1, value2, PROP_KEY_TIPS);
            return (Criteria) this;
        }

        public Criteria andTipsNotBetween(String value1, String value2) {
            addCriterion("tips not between", value1, value2, PROP_KEY_TIPS);
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table chinacaipu_cookbook_detail
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