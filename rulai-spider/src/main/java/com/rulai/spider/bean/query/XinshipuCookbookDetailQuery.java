package com.rulai.spider.bean.query;

import com.rulai.common.component.BaseQuery;
import com.rulai.common.component.BaseCriteria;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>XinshipuCookbookDetailQuery</p>
 * @date 2019-09-11 15:39:30
 */
public class XinshipuCookbookDetailQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PROP_KEY_ID = "id";
    
    public static final String PROP_KEY_GMT_CREATE = "gmtCreate";
    
    public static final String PROP_KEY_GMT_UPDATE = "gmtUpdate";
    
    public static final String PROP_KEY_COOKBOOK_URL = "cookbookUrl";
    
    public static final String PROP_KEY_COOKBOOK_NAME = "cookbookName";
    
    public static final String PROP_KEY_TITLE = "title";
    
    public static final String PROP_KEY_COVER_PICTURE = "coverPicture";
    
    public static final String PROP_KEY_DESCRIPTION = "description";
    
    public static final String PROP_KEY_INGREDIENTS = "ingredients";
    
    public static final String PROP_KEY_STEPS = "steps";
    
    public static final String PROP_KEY_TIP = "tip";
    
    public XinshipuCookbookDetailQuery() {
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
     * This class corresponds to the database table xinshipu_cookbook_detail
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
     * This class corresponds to the database table xinshipu_cookbook_detail
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