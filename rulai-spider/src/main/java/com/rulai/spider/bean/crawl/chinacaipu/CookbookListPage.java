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
 * @date 2019/8/27 15:16
 */
@Data
@Slf4j
public class CookbookListPage {
    
    public static final String PREFIX = "http://www.chinacaipu.com";
    
    private String originUrl;
    
    private List<String> allCrawlUrls;
    
    private List<CookbookUrl> cookbookUrls;
    
    @Data
    public static class CookbookUrl {
        private String cookbookName;
        private String cookbookUrl;
        private String locationUrl;
    }
    
    public static CookbookListPage crawlCookbookListPage(String url, WebClient webClient) throws IOException {
        List<String> allCrawlUrls = Lists.newArrayList();
        List<CookbookUrl> cookbookUrls = Lists.newArrayList();
        crawlCookbookPagerPage(url, webClient, cookbookUrls, allCrawlUrls);
        CookbookListPage cookbookListPage = new CookbookListPage();
        cookbookListPage.setOriginUrl(url);
        cookbookListPage.setCookbookUrls(cookbookUrls);
        cookbookListPage.setAllCrawlUrls(allCrawlUrls);
        return cookbookListPage;
    }
    
    private static void crawlCookbookPagerPage(String url, WebClient webClient, 
                                              List<CookbookUrl> cookbookUrls, 
                                              List<String> allCrawlUrls) 
            throws IOException {
        log.info("爬取食谱列表页：{}", url);
        allCrawlUrls.add(url);
        HtmlPage page = webClient.getPage(url);
        int responseCode = page.getWebResponse().getStatusCode();
        if (200 != responseCode) {
            log.error("获取页面不正确，code：{}，url：{}", responseCode, url);
            return;
        }
        cookbookUrls.addAll(analysisCookbookUrls(page, url));
        List<HtmlElement> paginationElements = page.getByXPath("//div[@class='page']//a");
        if (CollectionUtils.isEmpty(paginationElements)) {
            log.info("无分页//div[@class='page']//a解析内容");
            return;
        }
        HtmlElement nextPageElement = paginationElements.get(paginationElements.size() - 1);
        String title = nextPageElement.getAttribute("title");
        if (!"上一页".equals(title)) {
            log.info("不是正确的下一页对象，可能没有下一页了");
            return;
        }
        String nexPageUrl = PREFIX.concat(nextPageElement.getAttribute("href"));
        crawlCookbookPagerPage(nexPageUrl, webClient, cookbookUrls, allCrawlUrls);
    }
    
    public static List<CookbookUrl> analysisCookbookUrls(HtmlPage page, String url) {
        List<HtmlElement> contentElements = page.getByXPath("//ul[@class='c_conlist']/li");
        if (CollectionUtils.isEmpty(contentElements)) {
            log.error("无解析//ul[@class='c_conlist']/li内容");
            return Lists.newArrayList();
        }
        List<CookbookUrl> cookbookUrls = Lists.newArrayList();
        CookbookUrl cookbookUrl;
        for (HtmlElement contentElement : contentElements) {
            HtmlElement titleElement = contentElement.getElementsByTagName("strong").get(0)
                    .getElementsByTagName("a").get(0);
            cookbookUrl = new CookbookUrl();
            cookbookUrl.setCookbookName(titleElement.asText());
            cookbookUrl.setCookbookUrl(titleElement.getAttribute("href"));
            cookbookUrl.setLocationUrl(url);
            cookbookUrls.add(cookbookUrl);
        }
        return cookbookUrls;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.chinacaipu.com/menu/danleishipu/index.html";
        WebClient webClient = HtmlUnitHelper.getWebClient();
        log.info(JSON.toJSONString(crawlCookbookListPage(url, webClient)));
        webClient.close();
    }
    
}
