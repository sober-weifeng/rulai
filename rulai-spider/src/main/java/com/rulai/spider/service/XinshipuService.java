package com.rulai.spider.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.component.splitter.BigDecimalSplitter;
import com.rulai.common.component.splitter.InputSplit;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.bean.crawl.xinshipu.CategoryPage;
import com.rulai.spider.bean.crawl.xinshipu.CookbookDetailPage;
import com.rulai.spider.bean.crawl.xinshipu.CookbookListPage;
import com.rulai.spider.bean.dto.xinshipu.CategoryNoCrawledMinMaxIdDTO;
import com.rulai.spider.bean.dto.xinshipu.CookbookUrlNoCrawledMinMaxIdDTO;
import com.rulai.spider.bean.model.XinshipuCategoryCookbookRelationDO;
import com.rulai.spider.bean.model.XinshipuCategoryDO;
import com.rulai.spider.bean.model.XinshipuCookbookDetailDO;
import com.rulai.spider.bean.model.XinshipuCookbookUrlDO;
import com.rulai.spider.bean.query.XinshipuCategoryQuery;
import com.rulai.spider.components.HtmlUnitHelper;
import com.rulai.spider.enums.IsCrawledEnum;
import com.rulai.spider.enums.IsEffectiveEnum;
import com.rulai.spider.manager.XinshipuCategoryCookbookRelationManager;
import com.rulai.spider.manager.XinshipuCategoryManager;
import com.rulai.spider.manager.XinshipuCookbookDetailManager;
import com.rulai.spider.manager.XinshipuCookbookUrlManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/6 10:24
 */
@Component
@Slf4j
public class XinshipuService {
    
    @Autowired
    private XinshipuCategoryManager categoryManager;
    
    @Autowired
    private XinshipuCookbookUrlManager cookbookUrlManager;
    
    @Autowired
    private XinshipuCategoryCookbookRelationManager categoryCookbookRelationManager;
    
    @Autowired
    private XinshipuCookbookDetailManager cookbookDetailManager;
    
    public BizResult crawlCategory() {
        BizResult result = BizResult.custom();
        try {
            String url = "https://www.xinshipu.com/chuyoufenlei/";
            WebClient webClient = HtmlUnitHelper.getWebClient();
            CategoryPage categoryPage = new CategoryPage();
            categoryPage.setHasNext(true);
            categoryPage.setNextUrl(url);
            while (categoryPage.isHasNext()) {
                categoryPage = CategoryPage.crawl(categoryPage.getNextUrl(), webClient);
                if (null == categoryPage) {
                    log.error("爬取分类数据为空");
                    categoryPage.setHasNext(false);
                    continue;
                }
                for (CategoryPage.Category category : categoryPage.getCategories()) {
                    XinshipuCategoryDO categoryDO = new XinshipuCategoryDO();
                    categoryDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                    categoryDO.setCategoryName(category.getCategoryName());
                    categoryDO.setCategoryUrl(category.getCategoryUrl());
                    XinshipuCategoryDO currentDO = categoryManager.selectByCategoryUrl(category.getCategoryUrl());
                    if (null != currentDO) {
                        if (!categoryDO.getCategoryName().equals(currentDO.getCategoryName())) {
                            categoryDO.setId(currentDO.getId());
                            categoryManager.updateByPrimaryKeySelective(categoryDO);
                        }
                    } else {
                        categoryManager.insertSelective(categoryDO);
                    }
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

    public BizResult crawlCookbookUrlWithSplitter() {
        BizResult result = BizResult.custom();
        try {
            CategoryNoCrawledMinMaxIdDTO categoryNoCrawledMinMaxIdDTO = categoryManager.selectCategoryNoCrawledMinMaxId();
            if (null == categoryNoCrawledMinMaxIdDTO) {
                return result.success("无查询最大最小id分片内容");
            }
            if (categoryNoCrawledMinMaxIdDTO.getTotalCount() == 0) {
                return result.success("无未爬取的分类页面");
            }
            int splitNum = 15;
            BigDecimal numSplits = new BigDecimal(splitNum);
            BigDecimal maxVal = categoryNoCrawledMinMaxIdDTO.getMaxVal();
            BigDecimal minVal = categoryNoCrawledMinMaxIdDTO.getMinVal();
            ExecutorService fixedThreadPool = new ThreadPoolExecutor(splitNum, splitNum,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>());
            BigDecimalSplitter bigDecimalSplitter = new BigDecimalSplitter();
            List<InputSplit> inputSplits = bigDecimalSplitter.split(XinshipuCategoryQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    try {
                        List<XinshipuCategoryDO> categoryDOS = categoryManager.selectNotCrawledWithSplitter(inputSplit.toString());
                        if (CollectionUtils.isEmpty(categoryDOS)) {
                            log.info("该分片无未爬取的分类页面，分片：{}", inputSplit.toString());
                            return;
                        }
                        WebClient webClient = HtmlUnitHelper.getWebClient();
                        for (XinshipuCategoryDO categoryDO : categoryDOS) {
                            String categoryUrl = categoryDO.getCategoryUrl();
                            CookbookListPage cookbookListPage = new CookbookListPage();
                            cookbookListPage.setHasNext(true);
                            cookbookListPage.setNextUrl(categoryUrl);
                            while (cookbookListPage.isHasNext()) {
                                String url = cookbookListPage.getNextUrl();
                                try {
                                    cookbookListPage = CookbookListPage.crawl(url, webClient);
                                    if (null == cookbookListPage) {
                                        log.error("未爬取到内容");
                                        cookbookListPage = new CookbookListPage();
                                        cookbookListPage.setHasNext(false);
                                        continue;
                                    }
                                    for (CookbookListPage.CookbookUrl cookbookUrl : cookbookListPage.getCookbookUrls()) {
                                        try {
                                            XinshipuCookbookUrlDO cookbookUrlDO = new XinshipuCookbookUrlDO();
                                            cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                            cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                            cookbookUrlDO.setCookbookUrl(cookbookUrl.getCookbookUrl());
                                            cookbookUrlDO.setLocationUrl(url);
                                            cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                            XinshipuCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(cookbookUrl.getCookbookUrl());
                                            if (null != currentUrlDO) {
                                                cookbookUrlDO.setId(currentUrlDO.getId());
                                                if (!(cookbookUrlDO.getCookbookName().equals(currentUrlDO.getCookbookName()))) {
                                                    cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                                                }
                                            } else {
                                                cookbookUrlManager.insertSelective(cookbookUrlDO);
                                            }
                                            XinshipuCategoryCookbookRelationDO currentRelationDO = categoryCookbookRelationManager.selectByCookbookUrlIdAndCategoryId(cookbookUrlDO.getId(), categoryDO.getId());
                                            if (null == currentRelationDO) {
                                                XinshipuCategoryCookbookRelationDO relationDO = new XinshipuCategoryCookbookRelationDO();
                                                relationDO.setCategoryId(categoryDO.getId());
                                                relationDO.setCookbookUrlId(cookbookUrlDO.getId());
                                                relationDO.setCategoryLocationUrl(url);
                                                categoryCookbookRelationManager.insertSelective(relationDO);
                                            } else {
                                                if (!(url.equals(currentRelationDO.getCategoryLocationUrl()))) {
                                                    currentRelationDO.setCategoryLocationUrl(url);
                                                    categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                                }
                                            }
                                        } catch (Exception e) {
                                            log.error("存储页面数据错误：{}", url);
                                            log.error(e.getMessage(), e);
                                        }
                                    }
                                } catch (Exception e) {
                                    log.error("爬取分类页面异常：{}", url);
                                    log.error(e.getMessage(), e);
                                    cookbookListPage = new CookbookListPage();
                                    cookbookListPage.setHasNext(false);
                                }
                            }
                            categoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                            categoryManager.updateByPrimaryKeySelective(categoryDO);
                        }
                        webClient.close();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                });
            }
            result.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public BizResult crawlCookbookUrlWithThread() {
        BizResult result = BizResult.custom();
        try {
            List<XinshipuCategoryDO> categoryDOS = categoryManager.selectNotCrawled();
            if (CollectionUtils.isEmpty(categoryDOS)) {
                return result.success("无未爬取的分类页面");
            }
            int splitNum = 15;
            ExecutorService fixedThreadPool = new ThreadPoolExecutor(splitNum, splitNum,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>());
            for (XinshipuCategoryDO categoryDO : categoryDOS) {
                fixedThreadPool.submit(() -> {
                    try {
                        WebClient webClient = HtmlUnitHelper.getWebClient();
                        String categoryUrl = categoryDO.getCategoryUrl();
                        CookbookListPage cookbookListPage = new CookbookListPage();
                        cookbookListPage.setHasNext(true);
                        cookbookListPage.setNextUrl(categoryUrl);
                        while (cookbookListPage.isHasNext()) {
                            String url = cookbookListPage.getNextUrl();
                            try {
                                cookbookListPage = CookbookListPage.crawl(url, webClient);
                                if (null == cookbookListPage) {
                                    log.error("未爬取到内容");
                                    cookbookListPage = new CookbookListPage();
                                    cookbookListPage.setHasNext(false);
                                    continue;
                                }
                                for (CookbookListPage.CookbookUrl cookbookUrl : cookbookListPage.getCookbookUrls()) {
                                    try {
                                        XinshipuCookbookUrlDO cookbookUrlDO = new XinshipuCookbookUrlDO();
                                        cookbookUrlDO.setIsCrawled(IsCrawledEnum.NO.getCode());
                                        cookbookUrlDO.setCookbookName(cookbookUrl.getCookbookName());
                                        cookbookUrlDO.setCookbookUrl(cookbookUrl.getCookbookUrl());
                                        cookbookUrlDO.setLocationUrl(url);
                                        cookbookUrlDO.setIsEffective(IsEffectiveEnum.YES.getCode());
                                        XinshipuCookbookUrlDO currentUrlDO = cookbookUrlManager.selectByCookbookUrl(cookbookUrl.getCookbookUrl());
                                        if (null != currentUrlDO) {
                                            cookbookUrlDO.setId(currentUrlDO.getId());
                                            if (!(cookbookUrlDO.getCookbookName().equals(currentUrlDO.getCookbookName()))) {
                                                cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                                            }
                                        } else {
                                            cookbookUrlManager.insertSelective(cookbookUrlDO);
                                        }
                                        XinshipuCategoryCookbookRelationDO currentRelationDO = categoryCookbookRelationManager.selectByCookbookUrlIdAndCategoryId(cookbookUrlDO.getId(), categoryDO.getId());
                                        if (null == currentRelationDO) {
                                            XinshipuCategoryCookbookRelationDO relationDO = new XinshipuCategoryCookbookRelationDO();
                                            relationDO.setCategoryId(categoryDO.getId());
                                            relationDO.setCookbookUrlId(cookbookUrlDO.getId());
                                            relationDO.setCategoryLocationUrl(url);
                                            categoryCookbookRelationManager.insertSelective(relationDO);
                                        } else {
                                            if (!(url.equals(currentRelationDO.getCategoryLocationUrl()))) {
                                                currentRelationDO.setCategoryLocationUrl(url);
                                                categoryCookbookRelationManager.updateByPrimaryKeySelective(currentRelationDO);
                                            }
                                        }
                                    } catch (Exception e) {
                                        log.error("存储页面数据错误：{}", url);
                                        log.error(e.getMessage(), e);
                                    }
                                }
                            } catch (Exception e) {
                                log.error("爬取分类页面异常：{}", url);
                                log.error(e.getMessage(), e);
                                cookbookListPage = new CookbookListPage();
                                cookbookListPage.setHasNext(false);
                            }
                        }
                        categoryDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                        categoryManager.updateByPrimaryKeySelective(categoryDO);
                        webClient.close();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
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
            CookbookUrlNoCrawledMinMaxIdDTO cookbookUrlNoCrawledMinMaxIdDTO = cookbookUrlManager.selectCookbookUrlNoCrawledMinMaxId();
            if (null == cookbookUrlNoCrawledMinMaxIdDTO) {
                return result.success("无查询最大最小id分片内容");
            }
            if (cookbookUrlNoCrawledMinMaxIdDTO.getTotalCount() == 0) {
                return result.success("无未爬取的有效的菜谱页面");
            }
            int splitNum = 20;
            BigDecimal numSplits = new BigDecimal(splitNum);
            BigDecimal maxVal = cookbookUrlNoCrawledMinMaxIdDTO.getMaxVal();
            BigDecimal minVal = cookbookUrlNoCrawledMinMaxIdDTO.getMinVal();
            ExecutorService fixedThreadPool = new ThreadPoolExecutor(splitNum, splitNum,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>());
            BigDecimalSplitter bigDecimalSplitter = new BigDecimalSplitter();
            List<InputSplit> inputSplits = bigDecimalSplitter.split(XinshipuCategoryQuery.PROP_KEY_ID, numSplits, minVal, maxVal);
            for (InputSplit inputSplit : inputSplits) {
                fixedThreadPool.submit(() -> {
                    try {
                        List<XinshipuCookbookUrlDO> cookbookUrlDOS = cookbookUrlManager.selectNotCrawledWithSplitter(inputSplit.toString());
                        if (CollectionUtils.isEmpty(cookbookUrlDOS)) {
                            log.info("该分片无未爬取的食谱页面，分片：{}", inputSplit.toString());
                            return;
                        }
                        WebClient webClient = HtmlUnitHelper.getWebClient();
                        List<XinshipuCookbookDetailDO> addDOS = Lists.newArrayList();
                        List<XinshipuCookbookDetailDO> updateDOS = Lists.newArrayList();
                        List<XinshipuCookbookUrlDO> updateCrawledDOS = Lists.newArrayList();
                        for (Iterator<XinshipuCookbookUrlDO> iterator = cookbookUrlDOS.iterator(); iterator.hasNext(); ) {
                            XinshipuCookbookUrlDO cookbookUrlDO = iterator.next();
                            if (null == cookbookUrlDO || StringUtils.isEmpty(cookbookUrlDO.getCookbookUrl())) {
                                log.error("数据库中，该条数据为空");
                                iterator.remove();
                                continue;
                            }
                            String url = cookbookUrlDO.getCookbookUrl();
                            CookbookDetailPage cookbookDetailPage = null;
                            try {
                                cookbookDetailPage = CookbookDetailPage.crawl(url, webClient);
                            } catch (Exception e) {
                                log.error("爬取食谱页面异常：{}", url);
                                log.error(e.getMessage(), e);
                            }
                            if (null == cookbookDetailPage) {
                                log.error("未爬取到内容，{}", url);
                                cookbookUrlDO.setIsEffective(IsEffectiveEnum.NO.getCode());
                                cookbookUrlManager.updateByPrimaryKeySelective(cookbookUrlDO);
                                iterator.remove();
                                continue;
                            }
                            try {
                                XinshipuCookbookDetailDO cookbookDetailDO = new XinshipuCookbookDetailDO();
                                cookbookDetailDO.setCookbookUrl(url);
                                cookbookDetailDO.setCookbookName(cookbookUrlDO.getCookbookName());
                                cookbookDetailDO.setTitle(cookbookDetailPage.getTitle());
                                cookbookDetailDO.setCoverPicture(cookbookDetailPage.getCoverPicture());
                                cookbookDetailDO.setDescription(cookbookDetailPage.getDescription());
                                cookbookDetailDO.setIngredients(cookbookDetailPage.getIngredients());
                                cookbookDetailDO.setSteps(cookbookDetailPage.getSteps());
                                cookbookDetailDO.setTip(cookbookDetailPage.getTip());
                                XinshipuCookbookDetailDO currentDetaiDO = cookbookDetailManager.selectByCookbookUrl(url);
                                if (null != currentDetaiDO) {
                                    cookbookDetailDO.setId(currentDetaiDO.getId());
                                    cookbookDetailDO.setGmtCreate(currentDetaiDO.getGmtCreate());
                                    cookbookDetailDO.setGmtUpdate(currentDetaiDO.getGmtUpdate());
                                    if (!cookbookDetailDO.equals(currentDetaiDO)) {
                                        log.info("更新页面数据，{}", url);
                                        updateDOS.add(cookbookDetailDO);
//                                        cookbookDetailManager.updateByPrimaryKeySelective(cookbookDetailDO);
                                    }
                                } else {
                                    log.info("新增页面数据，{}", url);
                                    addDOS.add(cookbookDetailDO);
//                                    cookbookDetailManager.insertSelective(cookbookDetailDO);
                                }
                                cookbookUrlDO.setIsCrawled(IsCrawledEnum.YES.getCode());
                                updateCrawledDOS.add(cookbookUrlDO);
                                if (updateDOS.size() >= 20) {
                                    log.info("批量更新页面数据");
                                    cookbookDetailManager.batchUpdateByPrimaryKeySelective(updateDOS);
                                    updateDOS.clear();
                                }
                                if (addDOS.size() >= 50) {
                                    log.info("批量新增页面数据");
                                    cookbookDetailManager.batchInsert(addDOS);
                                    addDOS.clear();
                                }
                                if (updateCrawledDOS.size() >= 20) {
                                    log.info("批量更新页面爬取状态数据");
                                    cookbookUrlManager.batchUpdateByPrimaryKeySelective(updateCrawledDOS);
                                    updateCrawledDOS.clear();
                                }
                            } catch (Exception e) {
                                log.error("存储页面数据错误：{}", url);
                                log.error(e.getMessage(), e);
                            }
                            iterator.remove();
                        }
                        webClient.close();
                        if (updateDOS.size() > 0) {
                            log.info("批量更新剩余页面数据，剩余数量：{}", updateDOS.size());
                            cookbookDetailManager.batchUpdateByPrimaryKeySelective(updateDOS);
                        }
                        if (addDOS.size() > 0) {
                            log.info("批量新增剩余页面数据，剩余数量：{}", addDOS.size());
                            cookbookDetailManager.batchInsert(addDOS);
                        }
                        if (updateCrawledDOS.size() > 0) {
                            log.info("批量更新剩余页面爬取数据，剩余数量：{}", updateCrawledDOS.size());
                            cookbookUrlManager.batchUpdateByPrimaryKeySelective(updateCrawledDOS);
                        }
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
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
