package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.component.splitter.BigDecimalSplitter;
import com.rulai.common.component.splitter.InputSplit;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.fancai.CategoryPage;
import com.rulai.spider.bean.crawl.fancai.CookbookDetailPage;
import com.rulai.spider.bean.crawl.fancai.CookbookListPage;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.FancaiCategoryCookbookRelationDO;
import com.rulai.spider.bean.model.FancaiCategoryDO;
import com.rulai.spider.bean.model.FancaiCookbookDetailDO;
import com.rulai.spider.bean.model.FancaiCookbookUrlDO;
import com.rulai.spider.bean.query.FancaiCategoryQuery;
import com.rulai.spider.bean.query.ZuofanCookbookUrlQuery;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.FancaiCategoryCookbookRelationManager;
import com.rulai.spider.manager.FancaiCategoryManager;
import com.rulai.spider.manager.FancaiCookbookDetailManager;
import com.rulai.spider.manager.FancaiCookbookUrlManager;
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
public class FancaiService {

    @Autowired
    private FancaiCategoryManager categoryManager;

    @Autowired
    private FancaiCookbookUrlManager cookbookUrlManager;

    @Autowired
    private FancaiCategoryCookbookRelationManager categoryCookbookRelationManager;

    @Autowired
    private FancaiCookbookDetailManager cookbookDetailManager;

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
            List<FancaiCategoryDO> updateDOS = Lists.newArrayList();
            List<FancaiCategoryDO> addDOS = Lists.newArrayList();
            for (CategoryPage.Category category : categoryPage.getCategories()) {
                String categoryUrl = category.getCategoryUrl();
                FancaiCategoryDO categoryDO = new FancaiCategoryDO();
                categoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                categoryDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                categoryDO.setFirstCategoryName(category.getFirstCategoryName());
                categoryDO.setSecondCategoryName(category.getSecondCategoryName());
                categoryDO.setCategoryUrl(categoryUrl);
                FancaiCategoryDO currentCategoryDO = categoryManager.selectByCategoryUrl(categoryUrl);
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(FancaiCategoryQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    String splitterClause = inputSplit.toString();
                    List<FancaiCategoryDO> categoryDOS = categoryManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(categoryDOS)) {
                        log.info("该分片无未爬取的分类页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = categoryDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    int index = 0;
                    for (FancaiCategoryDO categoryDO : categoryDOS) {
                        log.info("现在爬取该分片 {} 第 {} 条数据，还剩 {} 条数据", splitterClause, ++index, size - index);
                        String categoryUrl = categoryDO.getCategoryUrl();
                        CookbookListPage cookbookListPage = new CookbookListPage();
                        cookbookListPage.setNextUrl(categoryUrl);
                        cookbookListPage.setHasNext(true);
                        boolean isSuccess = true;
                        while (cookbookListPage.isHasNext()) {
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
                                    FancaiCookbookUrlDO cookbookUrlDO = new FancaiCookbookUrlDO();
                                    cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                    cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                    cookbookUrlDO.setCookbookUrl(urlValue);
                                    cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                    FancaiCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(urlValue);
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
                                    FancaiCategoryCookbookRelationDO currentRelationDO =
                                            categoryCookbookRelationManager.selectByCookbookUrlIdAndCategoryId(cookbookUrlDO.getId(), categoryDO.getId());
                                    if (null != currentRelationDO) {
                                        if (!url.equals(currentRelationDO.getCategoryLocationUrl())) {
                                            log.info("修改分类关系");
                                            currentRelationDO.setCategoryLocationUrl(url);
                                            categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                        }
                                    } else {
                                        log.info("新增分类关系");
                                        currentRelationDO = new FancaiCategoryCookbookRelationDO();
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(ZuofanCookbookUrlQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    String splitterClause = inputSplit.toString();
                    List<FancaiCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                        log.info("该分片无未爬取的食谱页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = cookbookUrlDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    int index = 0;
                    WebClient webClient = HtmlUnitHelper.getWebClient();
//                    List<ZuofanCookbookDetailDO> addDetailDOS = Lists.newArrayList();
//                    List<ZuofanCookbookDetailDO> updateDetailDOS = Lists.newArrayList();
//                    List<ZuofanCookbookUrlDO> updateStatusDOS = Lists.newArrayList();
                    for (FancaiCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
                        log.info("现在爬取该分片 {} 第 {} 条数据，还剩 {} 条数据", splitterClause, ++index, size - index);
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
                            FancaiCookbookDetailDO cookbookDetailDO = new FancaiCookbookDetailDO();
                            cookbookDetailDO.setCookbookUrlId(cookbookUrlDO.getId());
                            cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                            cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                            cookbookDetailDO.setMainIngredients(JSON.toJSONString(cookbookDetailPage.getMainIngredients()));
                            cookbookDetailDO.setSupIngredients(JSON.toJSONString(cookbookDetailPage.getSupIngredients()));
                            cookbookDetailDO.setSeasonings(JSON.toJSONString(cookbookDetailPage.getSeasonings()));
                            cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetailPage.getSteps()));
                            cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                            FancaiCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrlId(cookbookUrlDO.getId());
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

    private void batchAddUpdate(List<FancaiCookbookDetailDO> addDetailDOS,
                                List<FancaiCookbookDetailDO> updateDetailDOS,
                                List<FancaiCookbookUrlDO> updateStatusDOS,
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
