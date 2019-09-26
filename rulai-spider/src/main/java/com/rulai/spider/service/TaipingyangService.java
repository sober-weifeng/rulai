package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.taipingyang.CookbookDetailPage;
import com.rulai.spider.bean.crawl.taipingyang.CookbookListPage;
import com.rulai.spider.bean.crawl.taipingyang.SecondCategoryPage;
import com.rulai.spider.bean.crawl.taipingyang.TopCategoryPage;
import com.rulai.spider.bean.model.*;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.*;
import com.rulai.spider.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/22 16:50
 */
@Component
@Slf4j
public class TaipingyangService {
    
//    @Autowired
//    private TaipingyangMainPageManager taipingyangMainPageManager;
    
    @Autowired
    private TaipingyangTopCategoryManager topCategoryManager;
    
    @Autowired
    private TaipingyangSecondCategoryManager secondCategoryManager;
    
    @Autowired
    private TaipingyangThirdCategoryManager thirdCategoryManager;
    
    @Autowired
    private TaipingyangCookbookUrlManager cookbookUrlManager;
    
    @Autowired
    private TaipingyangCategoryCookbookRelationManager categoryCookbookRelationManager;
    
    @Autowired
    private TaipingyangCookbookDetailManager cookbookDetailManager;
    
    public BizResult crawlTopCategories() {
        BizResult result = BizResult.custom();
        try {
//            TaipingyangMainPageDO taipingyangMainPageDO = taipingyangMainPageManager.selectMainPage();
//            if (null == taipingyangMainPageDO) {
//                return result.fail(BizResultCodeEnum.NO_DATA);
//            }
//            String url = taipingyangMainPageDO.getMainOriginUrl();
            TopCategoryPage topCategoryPage = TopCategoryPage.crawlTopCategoryPage();
            if (null == topCategoryPage) {
                return result.fail("爬取主页面失败");
            }
            for (TopCategoryPage.TopCategory topCategory : topCategoryPage.getTopCategories()) {
                String categoryUrl = topCategory.getCategoryUrl();
                TaipingyangTopCategoryDO taipingyangTopCategoryDO = new TaipingyangTopCategoryDO();
                taipingyangTopCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                taipingyangTopCategoryDO.setCategoryName(topCategory.getCategoryName());
                taipingyangTopCategoryDO.setCategoryUrl(categoryUrl);
                TaipingyangTopCategoryDO currentDO = topCategoryManager.selectByCategoryUrl(categoryUrl);
                if (null == currentDO) {
                    topCategoryManager.insertSelective(taipingyangTopCategoryDO);
                } else {
                    if (!taipingyangTopCategoryDO.getCategoryName().equals(currentDO.getCategoryName())) {
                        taipingyangTopCategoryDO.setId(currentDO.getId());
                        topCategoryManager.updateByPrimaryKeySelective(taipingyangTopCategoryDO);
                    }
                }
            }
            log.info("主页面顶级分类爬取完毕");
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlSecondCategories() {
        BizResult result = BizResult.custom();
        try {
            List<TaipingyangTopCategoryDO> topCategoryDOS = topCategoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(topCategoryDOS)) {
                return result.success(BizResultCodeEnum.NO_DATA.getMessage());
            }
            for (TaipingyangTopCategoryDO topCategoryDO : topCategoryDOS) {
                SecondCategoryPage secondCategoryPage = SecondCategoryPage.crawlSecondCategoryPage(topCategoryDO.getCategoryUrl());
                if (null == secondCategoryPage) {
                    log.error("爬取页面失败了，开始下一个");
                    continue;
                }
                for (SecondCategoryPage.SecondCategory secondCategory : secondCategoryPage.getSecondCategories()) {
                    TaipingyangSecondCategoryDO taipingyangSecondCategoryDO = new TaipingyangSecondCategoryDO();
                    taipingyangSecondCategoryDO.setTopCategoryId(topCategoryDO.getId());
                    taipingyangSecondCategoryDO.setCategoryName(secondCategory.getCategoryName());
                    taipingyangSecondCategoryDO.setLabelId(secondCategory.getLabelId());
                    TaipingyangSecondCategoryDO currentSecondDO = secondCategoryManager.selectByLabelId(secondCategory.getLabelId());
                    if (null != currentSecondDO) {
                        taipingyangSecondCategoryDO.setId(currentSecondDO.getId());
                        if (!(taipingyangSecondCategoryDO.getLabelId().equals(currentSecondDO.getLabelId()) 
                                && taipingyangSecondCategoryDO.getCategoryName().equals(currentSecondDO.getCategoryName()))) {
                            secondCategoryManager.updateByPrimaryKeySelective(taipingyangSecondCategoryDO);
                        }
                    } else {
                        secondCategoryManager.insertSelective(taipingyangSecondCategoryDO);
                    }
                    for (SecondCategoryPage.ThirdCategory thirdCategory : secondCategory.getThirdCategories()) {
                        TaipingyangThirdCategoryDO taipingyangThirdCategoryDO = new TaipingyangThirdCategoryDO();
                        taipingyangThirdCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                        taipingyangThirdCategoryDO.setSecondCategoryId(taipingyangSecondCategoryDO.getId());
                        taipingyangThirdCategoryDO.setCategoryName(thirdCategory.getCategoryName());
                        taipingyangThirdCategoryDO.setCategoryUrl(thirdCategory.getFirstCategoryUrl());
                        TaipingyangThirdCategoryDO currentThirdDO = thirdCategoryManager.selectByCategoryUrl(thirdCategory.getFirstCategoryUrl(), taipingyangSecondCategoryDO.getId());
                        if (null != currentThirdDO) {
                            taipingyangThirdCategoryDO.setId(currentThirdDO.getId());
                            if (!taipingyangThirdCategoryDO.getCategoryName().equals(currentThirdDO.getCategoryName())) {
                                thirdCategoryManager.updateByPrimaryKeySelective(taipingyangThirdCategoryDO);
                            }
                        } else {
                            thirdCategoryManager.insertSelective(taipingyangThirdCategoryDO);
                        }
                    }
                }
                topCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                topCategoryManager.updateByPrimaryKeySelective(topCategoryDO);
                Thread.sleep(2000L);
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlCookbookUrls() {
        BizResult result = BizResult.custom();
        try {
            List<TaipingyangThirdCategoryDO> thirdCategoryDOS = thirdCategoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(thirdCategoryDOS)) {
                return result.success(BizResultCodeEnum.NO_DATA.getMessage());
            }
            ExecutorService fixedThreadPool = new ThreadPoolExecutor(2, 2,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>());
            for (TaipingyangThirdCategoryDO thirdCategoryDO : thirdCategoryDOS) {
                fixedThreadPool.submit(() -> {
                    String categoryUrl = thirdCategoryDO.getCategoryUrl();
                    CookbookListPage cookbookListPage = new CookbookListPage();
                    cookbookListPage.setNextUrl(categoryUrl);
                    cookbookListPage.setHasNext(true);
                    boolean isSuccess = true, isFirst = true;
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    while (cookbookListPage.isHasNext()) {
                        try {
                            long time = CommonUtils.generateRandomMillisecond();
                            log.info("线程 {} 暂停 {} 毫秒", Thread.currentThread().getName(), time);
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            log.error("线程暂停错误");
                            log.error(e.getMessage(), e);
                        }
                        String url = cookbookListPage.getNextUrl();
                        BizResult<CookbookListPage> crawlResult = isFirst ? 
                                CookbookListPage.crawlFirstPage(url, webClient) : CookbookListPage.crawlNotFirstPage(url, webClient);
                        if (crawlResult.isFail()) {
                            log.error(crawlResult.getMessage());
                            cookbookListPage = new CookbookListPage();
                            cookbookListPage.setHasNext(false);
                            isSuccess = false;
                            continue;
                        }
                        if (isFirst) {
                            isFirst = false;
                        }
                        cookbookListPage = crawlResult.getData();
                        for (CookbookListPage.CookbookUrl cookbookUrl : cookbookListPage.getCookbookUrls()) {
                            try {
                                String urlValue = cookbookUrl.getCookbookUrl();
                                TaipingyangCookbookUrlDO cookbookUrlDO = new TaipingyangCookbookUrlDO();
                                cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                cookbookUrlDO.setCookbookUrl(urlValue);
                                cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                TaipingyangCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(urlValue);
                                if (null != currentUrlDO) {
                                    cookbookUrlDO.setId(currentUrlDO.getId());
                                    if (!cookbookUrlDO.getCookbookName().equals(currentUrlDO.getCookbookName())) {
                                        log.info("修改食谱URL数据");
                                        cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                                    }
                                } else {
                                    log.info("新增食谱URL数据");
                                    cookbookUrlManager.insertSelective(cookbookUrlDO);
                                }
                                TaipingyangCategoryCookbookRelationDO currentRelationDO =
                                        categoryCookbookRelationManager.selectByThirdCategoryIdAndCookbookUrlId(cookbookUrlDO.getId(), thirdCategoryDO.getId());
                                if (null != currentRelationDO) {
                                    if (!url.equals(currentRelationDO.getCategoryLocationUrl())) {
                                        log.info("修改分类关系");
                                        currentRelationDO.setCategoryLocationUrl(url);
                                        categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                    }
                                } else {
                                    log.info("新增分类关系");
                                    currentRelationDO = new TaipingyangCategoryCookbookRelationDO();
                                    currentRelationDO.setThirdCategoryId(thirdCategoryDO.getId());
                                    currentRelationDO.setCookbookUrlId(cookbookUrlDO.getId());
                                    currentRelationDO.setCategoryLocationUrl(url);
                                    categoryCookbookRelationManager.insertSelective(currentRelationDO);
                                }
                            } catch (Exception e) {
                                log.error("存储页面数据错误：{}", url);
                                log.error(e.getMessage(), e);
                            }
                        }
                    }
                    if (isSuccess) {
                        thirdCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                    } else {
                        thirdCategoryDO.setIsEffective(IsEffectiveEnum.NO.getCode());
                    }
                    thirdCategoryManager.updateByPrimaryKeySelective(thirdCategoryDO);
                });
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlCookbookDetails() {
        BizResult result = BizResult.custom();
        try {
            List<TaipingyangCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                return result.success(BizResultCodeEnum.NO_DATA.getMessage());
            }
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
            for (TaipingyangCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
                fixedThreadPool.submit(() -> {
                    String cookbookUrl = cookbookUrlDO.getCookbookUrl();
                    try {
                        log.info("爬取食谱明细页面：{}", cookbookUrl);
                        CookbookDetailPage cookbookDetailPage = CookbookDetailPage.crawlCookbookDetailPage(cookbookUrl);
                        if (null == cookbookDetailPage) {
                            log.info("等待3秒，开始下一个");
                            Thread.sleep(3000L);
                            return;
                        }
                        CookbookDetailPage.CookbookDetail cookbookDetail = cookbookDetailPage.getCookbookDetail();
                        TaipingyangCookbookDetailDO taipingyangCookbookDetailDO = new TaipingyangCookbookDetailDO();
                        taipingyangCookbookDetailDO.setCookbookUrl(cookbookUrl);
                        taipingyangCookbookDetailDO.setTitle(cookbookUrlDO.getCookbookName());
                        taipingyangCookbookDetailDO.setLabels(JSON.toJSONString(cookbookDetail.getLabels()));
                        taipingyangCookbookDetailDO.setCoverPicture(cookbookDetail.getCoverPicture());
                        taipingyangCookbookDetailDO.setDescription(cookbookDetail.getDescription());
                        taipingyangCookbookDetailDO.setRecommendCrowd(JSON.toJSONString(cookbookDetail.getRecommendCrowd()));
                        taipingyangCookbookDetailDO.setAvoidCrowd(JSON.toJSONString(cookbookDetail.getAvoidCrowd()));
                        taipingyangCookbookDetailDO.setMainIngredients(JSON.toJSONString(cookbookDetail.getMainIngredients()));
                        taipingyangCookbookDetailDO.setSeasonings(JSON.toJSONString(cookbookDetail.getSeasonings()));
                        taipingyangCookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetail.getSteps()));
                        taipingyangCookbookDetailDO.setTip(cookbookDetail.getTip());
                        TaipingyangCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrl(cookbookUrl);
                        if (null != currentDetailDO) {
                            taipingyangCookbookDetailDO.setId(currentDetailDO.getId());
                            if (isNeedToUpdate(taipingyangCookbookDetailDO, currentDetailDO)) {
                                cookbookDetailManager.updateByPrimaryKeySelective(taipingyangCookbookDetailDO);
                            }
                        } else {
                            cookbookDetailManager.insertSelective(taipingyangCookbookDetailDO);
                        }
                        cookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                        log.info("等待3秒，开始下一个");
                        Thread.sleep(4000L);
                    } catch (Exception e) {
                        log.error("爬取食谱明细页面：{}异常", cookbookUrl);
                        log.error(e.getMessage(), e);
                    }
                });
                Thread.sleep(500L);
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }
    
    public boolean isNeedToUpdate(TaipingyangCookbookDetailDO newDetailDO, TaipingyangCookbookDetailDO oldDetailDO) {
        return !(newDetailDO.getTitle().equals(oldDetailDO.getTitle()) 
                && newDetailDO.getLabels().equals(oldDetailDO.getLabels()) 
                && newDetailDO.getCoverPicture().equals(oldDetailDO.getCoverPicture()) 
                && newDetailDO.getDescription().equals(oldDetailDO.getDescription())
                && newDetailDO.getRecommendCrowd().equals(oldDetailDO.getRecommendCrowd())
                && newDetailDO.getAvoidCrowd().equals(oldDetailDO.getAvoidCrowd()) 
                && newDetailDO.getMainIngredients().equals(oldDetailDO.getMainIngredients()) 
                && newDetailDO.getSeasonings().equals(oldDetailDO.getSeasonings()) 
                && newDetailDO.getSteps().equals(oldDetailDO.getSteps()) 
                && newDetailDO.getTip().equals(oldDetailDO.getTip()));
    }

    public BizResult crawlAll(boolean isFromStart) {
        BizResult result = BizResult.custom();
        try {
            if (isFromStart) {
                topCategoryManager.updateAllCrawledStatusToNo();
                thirdCategoryManager.updateAllCrawledStatusToNo();
                cookbookUrlManager.updateAllCrawledStatusToNo();
                result = crawlTopCategories();
                if (result.isFail()) {
                    return result;
                }
            }
            Thread.sleep(1000L);
            result = crawlSecondCategories();
            if (result.isFail()) {
                return result;
            }
            Thread.sleep(1000L);
            result = crawlCookbookUrls();
            if (result.isFail()) {
                return result;
            }
            Thread.sleep(1000L);
            result = crawlCookbookDetails();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }
}
