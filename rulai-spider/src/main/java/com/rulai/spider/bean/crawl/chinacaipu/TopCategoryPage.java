package com.rulai.spider.bean.crawl.chinacaipu;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/23 17:43
 */
@Data
@Slf4j
public class TopCategoryPage {
    
    public static final String PREFIX = "http://www.chinacaipu.com/menu"; 
    
    private String originUrl;
    
    private List<TopCategory> topCategories;
    
    @Data
    public static class TopCategory {
        private String categoryName;
        private String categoryUrl;
        private List<SecondCategory> secondCategories;
    }
    
    @Data
    public static class SecondCategory {
        private String categoryName;
        private String categoryUrl;
    }
    
    public static TopCategoryPage crawlTopCategoryPage(WebClient webClient) throws IOException {
        String originUrl = "http://www.chinacaipu.com/";
        log.info("爬取主页面：{}", originUrl);
        HtmlPage page = webClient.getPage(originUrl);
        int responseCode = page.getWebResponse().getStatusCode();
        if (200 != responseCode) {
            log.error("获取页面不正确，code：{}，url：{}", responseCode, originUrl);
            return null;
        }
        List<HtmlElement> categoryElements = page.getByXPath("//div[@class='c_nav_m']//dl");
        if (CollectionUtils.isEmpty(categoryElements)) {
            log.error("没有满足//div[@class='c_nav_m']//dl内容");
            return null;
        }
        List<TopCategory> topCategories = Lists.newArrayList();
        TopCategory topCategory;
        List<SecondCategory> secondCategories;
        SecondCategory secondCategory;
        for (HtmlElement categoryElement : categoryElements) {
            HtmlElement dtElement = categoryElement.getElementsByTagName("dt").get(0);
            HtmlElement ddElement = categoryElement.getElementsByTagName("dd").get(0);
            HtmlElement topElement = dtElement.getElementsByTagName("a").get(0);
            String categoryUrl = topElement.getAttribute("href");
            if (!categoryUrl.startsWith(PREFIX)) {
                log.info("该页面非分类页，需单独爬取，页面：{}", categoryUrl);
                continue;
            }
            topCategory = new TopCategory();
            topCategory.setCategoryName(topElement.asText());
            topCategory.setCategoryUrl(categoryUrl);
            secondCategories = Lists.newArrayList();
            List<HtmlElement> secondElements = ddElement.getElementsByTagName("a");
            for (HtmlElement secondElement : secondElements) {
                String secondCategoryUrl = secondElement.getAttribute("href");
                if (!secondCategoryUrl.startsWith(PREFIX)) {
                    log.info("该页面非分类页，需单独爬取，页面：{}", secondCategoryUrl);
                    continue;
                }
                secondCategory = new SecondCategory();
                secondCategory.setCategoryName(secondElement.asText());
                secondCategory.setCategoryUrl(secondCategoryUrl);
                secondCategories.add(secondCategory);
            }
            topCategory.setSecondCategories(secondCategories);
            topCategories.add(topCategory);
        }
        TopCategoryPage topCategoryPage = new TopCategoryPage();
        topCategoryPage.setOriginUrl(originUrl);
        topCategoryPage.setTopCategories(topCategories);
        return topCategoryPage;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        log.info(JSON.toJSONString(crawlTopCategoryPage(webClient)));
        webClient.close();
    }
    
}
