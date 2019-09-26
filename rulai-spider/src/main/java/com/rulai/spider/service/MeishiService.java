package com.rulai.spider.service;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.component.splitter.BigDecimalSplitter;
import com.rulai.common.component.splitter.InputSplit;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.meishi.CategoryPage;
import com.rulai.spider.bean.crawl.meishi.CookbookDetailPage;
import com.rulai.spider.bean.crawl.meishi.CookbookListPage;
import com.rulai.spider.bean.dto.SplitterDTO;
import com.rulai.spider.bean.model.MeishiCategoryCookbookRelationDO;
import com.rulai.spider.bean.model.MeishiCategoryDO;
import com.rulai.spider.bean.model.MeishiCookbookDetailDO;
import com.rulai.spider.bean.model.MeishiCookbookUrlDO;
import com.rulai.spider.bean.query.FancaiCategoryQuery;
import com.rulai.spider.bean.query.ZuofanCookbookUrlQuery;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.MeishiCategoryCookbookRelationManager;
import com.rulai.spider.manager.MeishiCategoryManager;
import com.rulai.spider.manager.MeishiCookbookDetailManager;
import com.rulai.spider.manager.MeishiCookbookUrlManager;
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
public class MeishiService {

    @Autowired
    private MeishiCategoryManager categoryManager;

    @Autowired
    private MeishiCookbookUrlManager cookbookUrlManager;

    @Autowired
    private MeishiCategoryCookbookRelationManager categoryCookbookRelationManager;

    @Autowired
    private MeishiCookbookDetailManager cookbookDetailManager;

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
            List<MeishiCategoryDO> updateDOS = Lists.newArrayList();
            List<MeishiCategoryDO> addDOS = Lists.newArrayList();
            for (CategoryPage.Category category : categoryPage.getCategories()) {
                String categoryUrl = category.getCategoryUrl();
                MeishiCategoryDO categoryDO = new MeishiCategoryDO();
                categoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                categoryDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                categoryDO.setFirstCategoryName(category.getFirstCategoryName());
                categoryDO.setSecondCategoryName(category.getSecondCategoryName());
                categoryDO.setCategoryUrl(categoryUrl);
                MeishiCategoryDO currentCategoryDO = categoryManager.selectByCategoryUrl(categoryUrl);
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
            int splitNum = 5;
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
                    List<MeishiCategoryDO> categoryDOS = categoryManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(categoryDOS)) {
                        log.info("该分片无未爬取的分类页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = categoryDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    int index = 0;
                    for (MeishiCategoryDO categoryDO : categoryDOS) {
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
                                    MeishiCookbookUrlDO cookbookUrlDO = new MeishiCookbookUrlDO();
                                    cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                    cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                    cookbookUrlDO.setCookbookUrl(urlValue);
                                    cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                    MeishiCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(urlValue);
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
                                    MeishiCategoryCookbookRelationDO currentRelationDO =
                                            categoryCookbookRelationManager.selectByCookbookUrlIdAndCategoryId(cookbookUrlDO.getId(), categoryDO.getId());
                                    if (null != currentRelationDO) {
                                        if (!url.equals(currentRelationDO.getCategoryLocationUrl())) {
                                            log.info("修改分类关系");
                                            currentRelationDO.setCategoryLocationUrl(url);
                                            categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                        }
                                    } else {
                                        log.info("新增分类关系");
                                        currentRelationDO = new MeishiCategoryCookbookRelationDO();
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
            int splitNum = 1;
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
                    List<MeishiCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawledWithSplitter(splitterClause);
                    if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                        log.info("该分片无未爬取的食谱页面，分片：{}", splitterClause);
                        return;
                    }
                    int size = cookbookUrlDOS.size();
                    log.info("该分片 {} 数量：{}", splitterClause, size);
                    int index = 0;
                    WebClient webClient = HtmlUnitHelper.getWebClient();
                    for (MeishiCookbookUrlDO cookbookUrlDO : cookbookUrlDOS) {
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
                            MeishiCookbookDetailDO cookbookDetailDO = new MeishiCookbookDetailDO();
                            cookbookDetailDO.setCookbookUrlId(cookbookUrlDO.getId());
                            cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                            cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                            cookbookDetailDO.setMainIngredients(JSON.toJSONString(cookbookDetailPage.getMainIngredients()));
                            cookbookDetailDO.setSupIngredients(JSON.toJSONString(cookbookDetailPage.getSupIngredients()));
                            cookbookDetailDO.setLabels(JSON.toJSONString(cookbookDetailPage.getLabels()));
                            cookbookDetailDO.setSteps(JSON.toJSONString(cookbookDetailPage.getSteps()));
                            cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                            MeishiCookbookDetailDO currentDetailDO = cookbookDetailManager.selectByCookbookUrlId(cookbookUrlDO.getId());
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
