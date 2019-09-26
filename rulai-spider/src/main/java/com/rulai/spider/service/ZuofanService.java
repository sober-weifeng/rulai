package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.component.splitter.BigDecimalSplitter;
import com.rulai.common.component.splitter.InputSplit;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.zuofan.CategoryPage;
import com.rulai.spider.bean.crawl.zuofan.CookbookDetailPage;
import com.rulai.spider.bean.crawl.zuofan.CookbookListPage;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.ZuofanCategoryCookbookRelationDO;
import com.rulai.spider.bean.model.ZuofanCategoryDO;
import com.rulai.spider.bean.model.ZuofanCookbookDetailDO;
import com.rulai.spider.bean.model.ZuofanCookbookUrlDO;
import com.rulai.spider.bean.query.ZuofanCategoryQuery;
import com.rulai.spider.bean.query.ZuofanCookbookUrlQuery;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.ZuofanCategoryCookbookRelationManager;
import com.rulai.spider.manager.ZuofanCategoryManager;
import com.rulai.spider.manager.ZuofanCookbookDetailManager;
import com.rulai.spider.manager.ZuofanCookbookUrlManager;
import com.rulai.spider.util.CommonUtils;
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
public class ZuofanService {

    @Autowired
    private ZuofanCategoryManager categoryManager;

    @Autowired
    private ZuofanCookbookUrlManager cookbookUrlManager;

    @Autowired
    private ZuofanCategoryCookbookRelationManager categoryCookbookRelationManager;

    @Autowired
    private ZuofanCookbookDetailManager cookbookDetailManager;

    public BizResult crawlCategory() {
        BizResult result = BizResult.custom();
        try {
            WebClient webClient = HtmlUnitHelper.getWebClient();
            BizResult<CategoryPage> crawlResult = CategoryPage.crawl(webClient);
            webClient.close();
            if (crawlResult.isFail()) {
                return result.fail(crawlResult.getMessage());
            }
            CategoryPage categoryPage = crawlResult.getData();
            List<ZuofanCategoryDO> updateDOS = Lists.newArrayList();
            List<ZuofanCategoryDO> addDOS = Lists.newArrayList();
            for (CategoryPage.Category category : categoryPage.getCategories()) {
                String categoryUrl = category.getCategoryUrl();
                ZuofanCategoryDO categoryDO = new ZuofanCategoryDO();
                categoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                categoryDO.setFirstCategoryName(category.getFirstCategoryName());
                categoryDO.setSecondCategoryName(category.getSecondCategoryName());
                categoryDO.setThirdCategoryName(category.getThirdCategoryName());
                categoryDO.setCategoryUrl(categoryUrl);
                ZuofanCategoryDO currentCategoryDO = categoryManager.selectByCategoryUrl(categoryUrl);
                if (null != currentCategoryDO) {
                    categoryDO.setId(currentCategoryDO.getId());
                    categoryDO.setGmtCreate(currentCategoryDO.getGmtCreate());
                    categoryDO.setGmtUpdate(currentCategoryDO.getGmtUpdate());
                    if (!categoryDO.equals(currentCategoryDO)) {
                        log.info("修改分类，分类url：{}", categoryUrl);
                        updateDOS.add(categoryDO);
                    }
                } else {
                    log.info("新增分类，分类url：{}", categoryUrl);
                    addDOS.add(categoryDO);
                }
                if (updateDOS.size() >= 200) {
                    log.info("批量修改分类");
                    categoryManager.batchUpdateByPrimaryKeySelective(updateDOS);
                    updateDOS.clear();
                }
                if (addDOS.size() >= 200) {
                    log.info("批量新增分类");
                    categoryManager.batchInsert(addDOS);
                    addDOS.clear();
                }
            }
            if (updateDOS.size() > 0) {
                log.info("批量更新剩余分类，剩余数量：{}", updateDOS.size());
                categoryManager.batchUpdateByPrimaryKeySelective(updateDOS);
            }
            if (addDOS.size() > 0) {
                log.info("批量新增剩余分类，剩余数量：{}", addDOS.size());
                categoryManager.batchInsert(addDOS);
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
            SplitterDTO splitterDTO = categoryManager.selectNoCrawledMinMaxId();
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(ZuofanCategoryQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    List<ZuofanCategoryDO> categoryDOS = categoryManager.selectNotCrawledWithSplitter(inputSplit.toString());
                    if (CollectionUtils.isEmpty(categoryDOS)) {
                        log.info("该分片无未爬取的分类页面，分片：{}", inputSplit.toString());
                        return;
                    }
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    for (ZuofanCategoryDO categoryDO : categoryDOS) {
                        String categoryUrl = categoryDO.getCategoryUrl();
                        CookbookListPage cookbookListPage = new CookbookListPage();
                        cookbookListPage.setNextUrl(categoryUrl);
                        cookbookListPage.setHasNext(true);
                        while (cookbookListPage.isHasNext()) {
                            try {
                                log.info("该分片 {} 线程 {} 暂停3秒", inputSplit.toString(), Thread.currentThread().getName());
                                Thread.sleep(3000L);
                            } catch (InterruptedException e) {
                                log.error("线程暂停错误");
                                log.error(e.getMessage(), e);
                            }
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
                                    ZuofanCookbookUrlDO cookbookUrlDO = new ZuofanCookbookUrlDO();
                                    cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                    cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                    cookbookUrlDO.setCookbookUrl(urlValue);
                                    cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                    ZuofanCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(urlValue);
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
                                    ZuofanCategoryCookbookRelationDO currentRelationDO =
                                            categoryCookbookRelationManager.selectByCookbookUrlIdAndCategoryId(cookbookUrlDO.getId(), categoryDO.getId());
                                    if (null != currentRelationDO) {
                                        if (!url.equals(currentRelationDO.getCategoryLocationUrl())) {
                                            log.info("修改分类关系");
                                            currentRelationDO.setCategoryLocationUrl(url);
                                            categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                        }
                                    } else {
                                        log.info("新增分类关系");
                                        currentRelationDO = new ZuofanCategoryCookbookRelationDO();
                                        currentRelationDO.setCategoryId(categoryDO.getId());
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
                        categoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        categoryManager.updateByPrimaryKeySelective(categoryDO);
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(ZuofanCookbookUrlQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    String splitterClause = inputSplit.toString();
                    List<ZuofanCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                        log.info("该分片无未爬取的食谱页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = cookbookUrlDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    WebClient webClient = HtmlUnitHelper.getWebClient();
//                    List<ZuofanCookbookDetailDO> addDetailDOS = Lists.newArrayList();
//                    List<ZuofanCookbookDetailDO> updateDetailDOS = Lists.newArrayList();
//                    List<ZuofanCookbookUrlDO> updateStatusDOS = Lists.newArrayList();
                    int index = 0;
                    for (ZuofanCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
                        log.info("现在爬取该分片 {} 第 {} 条数据，还剩 {} 条数据", splitterClause, ++index, size - index);
                        try {
                            long time = CommonUtils.generateRandomMillisecond();
                            log.info("该分片 {} 线程 {} 暂停 {} 毫秒", splitterClause, Thread.currentThread().getName(), time);
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            log.error("线程暂停错误");
                            log.error(e.getMessage(), e);
                        }
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
                            ZuofanCookbookDetailDO cookbookDetailDO = new ZuofanCookbookDetailDO();
                            cookbookDetailDO.setCookbookUrlId(cookbookUrlDO.getId());
                            cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                            cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                            cookbookDetailDO.setIngredients(JSON.toJSONString(cookbookDetailPage.getIngredients()));
                            cookbookDetailDO.setSeasonings(JSON.toJSONString(cookbookDetailPage.getSeasonings()));
                            cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetailPage.getSteps()));
                            cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                            cookbookDetailDO.setCryptolalia(cookbookDetailPage.getCryptolalia());
                            ZuofanCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrlId(cookbookUrlDO.getId());
                            if (null != currentDetailDO) {
                                cookbookDetailDO.setId(currentDetailDO.getId());
                                cookbookDetailDO.setGmtCreate(currentDetailDO.getGmtCreate());
                                cookbookDetailDO.setGmtUpdate(currentDetailDO.getGmtUpdate());
                                if (!cookbookDetailDO.equals(currentDetailDO)) {
                                    log.info("更新食谱明细");
                                    cookbookDetailManager.updateByPrimaryKeySelective(cookbookDetailDO);
//                                    updateDetailDOS.add(cookbookDetailDO);
                                }
                            } else {
                                log.info("新增食谱明细");
                                cookbookDetailManager.insertSelective(cookbookDetailDO);
//                                addDetailDOS.add(cookbookDetailDO);
                            }
                            log.info("更新爬取状态");
                            cookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                            cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
//                            updateStatusDOS.add(cookbookUrlDO);
//                            batchAddUpdate(addDetailDOS, updateDetailDOS, updateStatusDOS, 24);
                        } catch (Exception e) {
                            log.error("存储页面数据错误：{}", url);
                            log.error(e.getMessage(), e);
                        }
                    }
                    webClient.close();
//                    batchAddUpdate(addDetailDOS, updateDetailDOS, updateStatusDOS, 0);
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

    private void batchAddUpdate(List<ZuofanCookbookDetailDO> addDetailDOS,
                                List<ZuofanCookbookDetailDO> updateDetailDOS,
                                List<ZuofanCookbookUrlDO> updateStatusDOS,
                                int size) {
        if (addDetailDOS.size() > size) {
            log.info("批量新增食谱明细");
            cookbookDetailManager.batchInsert(addDetailDOS);
            addDetailDOS.clear();
        }
        if (updateDetailDOS.size() > size) {
            log.info("批量更新食谱明细");
            cookbookDetailManager.batchUpdateByPrimaryKeySelective(updateDetailDOS);
            updateDetailDOS.clear();
        }
        if (updateStatusDOS.size() > size) {
            log.info("批量更新爬取状态");
            cookbookUrlManager.batchUpdateByPrimaryKeySelective(updateStatusDOS);
            updateStatusDOS.clear();
        }
    }

}
