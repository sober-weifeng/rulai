package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.component.splitter.BigDecimalSplitter;
import com.rulai.common.component.splitter.InputSplit;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.douguo.CategoryPage;
import com.rulai.spider.bean.crawl.douguo.CookbookDetailPage;
import com.rulai.spider.bean.crawl.douguo.CookbookListPage;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.DouguoCategoryCookbookRelationDO;
import com.rulai.spider.bean.model.DouguoCategoryDO;
import com.rulai.spider.bean.model.DouguoCookbookDetailDO;
import com.rulai.spider.bean.model.DouguoCookbookUrlDO;
import com.rulai.spider.bean.query.DouguoCategoryQuery;
import com.rulai.spider.bean.query.DouguoCookbookUrlQuery;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.DouguoCategoryCookbookRelationManager;
import com.rulai.spider.manager.DouguoCategoryManager;
import com.rulai.spider.manager.DouguoCookbookDetailManager;
import com.rulai.spider.manager.DouguoCookbookUrlManager;
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
public class DouguoService {

    @Autowired
    private DouguoCategoryManager categoryManager;

    @Autowired
    private DouguoCookbookUrlManager cookbookUrlManager;

    @Autowired
    private DouguoCategoryCookbookRelationManager categoryCookbookRelationManager;

    @Autowired
    private DouguoCookbookDetailManager cookbookDetailManager;

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
            List<DouguoCategoryDO> updateDOS = Lists.newArrayList();
            List<DouguoCategoryDO> addDOS = Lists.newArrayList();
            for (CategoryPage.Category category : categoryPage.getCategories()) {
                String categoryUrl = category.getCategoryUrl();
                DouguoCategoryDO categoryDO = new DouguoCategoryDO();
                categoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                categoryDO.setFirstCategoryName(category.getFirstCategoryName());
                categoryDO.setSecondCategoryName(category.getSecondCategoryName());
                categoryDO.setThirdCategoryName(category.getThirdCategoryName());
                categoryDO.setCategoryUrl(categoryUrl);
                DouguoCategoryDO currentCategoryDO = categoryManager.selectByCategoryUrl(categoryUrl);
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
                if (updateDOS.size() >= 50) {
                    log.info("批量修改分类");
                    categoryManager.batchUpdateByPrimaryKeySelective(updateDOS);
                    updateDOS.clear();
                }
                if (addDOS.size() >= 100) {
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(DouguoCategoryQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    List<DouguoCategoryDO> categoryDOS = categoryManager.selectNotCrawledWithSplitter(inputSplit.toString());
                    if (CollectionUtils.isEmpty(categoryDOS)) {
                        log.info("该分片无未爬取的分类页面，分片：{}", inputSplit.toString());
                        return;
                    }
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    for (DouguoCategoryDO categoryDO : categoryDOS) {
                        String categoryUrl = categoryDO.getCategoryUrl();
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
                                    DouguoCookbookUrlDO cookbookUrlDO = new DouguoCookbookUrlDO();
                                    cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                    cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                    cookbookUrlDO.setCookbookUrl(urlValue);
                                    cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                    DouguoCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(urlValue);
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
                                    DouguoCategoryCookbookRelationDO currentRelationDO =
                                            categoryCookbookRelationManager.selectByCookbookUrlIdAndCategoryId(cookbookUrlDO.getId(), categoryDO.getId());
                                    if (null != currentRelationDO) {
                                        if (!url.equals(currentRelationDO.getCategoryLocationUrl())) {
                                            log.info("修改分类关系");
                                            currentRelationDO.setCategoryLocationUrl(url);
                                            categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                        }
                                    } else {
                                        log.info("新增分类关系");
                                        currentRelationDO = new DouguoCategoryCookbookRelationDO();
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
            List<InputSplit> inputSplits = bigDecimalSplitter.split(DouguoCookbookUrlQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    List<DouguoCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawledWithSplitter(inputSplit.toString());
                    if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                        log.info("该分片无未爬取的食谱页面，分片：{}", inputSplit.toString());
                        return;
                    }
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    List<DouguoCookbookDetailDO> addDetailDOS = Lists.newArrayList();
                    List<DouguoCookbookDetailDO> updateDetailDOS = Lists.newArrayList();
                    List<DouguoCookbookUrlDO> updateStatusDOS = Lists.newArrayList();
                    for (DouguoCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
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
                            DouguoCookbookDetailDO cookbookDetailDO = new DouguoCookbookDetailDO();
                            cookbookDetailDO.setCookbookUrl(url);
                            cookbookDetailDO.setCookbookName(cookbookUrlDO.getCookbookName());
                            cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                            cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                            cookbookDetailDO.setLabels(cookbookDetailPage.getLabels());
                            cookbookDetailDO.setIngredients(JSON.toJSONString(cookbookDetailPage.getIngredients()));
                            cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetailPage.getSteps()));
                            cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                            DouguoCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrl(url);
                            if (null != currentDetailDO) {
                                cookbookDetailDO.setId(currentDetailDO.getId());
                                cookbookDetailDO.setGmtCreate(currentDetailDO.getGmtCreate());
                                cookbookDetailDO.setGmtUpdate(currentDetailDO.getGmtUpdate());
                                if (!cookbookDetailDO.equals(currentDetailDO)) {
                                    log.info("更新食谱明细");
//                                    cookbookDetailManager.updateByPrimaryKeySelective(cookbookDetailDO);
                                    updateDetailDOS.add(cookbookDetailDO);
                                }
                            } else {
                                log.info("新增食谱明细");
//                                cookbookDetailManager.insertSelective(cookbookDetailDO);
                                addDetailDOS.add(cookbookDetailDO);
                            }
                            log.info("更新爬取状态");
//                            cookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
//                            cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                            updateStatusDOS.add(cookbookUrlDO);
                            batchAddUpdate(addDetailDOS, updateDetailDOS, updateStatusDOS, 999);
                        } catch (Exception e) {
                            log.error("存储页面数据错误：{}", url);
                            log.error(e.getMessage(), e);
                        }
                    }
                    webClient.close();
                    batchAddUpdate(addDetailDOS, updateDetailDOS, updateStatusDOS, 0);
                });
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    private void batchAddUpdate(List<DouguoCookbookDetailDO> addDetailDOS,
                                List<DouguoCookbookDetailDO> updateDetailDOS,
                                List<DouguoCookbookUrlDO> updateStatusDOS,
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
