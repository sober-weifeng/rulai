package com.rulai.spider.bean.crawl.meishijie;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/3 11:59
 */
@Data
@Slf4j
public class SecondCategoryPage {
    
    private String originUrl;
    
    private List<SecondCategory> secondCategories;
    
    @Data
    public static class SecondCategory {
        private String categoryName;
        private String categoryUrl;
        private String topCategoryTip;
    }
    
    public static SecondCategoryPage crawl(String url, WebClient webClient) throws IOException {
        log.info("爬取一级分类页面内容：{}", url);
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        List<HtmlElement> contentElements = page.getByXPath("//div[@id='listnav']//dl");
        List<SecondCategory> secondCategories = Lists.newArrayList();
        for (HtmlElement contentElement : contentElements) {
            HtmlElement tipElement = contentElement.getElementsByTagName("dt").get(0);
            List<HtmlElement> secondElements = contentElement.getElementsByTagName("a");
            String topCategoryTip = tipElement.asText();
            for (HtmlElement secondElement : secondElements) {
                String secondCategoryUrl = secondElement.getAttribute("href");
                if (!secondCategoryUrl.startsWith(url)) {
                    log.info("该二级分类页面不属于该一级分类：{}", secondCategoryUrl);
                    continue;
                }
                SecondCategory secondCategory = new SecondCategory();
                secondCategory.setCategoryName(secondElement.asText());
                secondCategory.setCategoryUrl(secondCategoryUrl);
                secondCategory.setTopCategoryTip(topCategoryTip);
                secondCategories.add(secondCategory);
            }
        }
        SecondCategoryPage secondCategoryPage = new SecondCategoryPage();
        secondCategoryPage.setOriginUrl(url);
        secondCategoryPage.setSecondCategories(secondCategories);
        return secondCategoryPage;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://www.meishij.net/china-food/caixi/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
