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
 * @date 2019/9/4 17:34
 */
@Data
@Slf4j
public class CookbookListPage {

    public static final String PREFIX = "https://www.xinshipu.com";

    private String originUrl;

    private String nextUrl;

    private boolean hasNext;

    private List<CookbookUrl> cookbookUrls;

    @Data
    public static class CookbookUrl {
        private String cookbookUrl;
        private String cookbookName;
    }
    
    public static CookbookListPage crawl(String url, WebClient webClient) throws IOException {
        log.info("爬取分类食谱列表页面：{}", url);
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        String redirectUrl = page.getUrl().toString();
        log.info("转换页面：{}", redirectUrl);
        if (!redirectUrl.equals(url)) {
            log.error("该页面重定向后不是当前页面了，跳过爬取");
            return null;
        }
        List<HtmlElement> contentElements = page.getByXPath("//div[@class='new-menu mt20']//a[@class='shipu']");
        List<CookbookUrl> cookbookUrls = contentElements.stream().map(e -> {
            CookbookUrl cookbookUrl = new CookbookUrl();
            cookbookUrl.setCookbookUrl(PREFIX.concat(e.getAttribute("href")));
            cookbookUrl.setCookbookName(e.asText().trim());
            return cookbookUrl;
        }).collect(Collectors.toList());

        List<HtmlElement> nextPageElements = page.getByXPath("//a[@class='next-page']");
        String nextUrl = nextPageElements.stream().findFirst().map(e -> PREFIX.concat(e.getAttribute("href"))).orElse("");
        
        CookbookListPage cookbookListPage = new CookbookListPage();
        cookbookListPage.setOriginUrl(url);
        cookbookListPage.setNextUrl(nextUrl);
        cookbookListPage.setHasNext(StringUtils.isNotEmpty(nextUrl));
        cookbookListPage.setCookbookUrls(cookbookUrls);
        return cookbookListPage;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://www.xinshipu.com/caipu/114526/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
