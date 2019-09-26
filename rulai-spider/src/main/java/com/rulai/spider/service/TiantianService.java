package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.rulai.common.component.BizResult;
import com.rulai.common.component.splitter.BigDecimalSplitter;
import com.rulai.common.component.splitter.InputSplit;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.tiantian.CookbookDetailPage;
import com.rulai.spider.bean.crawl.tiantian.CookbookListPage;
import com.rulai.spider.bean.crawl.tiantian.SecondCategoryPage;
import com.rulai.spider.bean.crawl.tiantian.TopCategoryPage;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.*;
import com.rulai.spider.bean.query.TiantianCookbookUrlQuery;
import com.rulai.spider.bean.query.TiantianSecondCategoryQuery;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/12 14:04
 */
@Component
@Slf4j
public class TiantianService {
    
    @Autowired
    private TiantianTopCategoryManager topCategoryManager;

    @Autowired
    private TiantianSecondCategoryManager secondCategoryManager;

    @Autowired
    private TiantianCookbookUrlManager cookbookUrlManager;

    @Autowired
    private TiantianCategoryCookbookRelationManager categoryCookbookRelationManager;

    @Autowired
    private TiantianCookbookDetailManager cookbookDetailManager;

    public BizResult crawlTopCategory() {
        BizResult result = BizResult.custom();
        try {
            WebClient webClient = HtmlUnitHelper.getWebClient();
            BizResult<TopCategoryPage> crawlResult = TopCategoryPage.crawl(webClient);
            webClient.close();
            if (crawlResult.isFail()) {
                return result.fail(crawlResult.getMessage());
            }
            TopCategoryPage categoryPage = crawlResult.getData();
            for (TopCategoryPage.TopCategory topCategory : categoryPage.getCategories()) {
                String categoryUrl = topCategory.getCategoryUrl();
                TiantianTopCategoryDO topCategoryDO = new TiantianTopCategoryDO();
                topCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                topCategoryDO.setCategoryName(topCategory.getCategoryName());
                topCategoryDO.setCategoryUrl(categoryUrl);
                TiantianTopCategoryDO currentCategoryDO = topCategoryManager.selectByCategoryUrl(categoryUrl);
                if (null != currentCategoryDO) {
                    topCategoryDO.setId(currentCategoryDO.getId());
                    topCategoryDO.setGmtCreate(currentCategoryDO.getGmtCreate());
                    topCategoryDO.setGmtUpdate(currentCategoryDO.getGmtUpdate());
                    if (!topCategoryDO.equals(currentCategoryDO)) {
                        log.info("修改分类，分类url：{}", categoryUrl);
                        topCategoryManager.updateByPrimaryKeySelective(topCategoryDO);
                    }
                } else {
                    log.info("新增分类，分类url：{}", categoryUrl);
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
            List<TiantianTopCategoryDO> topCategoryDOS = topCategoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(topCategoryDOS)) {
                return result.success("无未爬取顶级分类");
            }
            WebClient webClient = HtmlUnitHelper.getWebClient();
            for (TiantianTopCategoryDO topCategoryDO : topCategoryDOS) {
                String categoryUrl = topCategoryDO.getCategoryUrl();
                BizResult<SecondCategoryPage> crawlResult = SecondCategoryPage.crawl(categoryUrl, webClient);
                if (crawlResult.isFail()) {
                    log.error(crawlResult.getMessage());
                    continue;
                }
                for (SecondCategoryPage.SecondCategory category : crawlResult.getData().getCategories()) {
                    String secondCategoryUrl = category.getCategoryUrl();
                    try {
                        TiantianSecondCategoryDO secondCategoryDO = new TiantianSecondCategoryDO();
                        secondCategoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                        secondCategoryDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                        secondCategoryDO.setFatherName(category.getFatherName());
                        secondCategoryDO.setCategoryName(category.getCategoryName());
                        secondCategoryDO.setCategoryUrl(secondCategoryUrl);
                        secondCategoryDO.setTopCategoryId(topCategoryDO.getId());
                        TiantianSecondCategoryDO currentCategoryDO = secondCategoryManager.selectByCategoryUrl(secondCategoryUrl, topCategoryDO.getId());
                        if (null != currentCategoryDO) {
                            secondCategoryDO.setId(currentCategoryDO.getId());
                            secondCategoryDO.setGmtCreate(currentCategoryDO.getGmtCreate());
                            secondCategoryDO.setGmtUpdate(currentCategoryDO.getGmtUpdate());
                            if (!secondCategoryDO.equals(currentCategoryDO)) {
                                log.info("修改分类，分类url：{}", secondCategoryUrl);
                                secondCategoryManager.updateByPrimaryKeySelective(secondCategoryDO);
                            }
                        } else {
                            log.info("新增分类，分类url：{}", secondCategoryUrl);
                            secondCategoryManager.insertSelective(secondCategoryDO);
                        }
                    } catch (Exception e) {
                        log.error("存储页面数据错误：{}", secondCategoryUrl);
                        log.error(e.getMessage(), e);
                    }
                }
                try {
                    topCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                    topCategoryManager.updateByPrimaryKeySelective(topCategoryDO);
                } catch (Exception e) {
                    log.error("修改页面数据错误：{}", categoryUrl);
                    log.error(e.getMessage(), e);
                }
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlCookbookUrlWithSplitter() {
        BizResult result = BizResult.custom();
        try {
            SplitterDTO splitterDTO = secondCategoryManager.selectNoCrawledMinMaxId();
            if (null == splitterDTO) {
                return result.success("无查询最大最小id分片内容");
            }
            if (splitterDTO.getTotalCount() == 0) {
                return result.success("无未爬取的分类页面");
            }
            int splitNum = 10;
            BigDecimal numSplits = new BigDecimal(splitNum);
            BigDecimal minVal = splitterDTO.getMinVal();
            BigDecimal maxVal = splitterDTO.getMaxVal();
            ExecutorService fixedThreadPool = new ThreadPoolExecutor(splitNum, splitNum,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>());
            BigDecimalSplitter bigDecimalSplitter = new BigDecimalSplitter();
            List<InputSplit> inputSplits = bigDecimalSplitter.split(TiantianSecondCategoryQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    String splitterClause = inputSplit.toString();
                    List<TiantianSecondCategoryDO> secondCategoryDOS = secondCategoryManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(secondCategoryDOS)) {
                        log.info("该分片无未爬取的分类页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = secondCategoryDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    int index = 0;
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    for (TiantianSecondCategoryDO secondCategoryDO : secondCategoryDOS) {
                        log.info("现在爬取该分片 {} 第 {} 条数据，还剩 {} 条数据", splitterClause, ++index, size - index);
                        String categoryUrl = secondCategoryDO.getCategoryUrl();
                        CookbookListPage cookbookListPage = new CookbookListPage();
                        cookbookListPage.setNextUrl(categoryUrl);
                        cookbookListPage.setHasNext(true);
                        while (cookbookListPage.isHasNext()) {
                            String url = cookbookListPage.getNextUrl();
                            BizResult<CookbookListPage> crawlResult = CookbookListPage.crawl(url, webClient);
                            if (crawlResult.isFail()) {
                                log.error(crawlResult.getMessage());
                                cookbookListPage = new CookbookListPage();
                                cookbookListPage.setHasNext(false);
                                continue;
                            }
                            cookbookListPage = crawlResult.getData();
                            for (CookbookListPage.CookbookUrl cookbookUrl : cookbookListPage.getCookbookUrls()) {
                                try {
                                    String urlValue = cookbookUrl.getCookbookUrl();
                                    TiantianCookbookUrlDO cookbookUrlDO = new TiantianCookbookUrlDO();
                                    cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                    cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                    cookbookUrlDO.setCookbookUrl(urlValue);
                                    cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                    TiantianCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(urlValue);
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
                                    TiantianCategoryCookbookRelationDO currentRelationDO =
                                            categoryCookbookRelationManager.selectByCookbookUrlIdAndSecondCategoryId(cookbookUrlDO.getId(), secondCategoryDO.getId());
                                    if (null != currentRelationDO) {
                                        if (!url.equals(currentRelationDO.getCategoryLocationUrl())) {
                                            log.info("修改分类关系");
                                            currentRelationDO.setCategoryLocationUrl(url);
                                            categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                        }
                                    } else {
                                        log.info("新增分类关系");
                                        currentRelationDO = new TiantianCategoryCookbookRelationDO();
                                        currentRelationDO.setSecondCategoryId(secondCategoryDO.getId());
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
                        secondCategoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        secondCategoryManager.updateByPrimaryKeySelective(secondCategoryDO);
                    }
                    webClient.close();
                    log.info("该分片 {} 执行完成", splitterClause);
                });
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlCookbookDetailWithSplitter() {
        BizResult result = BizResult.custom();
        try {
            SplitterDTO splitterDTO = cookbookUrlManager.selectNoCrawledMinMaxId();
            if (null == splitterDTO) {
                return result.success("无查询最大最小id分片内容");
            }
            if (splitterDTO.getTotalCount() == 0) {
                return result.success("无未爬取的有效的菜谱页面");
            }
            int splitNum = 20;
            BigDecimal numSplits = new BigDecimal(splitNum);
            BigDecimal minVal = splitterDTO.getMinVal();
            BigDecimal maxVal = splitterDTO.getMaxVal();
            ExecutorService fixedThreadPool = new ThreadPoolExecutor(splitNum, splitNum,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>());
            BigDecimalSplitter bigDecimalSplitter = new BigDecimalSplitter();
            List<InputSplit> inputSplits = bigDecimalSplitter.split(TiantianCookbookUrlQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    String splitterClause = inputSplit.toString();
                    List<TiantianCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                        log.info("该分片无未爬取的食谱页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = cookbookUrlDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    int index = 0;
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    for (TiantianCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
                        log.info("现在爬取该分片 {} 第 {} 条数据，还剩 {} 条数据", splitterClause, ++index, size - index);
//                        try {
//                            long time = CommonUtils.generateRandomMillisecond();
//                            log.info("该分片 {} 线程 {} 暂停 {} 毫秒", splitterClause, Thread.currentThread().getName(), time);
//                            Thread.sleep(time);
//                        } catch (InterruptedException e) {
//                            log.error("线程暂停错误");
//                            log.error(e.getMessage(), e);
//                        }
                        String url = cookbookUrlDO.getCookbookUrl();
                        BizResult<CookbookDetailPage> crawlResult = CookbookDetailPage.crawl(url, webClient);
                        if (crawlResult.isFail()) {
                            log.error(crawlResult.getMessage());
                            cookbookUrlDO.setIsEffective(IsEffectiveEnum.NO.getCode());
                            cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                            continue;
                        }
                        CookbookDetailPage cookbookDetailPage = crawlResult.getData();
                        try {
                            TiantianCookbookDetailDO cookbookDetailDO = new TiantianCookbookDetailDO();
                            cookbookDetailDO.setCookbookUrlId(cookbookUrlDO.getId());
                            cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                            cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                            cookbookDetailDO.setIngredients(JSON.toJSONString(cookbookDetailPage.getIngredients()));
                            cookbookDetailDO.setLabels(JSON.toJSONString(cookbookDetailPage.getLabels()));
                            cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetailPage.getSteps()));
                            cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                            TiantianCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrlId(cookbookUrlDO.getId());
                            if (null != currentDetailDO) {
                                cookbookDetailDO.setId(currentDetailDO.getId());
                                cookbookDetailDO.setGmtCreate(currentDetailDO.getGmtCreate());
                                cookbookDetailDO.setGmtUpdate(currentDetailDO.getGmtUpdate());
                                if (!cookbookDetailDO.equals(currentDetailDO)) {
                                    log.info("更新食谱明细");
                                    cookbookDetailManager.updateByPrimaryKeySelective(cookbookDetailDO);
                                }
                            } else {
                                log.info("新增食谱明细");
                                cookbookDetailManager.insertSelective(cookbookDetailDO);
                            }
                            log.info("更新爬取状态");
                            cookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                            cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                        } catch (Exception e) {
                            log.error("存储页面数据错误：{}", url);
                            log.error(e.getMessage(), e);
                        }
                    }
                    webClient.close();
                    log.info("该分片 {} 执行完成", splitterClause);
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
