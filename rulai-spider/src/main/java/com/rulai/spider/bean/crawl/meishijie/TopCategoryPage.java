package com.rulai.spider.bean.crawl.meishijie;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/3 11:48
 */
@Data
@Slf4j
public class TopCategoryPage {
    
    private String originUrl;
    
    private List<TopCategory> topCategories;
    
    @Data
    public static class TopCategory {
        private String categoryName;
        private String categoryUrl;
    }
    
    public static TopCategoryPage crawl(WebClient webClient) throws IOException {
        String url = "https://www.meishij.net/";
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        List<HtmlElement> topElements = page.getByXPath("//div[@class='dww clearfix dww_cpdq']//div//dt//a");
        List<TopCategory> topCategories = topElements.stream().map(e -> {
            TopCategory topCategory = new TopCategory();
            topCategory.setCategoryName(e.asText());
            topCategory.setCategoryUrl(e.getAttribute("href"));
            return topCategory;
        }).collect(Collectors.toList());
        TopCategoryPage topCategoryPage = new TopCategoryPage();
        topCategoryPage.setOriginUrl(url);
        topCategoryPage.setTopCategories(topCategories);
        return topCategoryPage;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        log.info(JSON.toJSONString(crawl(webClient)));
        webClient.close();
    }
    
}
