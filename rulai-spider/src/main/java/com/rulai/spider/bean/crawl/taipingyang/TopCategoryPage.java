package com.rulai.spider.bean.crawl.taipingyang;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
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
 * @date 2019/8/20 17:59
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
    
    public static TopCategoryPage crawlTopCategoryPage() throws IOException {
        String originUrl = "https://baike.pcbaby.com.cn/recipe/";
        log.info("主页面为：{}", originUrl);
        String protocol = originUrl.split("//")[0];
        WebClient webClient = HtmlUnitHelper.getWebClient();
        HtmlPage page = webClient.getPage(originUrl);
        int responseCode = page.getWebResponse().getStatusCode();
        if (200 != responseCode) {
            log.error("获取页面不正确，code：{}，url：{}", responseCode, originUrl);
            return null;
        }
        HtmlElement topCategoryElements = (HtmlElement) page.getByXPath("//div[@class='subNav fl ']").get(0);
        log.info(topCategoryElements.asXml());
        String name;
        String detailUrl;
        List<TopCategory> topCategories = Lists.newArrayList();
        for (DomElement childElement : topCategoryElements.getChildElements()) {
            if (childElement.getChildElementCount() > 0) {
                DomElement element = childElement.getFirstElementChild();
                name = element.asText();
                detailUrl = protocol.concat(element.getAttribute("href"));
            } else {
                name = childElement.asText();
                if ("首页".equals(name)) {
                    continue;
                }
                detailUrl = protocol.concat(childElement.getAttribute("href"));
            }
            TopCategory topCategory = new TopCategory();
            topCategory.setCategoryName(name);
            topCategory.setCategoryUrl(detailUrl);
            topCategories.add(topCategory);
        }
        webClient.close();
        TopCategoryPage topCategoryPage = new TopCategoryPage();
        topCategoryPage.setTopCategories(topCategories);
        topCategoryPage.setOriginUrl(originUrl);
        return topCategoryPage;
    }
    
}
