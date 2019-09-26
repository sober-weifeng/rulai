package com.rulai.spider.bean.crawl.meishijie;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/3 12:17
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
    
    public static CookbookListPage crawl(String url, WebClient webClient) throws IOException {
        log.info("爬取二级分类食谱列表页面：{}", url);
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        String redirectUrl = page.getUrl().toString();
        if (!url.equals(redirectUrl)) {
            url = redirectUrl;
        }
        List<HtmlElement> cookbookElements = page.getByXPath("//div[@id='listtyle1_list']//div[@class='listtyle1']");
        List<CookbookUrl> cookbookUrls = cookbookElements.stream().map(e -> {
            HtmlElement hrefElement = e.getElementsByTagName("a").get(0);
            CookbookUrl cookbookUrl = new CookbookUrl();
            cookbookUrl.setCookbookUrl(hrefElement.getAttribute("href"));
            cookbookUrl.setCookbookName(hrefElement.getAttribute("title"));
            return cookbookUrl;
        }).collect(Collectors.toList());
        List<HtmlElement> nextElements = page.getByXPath("//div[@class='listtyle1_page_w']//a[@class='next']");
        String nextUrl = "";
        if (CollectionUtils.isNotEmpty(nextElements)) {
            HtmlElement htmlElement = nextElements.get(0);
            String text = htmlElement.asText();
            if ("下一页".equals(text)) {
                nextUrl = htmlElement.getAttribute("href");
                String prefix;
                if (url.contains("?")) {
                    prefix = url.substring(0, url.indexOf("?"));
                } else {
                    prefix = url;
                }
                nextUrl = nextUrl.startsWith(prefix) ? nextUrl : prefix.concat(nextUrl);
            }
        }
        CookbookListPage cookbookListPage = new CookbookListPage();
        cookbookListPage.setOriginUrl(url);
        cookbookListPage.setNextUrl(nextUrl);
        cookbookListPage.setHasNext(StringUtils.isNotEmpty(nextUrl));
        cookbookListPage.setCookbookUrls(cookbookUrls);
        return cookbookListPage;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://www.meishij.net/shicai/list.php?tz=1";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
