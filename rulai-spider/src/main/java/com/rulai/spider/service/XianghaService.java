package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.component.splitter.BigDecimalSplitter;
import com.rulai.common.component.splitter.InputSplit;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.xiangha.CategoryPage;
import com.rulai.spider.bean.crawl.xiangha.CookbookDetailPage;
import com.rulai.spider.bean.crawl.xiangha.CookbookListPage;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.XianghaCategoryCookbookRelationDO;
import com.rulai.spider.bean.model.XianghaCategoryDO;
import com.rulai.spider.bean.model.XianghaCookbookDetailDO;
import com.rulai.spider.bean.model.XianghaCookbookUrlDO;
import com.rulai.spider.bean.query.XianghaCategoryQuery;
import com.rulai.spider.bean.query.XianghaCookbookUrlQuery;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.XianghaCategoryCookbookRelationManager;
import com.rulai.spider.manager.XianghaCategoryManager;
import com.rulai.spider.manager.XianghaCookbookDetailManager;
import com.rulai.spider.manager.XianghaCookbookUrlManager;
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
public class XianghaService {

    @Autowired
    private XianghaCategoryManager categoryManager;

    @Autowired
    private XianghaCookbookUrlManager cookbookUrlManager;

    @Autowired
    private XianghaCategoryCookbookRelationManager categoryCookbookRelationManager;

    @Autowired
    private XianghaCookbookDetailManager cookbookDetailManager;

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
            List<XianghaCategoryDO> updateDOS = Lists.newArrayList();
            List<XianghaCategoryDO> addDOS = Lists.newArrayList();
            for (CategoryPage.Category category : categoryPage.getCategories()) {
                String categoryUrl = category.getCategoryUrl();
                XianghaCategoryDO categoryDO = new XianghaCategoryDO();
                categoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                categoryDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                categoryDO.setFirstCategoryName(category.getFirstCategoryName());
                categoryDO.setSecondCategoryName(category.getSecondCategoryName());
                categoryDO.setCategoryUrl(categoryUrl);
                XianghaCategoryDO currentCategoryDO = categoryManager.selectByCategoryUrl(categoryUrl);
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(XianghaCategoryQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    String splitterClause = inputSplit.toString();
                    List<XianghaCategoryDO> categoryDOS = categoryManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(categoryDOS)) {
                        log.info("该分片无未爬取的分类页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = categoryDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    int index = 0;
                    for (XianghaCategoryDO categoryDO : categoryDOS) {
                        log.info("现在爬取该分片 {} 第 {} 条数据，还剩 {} 条数据", splitterClause, ++index, size - index);
                        String categoryUrl = categoryDO.getCategoryUrl();
                        CookbookListPage cookbookListPage = new CookbookListPage();
                        cookbookListPage.setNextUrl(categoryUrl);
                        cookbookListPage.setHasNext(true);
                        boolean isSuccess = true;
                        while (cookbookListPage.isHasNext()) {
                            try {
                                long time = CommonUtils.generateRandomMillisecond();
                                log.info("该分片 {} 线程 {} 暂停 {} 毫秒", splitterClause, Thread.currentThread().getName(), time);
                                Thread.sleep(time);
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
                                isSuccess = false;
                                continue;
                            }
                            cookbookListPage = crawlResult.getData();
                            for (CookbookListPage.CookbookUrl cookbookUrl : cookbookListPage.getCookbookUrls()) {
                                try {
                                    String urlValue = cookbookUrl.getCookbookUrl();
                                    XianghaCookbookUrlDO cookbookUrlDO = new XianghaCookbookUrlDO();
                                    cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                    cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                    cookbookUrlDO.setCookbookUrl(urlValue);
                                    cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                    XianghaCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(urlValue);
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
                                    XianghaCategoryCookbookRelationDO currentRelationDO =
                                            categoryCookbookRelationManager.selectByCookbookUrlIdAndCategoryId(cookbookUrlDO.getId(), categoryDO.getId());
                                    if (null != currentRelationDO) {
                                        if (!url.equals(currentRelationDO.getCategoryLocationUrl())) {
                                            log.info("修改分类关系");
                                            currentRelationDO.setCategoryLocationUrl(url);
                                            categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                        }
                                    } else {
                                        log.info("新增分类关系");
                                        currentRelationDO = new XianghaCategoryCookbookRelationDO();
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
                        if (isSuccess) {
                            categoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        } else {
                            categoryDO.setIsEffective(IsEffectiveEnum.NO.getCode());
                        }
                        categoryManager.updateByPrimaryKeySelective(categoryDO);
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(XianghaCookbookUrlQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    String splitterClause = inputSplit.toString();
                    List<XianghaCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                        log.info("该分片无未爬取的食谱页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = cookbookUrlDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    int index = 0;
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    for (XianghaCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
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
                            XianghaCookbookDetailDO cookbookDetailDO = new XianghaCookbookDetailDO();
                            cookbookDetailDO.setCookbookUrlId(cookbookUrlDO.getId());
                            cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                            cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                            cookbookDetailDO.setIngredients(JSON.toJSONString(cookbookDetailPage.getIngredients()));
                            cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetailPage.getSteps()));
                            cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                            XianghaCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrlId(cookbookUrlDO.getId());
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
