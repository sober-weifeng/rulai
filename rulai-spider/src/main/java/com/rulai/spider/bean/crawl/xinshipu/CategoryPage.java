package com.rulai.spider.bean.crawl.xinshipu;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/4 17:20
 */
@Data
@Slf4j
public class CategoryPage {
    
    public static final String PREFIX = "https://www.xinshipu.com";
    
    private String originUrl;
    
    private String nextUrl;
    
    private boolean hasNext;
    
    public List<Category> categories;
    
    @Data
    public static class Category {
        private String categoryUrl;
        private String categoryName;
    }
    
    public static CategoryPage crawl(String url, WebClient webClient) throws IOException {
        log.info("爬取分类页面：{}", url);
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        List<HtmlElement> contentElements = page.getByXPath("//ul[@class='recipe-category-list clearfix']/li/a");
        List<Category> categories = contentElements.stream().map(e -> {
            Category category = new Category();
            category.setCategoryUrl(PREFIX.concat(e.getAttribute("href")));
            category.setCategoryName(e.getFirstElementChild().asText());
            return category;
        }).collect(Collectors.toList());

        List<HtmlElement> nextPageElements = page.getByXPath("//a[@class='next-page']");
        String nextUrl = nextPageElements.stream().findFirst().map(e -> PREFIX.concat(e.getAttribute("href"))).orElse("");
        
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.setOriginUrl(url);
        categoryPage.setNextUrl(nextUrl);
        categoryPage.setHasNext(StringUtils.isNotEmpty(nextUrl));
        categoryPage.setCategories(categories);
        return categoryPage;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://www.xinshipu.com/chuyoufenlei/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
