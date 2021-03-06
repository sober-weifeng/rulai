package com.rulai.spider.bean.crawl.xiachufang;

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

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/12 10:43
 */
@Data
@Slf4j
public class CookbookListPage {
    
    public static final String PREFIX = "http://www.xiachufang.com/category";
    public static final String PHONE_PREFIX = "https://m.xiachufang.com/category";
    
    private String originUrl;
    
    private String nextUrl;
    
    private boolean hasNext;
    
    private List<CookbookUrl> cookbookUrls;
    
    @Data
    public static class CookbookUrl {
        private String cookbookUrl;
        private String cookbookName;
    }
    
    public static BizResult<CookbookListPage> crawl(String url, WebClient webClient) {
        BizResult<CookbookListPage> result = BizResult.custom();
        try {
            String phoneUrl = url.replace("http://www", "https://m");
            String httpPrefix = "http://www.xiachufang.com";
            log.info("爬取分类食谱列表页面：{}", url);
            HtmlPage page = webClient.getPage(url);
            if (HtmlUnitHelper.isFailPage(page)) {
                log.error("获取页面不正确，url：{}", url);
                return result.fail("获取页面不正确");
            }
            String redirectUrl = page.getUrl().toString();
            if (!redirectUrl.equals(url)) {
                log.info("重定向后页面：{}", redirectUrl);
            }
            if (!(redirectUrl.startsWith(PREFIX) || redirectUrl.startsWith(PHONE_PREFIX))) {
                log.error("该页面重定向后不是分类食谱列表页面，爬取方式不同, redirectUrl = {}", redirectUrl);
                return result.fail("该页面重定向后不是分类食谱列表页面，爬取方式不同");
            }
            if (!(redirectUrl.equals(url) || redirectUrl.equals(phoneUrl))) {
                log.error("该页面重定向后不是当前页面了，跳过爬取, redirectUrl = {}", redirectUrl);
                return result.fail("该页面重定向后不是当前页面了，跳过爬取");
            }
            List<HtmlElement> contentElements = page.getByXPath("//ul[@class='list']/li//p[@class='name']//a");
            List<CookbookUrl> cookbookUrls = contentElements.stream().map(e -> {
                String href = Optional.ofNullable(e.getAttribute("href")).map(s -> httpPrefix.concat(s)).orElse("");
                CookbookUrl cookbookUrl = new CookbookUrl();
                cookbookUrl.setCookbookUrl(href);
                cookbookUrl.setCookbookName(e.asText());
                return cookbookUrl;
            }).collect(Collectors.toList());
            List<HtmlElement> nextElements = page.getByXPath("//a[@class='next']");
            String nextUrl = nextElements.stream().findFirst().map(e -> httpPrefix.concat(e.getAttribute("href"))).orElse("");
            boolean hasNext = StringUtils.isNotEmpty(nextUrl);
            CookbookListPage cookbookListPage = new CookbookListPage();
            cookbookListPage.setOriginUrl(url);
            cookbookListPage.setNextUrl(nextUrl);
            cookbookListPage.setHasNext(hasNext);
            cookbookListPage.setCookbookUrls(cookbookUrls);
            result.success().data(cookbookListPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error("爬取页面异常, url: {}", url);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        webClient.addRequestHeader("User-Agent", HtmlUnitHelper.getRandomUserAgent());
        webClient.getOptions().setProxyConfig(HtmlUnitHelper.getRandomProxyConfig());
        String url = "http://www.xiachufang.com/category/40075/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
