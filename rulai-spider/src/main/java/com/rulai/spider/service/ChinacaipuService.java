package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.chinacaipu.CookbookListPage;
import com.rulai.spider.bean.crawl.chinacaipu.OriginalCookbookDetailPage;
import com.rulai.spider.bean.crawl.chinacaipu.OtherCookbookDetailPage;
import com.rulai.spider.bean.crawl.chinacaipu.TopCategoryPage;
import com.rulai.spider.bean.model.*;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/27 18:13
 */
@Component
@Slf4j
public class ChinacaipuService {
    
    @Autowired
    private ChinacaipuTopCategoryManager chinacaipuTopCategoryManager;
    
    @Autowired
    private ChinacaipuSecondCategoryManager chinacaipuSecondCategoryManager;
    
    @Autowired
    private ChinacaipuCookbookUrlManager chinacaipuCookbookUrlManager;
    
    @Autowired
    private ChinacaipuCategoryCookbookRelationManager relationManager;
    
    @Autowired
    private ChinacaipuCookbookDetailManager chinacaipuCookbookDetailManager;
    
    @Autowired
    private ChinacaipuOtherCookbookDetailManager chinacaipuOtherCookbookDetailManager;
    
    public BizResult crawlTopCategoryPage() {
        BizResult result = BizResult.custom();
        try {
            WebClient webClient = HtmlUnitHelper.getWebClient();
            TopCategoryPage topCategoryPage = TopCategoryPage.crawlTopCategoryPage(webClient);
            webClient.close();
            if (null == topCategoryPage) {
                return result.success("未爬取到内容");
            }
            for (TopCategoryPage.TopCategory topCategory : topCategoryPage.getTopCategories()) {
                ChinacaipuTopCategoryDO topCategoryDO = new ChinacaipuTopCategoryDO();
                topCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                topCategoryDO.setCategoryName(topCategory.getCategoryName());
                topCategoryDO.setCategoryUrl(topCategory.getCategoryUrl());
                ChinacaipuTopCategoryDO currentTopDO = chinacaipuTopCategoryManager.selectByCategoryUrl(topCategory.getCategoryUrl());
                if (null != currentTopDO) {
                    topCategoryDO.setId(currentTopDO.getId());
                    if (!currentTopDO.getCategoryName().equals(topCategory.getCategoryName())) {
                        chinacaipuTopCategoryManager.updateByPrimaryKeySelective(topCategoryDO);
                    }
                } else {
                    chinacaipuTopCategoryManager.insertSelective(topCategoryDO);
                }
                for (TopCategoryPage.SecondCategory secondCategory : topCategory.getSecondCategories()) {
                    ChinacaipuSecondCategoryDO chinacaipuSecondCategoryDO = new ChinacaipuSecondCategoryDO();
                    chinacaipuSecondCategoryDO.setTopCategoryId(topCategoryDO.getId());
                    chinacaipuSecondCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                    chinacaipuSecondCategoryDO.setCategoryName(secondCategory.getCategoryName());
                    chinacaipuSecondCategoryDO.setCategoryUrl(secondCategory.getCategoryUrl());
                    ChinacaipuSecondCategoryDO currentSecondDO = chinacaipuSecondCategoryManager.selectByCategoryUrl(secondCategory.getCategoryUrl());
                    if (null != currentSecondDO) {
                        if (!(currentSecondDO.getCategoryName().equals(chinacaipuSecondCategoryDO.getCategoryName()) 
                                && currentSecondDO.getTopCategoryId().equals(chinacaipuSecondCategoryDO.getTopCategoryId()))) {
                            chinacaipuSecondCategoryDO.setId(currentSecondDO.getId());
                            chinacaipuSecondCategoryManager.updateByPrimaryKeySelective(chinacaipuSecondCategoryDO);
                        }
                    } else {
                        chinacaipuSecondCategoryManager.insertSelective(chinacaipuSecondCategoryDO);
                    }
                }
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlSecondCookbookListPage() {
        BizResult result = BizResult.custom();
        try {
            List<ChinacaipuSecondCategoryDO> secondCategoryDOS = chinacaipuSecondCategoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(secondCategoryDOS)) {
                return result.success("没有未爬取的二级分类页面");
            }
            WebClient webClient = HtmlUnitHelper.getWebClient();
            for (ChinacaipuSecondCategoryDO secondCategoryDO : secondCategoryDOS) {
                String categoryUrl = secondCategoryDO.getCategoryUrl();
                try {
                    CookbookListPage cookbookListPage = CookbookListPage.crawlCookbookListPage(categoryUrl, webClient);
                    if (null == cookbookListPage) {
                        return result.success("未爬取到内容");
                    }
                    for (CookbookListPage.CookbookUrl cookbookUrl : cookbookListPage.getCookbookUrls()) {
                        try {
                            ChinacaipuCookbookUrlDO chinacaipuCookbookUrlDO = new ChinacaipuCookbookUrlDO();
                            chinacaipuCookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                            chinacaipuCookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                            chinacaipuCookbookUrlDO.setCookbookUrl(cookbookUrl.getCookbookUrl());
                            chinacaipuCookbookUrlDO.setSecondLocationUrl(cookbookUrl.getLocationUrl());
                            ChinacaipuCookbookUrlDO currentCookbookUrlDO = chinacaipuCookbookUrlManager.selectByCookbookUrl(cookbookUrl.getCookbookUrl());
                            if (null != currentCookbookUrlDO) {
                                chinacaipuCookbookUrlDO.setId(currentCookbookUrlDO.getId());
                                if (IsEffectiveEnum.YES.getCode() != currentCookbookUrlDO.getIsEffective().intValue()) {
                                    log.info("该页面无效，不更新数据：{}", cookbookUrl.getCookbookUrl());
                                } else {
                                    if (!(currentCookbookUrlDO.getCookbookName().equals(chinacaipuCookbookUrlDO.getCookbookName())
                                            && chinacaipuCookbookUrlDO.getSecondLocationUrl().equals(currentCookbookUrlDO.getSecondLocationUrl()))) {
                                        chinacaipuCookbookUrlManager.updateByPrimaryKeySelective(chinacaipuCookbookUrlDO);
                                    }
                                }
                            } else {
                                chinacaipuCookbookUrlManager.insertSelective(chinacaipuCookbookUrlDO);
                            }
                            if (relationManager.countByCookbookUrlIdAndSecondCategoryId(chinacaipuCookbookUrlDO.getId(), secondCategoryDO.getId()) == 0) {
                                ChinacaipuCategoryCookbookRelationDO relationDO = new ChinacaipuCategoryCookbookRelationDO();
                                relationDO.setSecondCategoryId(secondCategoryDO.getId());
                                relationDO.setCookbookUrlId(chinacaipuCookbookUrlDO.getId());
                                relationManager.insertSelective(relationDO);
                            }
                        } catch (Exception e) {
                            log.error("该页面数据存储异常：{}", cookbookUrl.getCookbookUrl());
                            log.error(e.getMessage(), e);
                        }
                    }
                    secondCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                    chinacaipuSecondCategoryManager.updateByPrimaryKeySelective(secondCategoryDO);
                } catch (Exception e) {
                    log.error("爬取页面异常：{}", categoryUrl);
                    log.error(e.getMessage(), e);
                }
            }
            webClient.close();
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlTopCookbookListPage() {
        BizResult result = BizResult.custom();
        try {
            List<ChinacaipuTopCategoryDO> topCategoryDOS = chinacaipuTopCategoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(topCategoryDOS)) {
                return result.success("无未爬取顶级分类页面");
            }
            WebClient webClient = HtmlUnitHelper.getWebClient();
            for (ChinacaipuTopCategoryDO topCategoryDO : topCategoryDOS) {
                String categoryUrl = topCategoryDO.getCategoryUrl();
                boolean isGoOn = true;
                boolean isSuccess = false;
                while (isGoOn) {
                    try {
                        log.info("爬取食谱列表页：{}", categoryUrl);
                        HtmlPage page = webClient.getPage(categoryUrl);
                        int responseCode = page.getWebResponse().getStatusCode();
                        if (200 != responseCode) {
                            log.error("获取页面不正确，code：{}，url：{}", responseCode, categoryUrl);
                            continue;
                        }
                        List<CookbookListPage.CookbookUrl> cookbookUrls = Lists.newArrayList();
                        List<HtmlElement> contentElements = page.getByXPath("//ul[@class='c_conlist']/li");
                        if (CollectionUtils.isEmpty(contentElements)) {
                            log.error("无解析//ul[@class='c_conlist']/li内容");
                        } else {
                            CookbookListPage.CookbookUrl item;
                            for (HtmlElement contentElement : contentElements) {
                                List<HtmlElement> titleElements = contentElement.getElementsByTagName("strong");
                                if (CollectionUtils.isEmpty(titleElements)) {
                                    titleElements = contentElement.getElementsByTagName("h3");
                                }
                                HtmlElement titleElement = titleElements.get(0).getElementsByTagName("a").get(0);
                                item = new CookbookListPage.CookbookUrl();
                                item.setCookbookName(titleElement.asText());
                                String cookbookUrl = titleElement.getAttribute("href");
                                if (!cookbookUrl.startsWith(CookbookListPage.PREFIX)) {
                                    cookbookUrl = CookbookListPage.PREFIX.concat(cookbookUrl);
                                }
                                item.setCookbookUrl(cookbookUrl);
                                item.setLocationUrl(categoryUrl);
                                cookbookUrls.add(item);
                            }
                        }
                        for (CookbookListPage.CookbookUrl cookbookUrl : cookbookUrls) {
                            try {
                                ChinacaipuCookbookUrlDO chinacaipuCookbookUrlDO = new ChinacaipuCookbookUrlDO();
                                chinacaipuCookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                chinacaipuCookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                chinacaipuCookbookUrlDO.setCookbookUrl(cookbookUrl.getCookbookUrl());
                                chinacaipuCookbookUrlDO.setTopLocationUrl(cookbookUrl.getLocationUrl());
                                chinacaipuCookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                ChinacaipuCookbookUrlDO currentCookbookUrlDO = chinacaipuCookbookUrlManager.selectByCookbookUrl(cookbookUrl.getCookbookUrl());
                                if (null != currentCookbookUrlDO) {
                                    chinacaipuCookbookUrlDO.setId(currentCookbookUrlDO.getId());
                                    if (IsEffectiveEnum.YES.getCode() != currentCookbookUrlDO.getIsEffective().intValue()) {
                                        log.info("该页面无效：{}", cookbookUrl.getCookbookUrl());
                                    } else {
                                        if (!(currentCookbookUrlDO.getCookbookName().equals(chinacaipuCookbookUrlDO.getCookbookName())
                                                && chinacaipuCookbookUrlDO.getTopLocationUrl().equals(currentCookbookUrlDO.getTopLocationUrl()))) {
                                            chinacaipuCookbookUrlManager.updateByPrimaryKeySelective(chinacaipuCookbookUrlDO);
                                        }
                                    }
                                } else {
                                    chinacaipuCookbookUrlManager.insertSelective(chinacaipuCookbookUrlDO);
                                }
                                if (relationManager.countByCookbookUrlIdAndTopCategoryId(chinacaipuCookbookUrlDO.getId(), topCategoryDO.getId()) == 0) {
                                    ChinacaipuCategoryCookbookRelationDO relationDO = new ChinacaipuCategoryCookbookRelationDO();
                                    relationDO.setTopCategoryId(topCategoryDO.getId());
                                    relationDO.setCookbookUrlId(chinacaipuCookbookUrlDO.getId());
                                    relationManager.insertSelective(relationDO);
                                }
                            } catch (Exception e) {
                                log.error("该页面数据存储异常：{}", cookbookUrl.getCookbookUrl());
                                log.error(e.getMessage(), e);
                            }
                        }

                        List<HtmlElement> paginationElements = page.getByXPath("//div[@class='page']//a");
                        if (CollectionUtils.isEmpty(paginationElements)) {
                            log.info("无分页//div[@class='page']//a解析内容");
                            isGoOn = false;
                            isSuccess = true;
                            continue;
                        }
                        HtmlElement nextPageElement = paginationElements.get(paginationElements.size() - 1);
                        String title = nextPageElement.getAttribute("title");
                        if (!"上一页".equals(title)) {
                            isSuccess = true;
                            isGoOn = false;
                            continue;
                        }
                        categoryUrl = CookbookListPage.PREFIX.concat(nextPageElement.getAttribute("href"));
                    } catch (Exception e) {
                        log.error("爬取页面异常：{}", categoryUrl);
                        log.error(e.getMessage(), e);
                        isGoOn = false;
                        isSuccess = false;
                    }
                }
                if (isSuccess && !isGoOn) {
                    topCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                    chinacaipuTopCategoryManager.updateByPrimaryKeySelective(topCategoryDO);
                }
            }
            webClient.close();
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlOriginalCookbookDetailPage() {
        BizResult result = BizResult.custom();
        try {
            List<ChinacaipuCookbookUrlDO> originalCookbookUrlDOS = chinacaipuCookbookUrlManager.selectOriginalNotCrawled();
            if (CollectionUtils.isEmpty(originalCookbookUrlDOS)) {
                return result.success("无未爬取标准菜谱明细页面");
            }
            WebClient webClient = HtmlUnitHelper.getWebClient();
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
            for (ChinacaipuCookbookUrlDO originalCookbookUrlDO : originalCookbookUrlDOS) {
                fixedThreadPool.submit(() -> {
                    String cookbookUrl = originalCookbookUrlDO.getCookbookUrl();
                    try {
                        OriginalCookbookDetailPage cookbookDetailPage =
                                OriginalCookbookDetailPage.crawlOriginalCookbookDetailPage(cookbookUrl, webClient);
                        if (null == cookbookDetailPage) {
                            log.error("爬取页面内容失败：{}", cookbookUrl);
                            originalCookbookUrlDO.setIsEffective(IsEffectiveEnum.NO.getCode());
                            chinacaipuCookbookUrlManager.updateByPrimaryKeySelective(originalCookbookUrlDO);
                            return;
                        }
                        OriginalCookbookDetailPage.OriginalCookbookDetail cookbookDetail = cookbookDetailPage.getOriginalCookbookDetail();
                        ChinacaipuCookbookDetailDO cookbookDetailDO = new ChinacaipuCookbookDetailDO();
                        cookbookDetailDO.setCookbookUrl(cookbookUrl);
                        cookbookDetailDO.setCookbookName(originalCookbookUrlDO.getCookbookName());
                        cookbookDetailDO.setTitle(cookbookDetail.getTitle());
                        cookbookDetailDO.setCoverPicture(cookbookDetail.getCoverPicture());
                        cookbookDetailDO.setDescription(cookbookDetail.getDescription());
                        cookbookDetailDO.setCookDifficult(cookbookDetail.getCookDifficult());
                        cookbookDetailDO.setCookTime(cookbookDetail.getCookTime());
                        cookbookDetailDO.setMainIngredients(JSON.toJSONString(cookbookDetail.getMainIngredients()));
                        cookbookDetailDO.setSeasonings(JSON.toJSONString(cookbookDetail.getSeasonings()));
                        cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetail.getSteps()));
                        cookbookDetailDO.setTips(JSON.toJSONString(cookbookDetail.getTips()));

                        ChinacaipuCookbookDetailDO currentDetailDO = chinacaipuCookbookDetailManager.selectByCookbookUrl(cookbookUrl);
                        if (null != currentDetailDO) {
                            cookbookDetailDO.setId(currentDetailDO.getId());
                            cookbookDetailDO.setGmtCreate(currentDetailDO.getGmtCreate());
                            cookbookDetailDO.setGmtUpdate(currentDetailDO.getGmtUpdate());
                            if (!cookbookDetailDO.equals(currentDetailDO)) {
                                chinacaipuCookbookDetailManager.updateByPrimaryKeySelective(cookbookDetailDO);
                            }
                        } else {
                            chinacaipuCookbookDetailManager.insertSelective(cookbookDetailDO);
                        }
                        originalCookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        chinacaipuCookbookUrlManager.updateByPrimaryKeySelective(originalCookbookUrlDO);
                    } catch (Exception e) {
                        log.error("爬取页面异常：{}", cookbookUrl);
                        log.error(e.getMessage(), e);
                    }
                });
            }
            webClient.close();
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlOtherCookbookDetailPage() {
        BizResult result = BizResult.custom();
        try {
            List<ChinacaipuCookbookUrlDO> otherCookbookUrlDOS = chinacaipuCookbookUrlManager.selectOtherNotCrawled();
            if (CollectionUtils.isEmpty(otherCookbookUrlDOS)) {
                return result.success("无未爬取第三方菜谱明细页面");
            }
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
            for (ChinacaipuCookbookUrlDO otherCookbookUrlDO : otherCookbookUrlDOS) {
                fixedThreadPool.submit(() -> {
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    String cookbookUrl = otherCookbookUrlDO.getCookbookUrl();
                    try {
                        OtherCookbookDetailPage cookbookDetailPage = OtherCookbookDetailPage.crawlOtherCookbookDetailPage(cookbookUrl, webClient);
                        if (null == cookbookDetailPage) {
                            log.error("爬取页面内容失败：{}", cookbookUrl);
                            otherCookbookUrlDO.setIsEffective(IsEffectiveEnum.NO.getCode());
                            chinacaipuCookbookUrlManager.updateByPrimaryKeySelective(otherCookbookUrlDO);
                            return;
                        }
                        OtherCookbookDetailPage.OtherCookbookDetail cookbookDetail = cookbookDetailPage.getOtherCookbookDetail();
                        ChinacaipuOtherCookbookDetailDO cookbookDetailDO = new ChinacaipuOtherCookbookDetailDO();
                        cookbookDetailDO.setAuthor(cookbookDetail.getAuthor());
                        cookbookDetailDO.setEditTime(cookbookDetail.getEditTime());
                        cookbookDetailDO.setDetail(cookbookDetail.getDetail());
                        cookbookDetailDO.setCookbookUrl(cookbookUrl);
                        cookbookDetailDO.setCookbookName(otherCookbookUrlDO.getCookbookName());
                        cookbookDetailDO.setTitle(cookbookDetail.getTitle());
                        cookbookDetailDO.setCoverPicture(cookbookDetail.getCoverPicture());
                        cookbookDetailDO.setDescription(cookbookDetail.getDescription());
                        ChinacaipuOtherCookbookDetailDO currentDetailDO = chinacaipuOtherCookbookDetailManager.selectByCookbookUrl(cookbookUrl);
                        if (null != currentDetailDO) {
                            cookbookDetailDO.setId(currentDetailDO.getId());
                            cookbookDetailDO.setGmtCreate(currentDetailDO.getGmtCreate());
                            cookbookDetailDO.setGmtUpdate(currentDetailDO.getGmtUpdate());
                            if (!cookbookDetailDO.equals(currentDetailDO)) {
                                chinacaipuOtherCookbookDetailManager.updateByPrimaryKeySelective(cookbookDetailDO);
                            }
                        } else {
                            chinacaipuOtherCookbookDetailManager.insertSelective(cookbookDetailDO);
                        }
                        otherCookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        chinacaipuCookbookUrlManager.updateByPrimaryKeySelective(otherCookbookUrlDO);
                    } catch (Exception e) {
                        log.error("爬取页面异常：{}", cookbookUrl);
                        log.error(e.getMessage(), e);
                    }
                    webClient.close();
                });
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }
}
