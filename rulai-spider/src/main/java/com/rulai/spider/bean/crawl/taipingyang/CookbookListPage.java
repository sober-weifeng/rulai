package com.rulai.spider.bean.crawl.taipingyang;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/21 14:12
 */
@Data
@Slf4j
public class CookbookListPage {
    
    private String originUrl;

    private String nextUrl;

    private boolean hasNext;
    
    private List<CookbookUrl> cookbookUrls;
    
    @Data
    public static class CookbookUrl {
        private String cookbookUrl;
        private String cookbookName;
    }
    
    public static BizResult<CookbookListPage> crawlFirstPage(String url, WebClient webClient) {
        BizResult<CookbookListPage> result = BizResult.custom();
        try {
            log.info("爬取分类食谱列表页面：{}", url);
            String protocol = url.split("//")[0];
            HtmlPage page = webClient.getPage(url);
            if (HtmlUnitHelper.isFailPage(page)) {
                log.error("获取页面不正确，url：{}", url);
                return result.fail("获取页面不正确");
            }
            String redirectUrl = page.getUrl().toString();
            if (!redirectUrl.equals(url)) {
                log.error("该页面重定向后不是当前页面了，跳过爬取");
                return result.fail("该页面重定向后不是当前页面了，跳过爬取");
            }
            List<HtmlElement> listContentElements = page.getByXPath("//div[@id='JaList']//p[@class='aList-title']");
            List<CookbookUrl> cookbookUrls = listContentElements.stream()
                    .map(e -> analysisCookInList(e, protocol))
                    .collect(Collectors.toList());
            List<HtmlElement> secondUrlElements = page.getByXPath("//a[@class='tabList-more']");
            String nextUrl = secondUrlElements.stream().findFirst().map(e -> protocol.concat(e.getAttribute("href"))).orElse("");
            boolean hasNext = StringUtils.isNotEmpty(nextUrl) && !url.equals(nextUrl);
            CookbookListPage cookbookListPage = new CookbookListPage();
            cookbookListPage.setOriginUrl(url);
            cookbookListPage.setCookbookUrls(cookbookUrls);
            cookbookListPage.setHasNext(hasNext);
            cookbookListPage.setNextUrl(nextUrl);
            result.success().data(cookbookListPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }
    
    public static BizResult<CookbookListPage> crawlNotFirstPage(String url, WebClient webClient) {
        BizResult<CookbookListPage> result = BizResult.custom();
        try {
            log.info("爬取分类食谱列表页面：{}", url);
            String protocol = url.split("//")[0];
            HtmlPage page = webClient.getPage(url);
            if (HtmlUnitHelper.isFailPage(page)) {
                log.error("获取页面不正确，url：{}", url);
                return result.fail("获取页面不正确");
            }
            String redirectUrl = page.getUrl().toString();
            if (!redirectUrl.equals(url)) {
                log.error("该页面重定向后不是当前页面了，跳过爬取");
                return result.fail("该页面重定向后不是当前页面了，跳过爬取");
            }
            List<HtmlElement> listContentElements = page.getByXPath("//div[@id='JaList']//p[@class='aList-title']");
            List<CookbookUrl> cookbookUrls = listContentElements.stream()
                    .map(e -> analysisCookInList(e, protocol))
                    .collect(Collectors.toList());
            List<HtmlElement> paginationElements = page.getByXPath("//div[@id='pages']//a[@class='next']");
            String nextUrl = paginationElements.stream().findFirst().map(e -> protocol.concat(e.getAttribute("href"))).orElse("");
            boolean hasNext = StringUtils.isNotEmpty(nextUrl) && !url.equals(nextUrl);
            CookbookListPage cookbookListPage = new CookbookListPage();
            cookbookListPage.setOriginUrl(url);
            cookbookListPage.setCookbookUrls(cookbookUrls);
            cookbookListPage.setHasNext(hasNext);
            cookbookListPage.setNextUrl(nextUrl);
            result.success().data(cookbookListPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }
    
    public static CookbookUrl analysisCookInList(HtmlElement element, String protocol) {
        CookbookUrl cookbookUrl = new CookbookUrl();
        HtmlElement linkElement = element.getElementsByTagName("a").get(0);
        cookbookUrl.setCookbookName(linkElement.asText());
        cookbookUrl.setCookbookUrl(protocol.concat(linkElement.getAttribute("href")));
        return cookbookUrl;
    }

    public static void main(String[] args) {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://baike.pcbaby.com.cn/recipe/d33.html";
        log.info(JSON.toJSONString(crawlFirstPage(url, webClient)));
        webClient.close();
    }
    
}
