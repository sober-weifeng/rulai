package com.rulai.spider.service;
import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.meishijie.CookbookDetailPage;
import com.rulai.spider.bean.crawl.meishijie.CookbookListPage;
import com.rulai.spider.bean.crawl.meishijie.SecondCategoryPage;
import com.rulai.spider.bean.crawl.meishijie.TopCategoryPage;
import com.rulai.spider.bean.model.*;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.CrawlTypeEnum;
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
 * @date 2019/9/3 15:11
 */
@Component
@Slf4j
public class MeishijieService {

    @Autowired
    private MeishijieTopCategoryManager topCategoryManager;
    
    @Autowired
    private MeishijieSecondCategoryManager secondCategoryManager;
    
    @Autowired
    private MeishijieCookbookUrlManager cookbookUrlManager;
    
    @Autowired
    private MeishijieCategoryCookbookRelationManager categoryCookbookRelationManager;
    
    @Autowired
    private MeishijieCookbookDetailManager cookbookDetailManager;

    public BizResult crawlTopCategory() {
        BizResult result = BizResult.custom();
        try {
            WebClient webClient = HtmlUnitHelper.getWebClient();
            TopCategoryPage topCategoryPage = TopCategoryPage.crawl(webClient);
            webClient.close();
            if (null == topCategoryPage) {
                return result.success("未爬取到内容");
            }
            for (TopCategoryPage.TopCategory topCategory : topCategoryPage.getTopCategories()) {
                MeishijieTopCategoryDO topCategoryDO = new MeishijieTopCategoryDO();
                topCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                topCategoryDO.setCategoryName(topCategory.getCategoryName());
                topCategoryDO.setCategoryUrl(topCategory.getCategoryUrl());
                MeishijieTopCategoryDO currentCategoryDO = topCategoryManager.selectByCategoryUrl(topCategory.getCategoryUrl());
                if (null != currentCategoryDO) {
                    if (!topCategoryDO.getCategoryName().equals(currentCategoryDO.getCategoryName())) {
                        topCategoryDO.setId(currentCategoryDO.getId());
                        topCategoryManager.updateByPrimaryKeySelective(topCategoryDO);
                    }
                } else {
                    topCategoryManager.insertSelective(topCategoryDO);
                }
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlSecondCategory() {
        BizResult result = BizResult.custom();
        try {
            List<MeishijieTopCategoryDO> topCategoryDOS = topCategoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(topCategoryDOS)) {
                return result.success("无未爬取的一级分类页面");
            }
            WebClient webClient = HtmlUnitHelper.getWebClient();
            for (MeishijieTopCategoryDO topCategoryDO : topCategoryDOS) {
                String topCategoryUrl = topCategoryDO.getCategoryUrl();
                try {
                    SecondCategoryPage secondCategoryPage = SecondCategoryPage.crawl(topCategoryUrl, webClient);
                    if (null == secondCategoryPage) {
                        return result.success("未爬取到内容");
                    }
                    for (SecondCategoryPage.SecondCategory secondCategory : secondCategoryPage.getSecondCategories()) {
                        try {
                            MeishijieSecondCategoryDO secondCategoryDO = new MeishijieSecondCategoryDO();
                            secondCategoryDO.setTopCategoryId(topCategoryDO.getId());
                            secondCategoryDO.setTopCategoryTip(secondCategory.getTopCategoryTip());
                            secondCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                            secondCategoryDO.setCategoryName(secondCategory.getCategoryName());
                            secondCategoryDO.setCategoryUrl(secondCategory.getCategoryUrl());
                            MeishijieSecondCategoryDO currentSecondDO = secondCategoryManager.selectByCategoryUrl(secondCategory.getCategoryUrl());
                            if (null != currentSecondDO) {
                                if (!(secondCategoryDO.getCategoryName().equals(currentSecondDO.getCategoryName())
                                        && secondCategoryDO.getTopCategoryTip().equals(currentSecondDO.getTopCategoryTip())
                                        && secondCategoryDO.getTopCategoryId().equals(currentSecondDO.getTopCategoryId()))) {
                                    secondCategoryDO.setId(currentSecondDO.getId());
                                    secondCategoryManager.updateByPrimaryKeySelective(secondCategoryDO);
                                }
                            } else {
                                secondCategoryManager.insertSelective(secondCategoryDO);
                            }
                            topCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                            topCategoryManager.updateByPrimaryKeySelective(topCategoryDO);
                        } catch (Exception e) {
                            log.error("该页面数据存储异常：{}", secondCategory.getCategoryUrl());
                            log.error(e.getMessage(), e);
                        }
                    }
                } catch (Exception e) {
                    log.error("爬取一级分类页面异常：{}", topCategoryUrl);
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

    public BizResult crawlCookbookUrlList() {
        BizResult result = BizResult.custom();
        try {
            List<MeishijieSecondCategoryDO> secondCategoryDOS = secondCategoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(secondCategoryDOS)) {
                return result.success("无未爬取的二级分类页面");
            }
//            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
            for (MeishijieSecondCategoryDO secondCategoryDO : secondCategoryDOS) {
//                fixedThreadPool.submit(() -> {
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    String secondCategoryUrl = secondCategoryDO.getCategoryUrl();
                    CookbookListPage cookbookListPage = new CookbookListPage();
                    cookbookListPage.setOriginUrl("");
                    cookbookListPage.setNextUrl(secondCategoryUrl);
                    cookbookListPage.setHasNext(true);
                    while (cookbookListPage.isHasNext()) {
                        try {
                            cookbookListPage = CookbookListPage.crawl(cookbookListPage.getNextUrl(), webClient);
                            if (null == cookbookListPage) {
                                log.error("未爬取到内容");
                                cookbookListPage.setNextUrl("");
                                cookbookListPage.setHasNext(false);
                                continue;
                            }
                            for (CookbookListPage.CookbookUrl cookbookUrl : cookbookListPage.getCookbookUrls()) {
                                try {
                                    MeishijieCookbookUrlDO cookbookUrlDO = new MeishijieCookbookUrlDO();
                                    cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                    cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                    cookbookUrlDO.setCookbookUrl(cookbookUrl.getCookbookUrl());
                                    cookbookUrlDO.setSecondLocationUrl(cookbookListPage.getOriginUrl());
                                    cookbookUrlDO.setTopLocationUrl("");
                                    cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                    cookbookUrlDO.setCrawlType(CrawlTypeEnum.ORIGIN.getCode());
                                    MeishijieCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(cookbookUrl.getCookbookUrl());
                                    if (null != currentUrlDO) {
                                        cookbookUrlDO.setId(currentUrlDO.getId());
                                        if (!(cookbookUrlDO.getCookbookName().equals(currentUrlDO.getCookbookName())
                                                && cookbookUrlDO.getSecondLocationUrl().equals(currentUrlDO.getSecondLocationUrl()))) {
                                            cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                                        }
                                    } else {
                                        cookbookUrlManager.insertSelective(cookbookUrlDO);
                                    }
                                    if (categoryCookbookRelationManager.countByCookbookUrlIdAndSecondCategoryId(cookbookUrlDO.getId(), secondCategoryDO.getId()) == 0) {
                                        MeishijieCategoryCookbookRelationDO relationDO = new MeishijieCategoryCookbookRelationDO();
                                        relationDO.setSecondCategoryId(secondCategoryDO.getId());
                                        relationDO.setCookbookUrlId(cookbookUrlDO.getId());
                                        categoryCookbookRelationManager.insertSelective(relationDO);
                                    }
                                } catch (Exception e) {
                                    log.error("该页面数据存储异常：{}", cookbookUrl.getCookbookUrl());
                                    log.error(e.getMessage(), e);
                                }
                            }
                        } catch (Exception e) {
                            log.error("爬取二级分类页面异常：{}", secondCategoryUrl);
                            log.error(e.getMessage(), e);
                        }
                    }
                    secondCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                    secondCategoryManager.updateByPrimaryKeySelective(secondCategoryDO);
                    webClient.close();
//                });
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlCookbookDetail() {
        BizResult result = BizResult.custom();
        try {
            List<MeishijieCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                return result.success("无未爬取的菜谱页面");
            }
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
            for (MeishijieCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
                fixedThreadPool.submit(() -> {
                    String cookbookUrl = cookbookUrlDO.getCookbookUrl();
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    try {
                        CookbookDetailPage cookbookDetailPage = CookbookDetailPage.crawl(cookbookUrl, webClient);
                        if (null == cookbookDetailPage) {
                            log.error("爬取页面内容失败：{}", cookbookUrl);
                            cookbookUrlDO.setIsEffective(IsEffectiveEnum.NO.getCode());
                            cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                            return;
                        }
                        MeishijieCookbookDetailDO cookbookDetailDO = new MeishijieCookbookDetailDO();
                        cookbookDetailDO.setCookbookUrl(cookbookUrl);
                        cookbookDetailDO.setCookbookName(cookbookUrlDO.getCookbookName());
                        cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                        cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                        cookbookDetailDO.setTechnology(cookbookDetailPage.getTechnology());
                        cookbookDetailDO.setDifficulty(cookbookDetailPage.getDifficulty());
                        cookbookDetailDO.setNumberofpeople(cookbookDetailPage.getNumberOfPeople());
                        cookbookDetailDO.setTaste(cookbookDetailPage.getTaste());
                        cookbookDetailDO.setSetuptime(cookbookDetailPage.getSetupTime());
                        cookbookDetailDO.setCooktime(cookbookDetailPage.getCookTime());
                        cookbookDetailDO.setDescription(cookbookDetailPage.getDescription());
                        cookbookDetailDO.setMainIngredients(JSON.toJSONString(cookbookDetailPage.getMainIngredients()));
                        cookbookDetailDO.setSupIngredients(JSON.toJSONString(cookbookDetailPage.getSupIngredients()));
                        cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetailPage.getSteps()));
                        cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                        MeishijieCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrl(cookbookUrl);
                        if (null != currentDetailDO) {
                            cookbookDetailDO.setId(currentDetailDO.getId());
                            cookbookDetailDO.setGmtCreate(currentDetailDO.getGmtCreate());
                            cookbookDetailDO.setGmtUpdate(currentDetailDO.getGmtUpdate());
                            if (!cookbookDetailDO.equals(currentDetailDO)) {
                                cookbookDetailManager.updateByPrimaryKeySelective(cookbookDetailDO);
                            }
                        } else {
                            cookbookDetailManager.insertSelective(cookbookDetailDO);
                        }
                        cookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
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
