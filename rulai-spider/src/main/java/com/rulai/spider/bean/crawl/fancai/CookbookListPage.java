package com.rulai.spider.bean.crawl.fancai;

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
    
//    public static final String PREFIX = "http://www.xiachufang.com/category";
    
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
            String httpPrefix = "https://www.fancai.com";
            log.info("爬取分类食谱列表页面：{}", url);
            HtmlPage page = webClient.getPage(url);
            if (HtmlUnitHelper.isFailPage(page)) {
                log.error("获取页面不正确，url：{}", url);
                return result.fail("获取页面不正确");
            }
            String redirectUrl = page.getUrl().toString();
//            if (!(redirectUrl.startsWith(PREFIX))) {
//                log.error("该页面重定向后不是分类食谱列表页面，爬取方式不同");
//                return result.fail("该页面重定向后不是分类食谱列表页面，爬取方式不同");
//            }
            if (!redirectUrl.equals(url)) {
                log.error("该页面重定向后不是当前页面了，跳过爬取");
                return result.fail("该页面重定向后不是当前页面了，跳过爬取");
            }
            List<HtmlElement> contentElements = page.getByXPath("//div[@id='J_list']//li//div[@class='detail']/h4/a");
            List<CookbookUrl> cookbookUrls = contentElements.stream().map(e -> {
                String href = Optional.ofNullable(e.getAttribute("href")).map(s -> httpPrefix.concat(s)).orElse("");
                CookbookUrl cookbookUrl = new CookbookUrl();
                cookbookUrl.setCookbookUrl(href);
                cookbookUrl.setCookbookName(e.asText());
                return cookbookUrl;
            }).collect(Collectors.toList());
            List<HtmlElement> nextElements = page.getByXPath("//div[@class='msgserp_pages']/a");
            String nextUrl = nextElements.stream().filter(e -> "下一页".equals(e.asText())).findFirst().map(e -> httpPrefix.concat(e.getAttribute("href"))).orElse("");
            boolean hasNext = StringUtils.isNotEmpty(nextUrl) && !url.equals(nextUrl);
            CookbookListPage cookbookListPage = new CookbookListPage();
            cookbookListPage.setOriginUrl(url);
            cookbookListPage.setNextUrl(nextUrl);
            cookbookListPage.setHasNext(hasNext);
            cookbookListPage.setCookbookUrls(cookbookUrls);
            result.success().data(cookbookListPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public static void main(String[] args) {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://www.fancai.com/caixi/1010100_2/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
