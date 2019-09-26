package com.rulai.spider.bean.crawl.haodou;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Maps;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
    
    public static final String PREFIX = "https://www.haodou.com/recipe/all";
    
    private String originUrl;

    private boolean hasNext;
    
    private HtmlPage nextHtmlPage;
    
    private HtmlPage currentHtmlPage;
    
    private List<CookbookUrl> cookbookUrls;
    
    @Data
    public static class CookbookUrl {
        private String cookbookUrl;
        private String cookbookName;
    }
    
    @Data
    public static class Param {
        private String moduleId;
        private String members;
        private String id;
        private String from;
        private String adcode;
        private String appid;
        private String uuid;
        private String uid;
        private String hduid;
        private String vc;
        private String vn;
        private LastParam last;
    }
    
    @Data
    public static class LastParam {
        private int current;
        private int total;
        private int offset;
        private int limit;
    }
    
    public static BizResult<CookbookListPage> crawl(HtmlPage page) {
        BizResult<CookbookListPage> result = BizResult.custom();
        try {
            String httpPrefix = "https://www.haodou.com";
//            String url = originPage.getOriginUrl();
//            log.info("爬取分类食谱列表页面：{}", url);
//            if (!originPage.isFirst() && null == originPage.getNextPageElement()) {
//                log.error("非首页时下页对象不能为空，url：{}", url);
//                return result.fail("非首页时下页对象不能为空");
//            }
//            HtmlPage page = originPage.isFirst() ? webClient.getPage(url) : originPage.getNextPageElement().click();
//            if (HtmlUnitHelper.isFailPage(page)) {
//                log.error("获取页面不正确，url：{}", url);
//                return result.fail("获取页面不正确");
//            }
//            String redirectUrl = page.getUrl().toString();
//            if (!(redirectUrl.startsWith(PREFIX))) {
//                log.error("该页面重定向后不是分类食谱列表页面，爬取方式不同");
//                return result.fail("该页面重定向后不是分类食谱列表页面，爬取方式不同");
//            }
//            if (!redirectUrl.equals(url)) {
//                log.error("该页面重定向后不是当前页面了，跳过爬取");
//                return result.fail("该页面重定向后不是当前页面了，跳过爬取");
//            }
            List<HtmlElement> contentElements = page.getByXPath("//div[@class='recipe-list-box el-row']/div/a");
            List<CookbookUrl> cookbookUrls = contentElements.stream().map(e -> {
                CookbookUrl cookbookUrl = new CookbookUrl();
                cookbookUrl.setCookbookUrl(httpPrefix.concat(e.getAttribute("href")));
                cookbookUrl.setCookbookName(e.getAttribute("title"));
                return cookbookUrl;
            }).collect(Collectors.toList());
            List<HtmlElement> nextElements = page.getByXPath("//button[@class='btn-next']");
            HtmlElement nextPageElement = nextElements.stream().findFirst().orElse(null);
            String disabled = Optional.ofNullable(nextPageElement).map(e -> e.getAttribute("disabled")).orElse("disabled");
            boolean hasNext = null != nextElements && !"disabled".equals(disabled);
            HtmlPage nextHtmlPage = null;
            if (null != nextPageElement && hasNext) {
                nextHtmlPage = nextPageElement.click();
            }
            hasNext = null != nextElements && !"disabled".equals(disabled) && null != nextHtmlPage;
            CookbookListPage cookbookListPage = new CookbookListPage();
//            cookbookListPage.setOriginUrl(url);
            cookbookListPage.setCurrentHtmlPage(page);
            cookbookListPage.setHasNext(hasNext);
            cookbookListPage.setNextHtmlPage(nextHtmlPage);
            cookbookListPage.setCookbookUrls(cookbookUrls);
            result.success().data(cookbookListPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }
    
    public static void crawlDataDetail() {
        String httpPrefix = "https://www.haodou.com";
        String url = "https://www.haodou.com/recipe/all/1000611";
        WebClient webClient = HtmlUnitHelper.getWebClient(Boolean.TRUE.booleanValue());
        log.info("爬取分类食谱列表页面：{}", url);
        try {
            HtmlPage page = webClient.getPage(url);
            List<HtmlElement> contentElements = page.getByXPath("//div[@class='recipe-list-box el-row']/div/a");
            List<CookbookUrl> cookbookUrls = contentElements.stream().map(e -> {
                CookbookUrl cookbookUrl = new CookbookUrl();
                cookbookUrl.setCookbookUrl(httpPrefix.concat(e.getAttribute("href")));
                cookbookUrl.setCookbookName(e.getAttribute("title"));
                return cookbookUrl;
            }).collect(Collectors.toList());
            log.info(JSON.toJSONString(cookbookUrls));

            List<HtmlElement> nextElements = page.getByXPath("//button[@class='btn-next']");
            HtmlElement nextPageElement = nextElements.stream().findFirst().orElse(null);
            HtmlPage nextPage = (HtmlPage) Optional.ofNullable(nextPageElement).map(e -> {
                try {
                    return e.click();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return null;
            }).orElse(null);
            String nextPageHtml = Optional.ofNullable(nextPage).map(HtmlPage::asXml).orElse("");
            log.info(nextPageHtml);
            webClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static Map<String, String> buildUrlHeaders() {
        Map<String, String> headers = Maps.newHashMap();
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.75 Safari/537.36");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Origin", "https://www.haodou.com");
        headers.put("Referer", "https://www.haodou.com/recipe/all/1000611");
        return headers;
    }
    
    private static Map<String, String> buildUrlParams(int pageNumber, String id) {
//        int limit = 40;
//        int offset = (pageNumber - 1) * limit;
//        LastParam lastParam = new LastParam();
//        lastParam.setOffset(offset);
//        lastParam.setLimit(limit);
        Map<String, String> params = Maps.newHashMap();
        params.put("last", "{\"offset\":2120,\"limit\":40}");
        params.put("moduleId", "5d35709cfd96c61a103a13c2");
        params.put("numbers", "[]");
        params.put("id", "1000611");
        params.put("_HOP_", "{\"version\":\"1.0.0\",\"action\":\"api.www.recipe.category\",\"secret_id\":\"5722f877e4b0d4512e3fd872\",\"current_time\":1568959865,\"sign\":\"9847062e7e3bf7753c6fec47e7f6bf12\"}");
        params.put("from", "mvue");
        params.put("adcode", "100000");
        params.put("appid", "100");
        params.put("uuid", "0");
        params.put("hduid", "0");
        params.put("vc", "177");
        params.put("vn", "1.0.0");
        return params;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient(Boolean.TRUE.booleanValue());
        String url = "https://www.haodou.com/recipe/all/1000611";
        HtmlPage page = webClient.getPage(url);
        webClient.close();
        CookbookListPage cookbookListPage = new CookbookListPage();
//        cookbookListPage.setOriginUrl(url);
//        cookbookListPage.setFirst(true);
//        cookbookListPage.setNextPageElement(null);
//        cookbookListPage.setHasNext(false);
        do {
            BizResult<CookbookListPage> crawlResult = crawl(page);
            if (crawlResult.isFail()) {
                log.error(crawlResult.getMessage());
                cookbookListPage.setHasNext(false);
                continue;
            }
            cookbookListPage = crawlResult.getData();
            log.info(JSON.toJSONString(cookbookListPage.getCookbookUrls()));
        } while (cookbookListPage.isHasNext());
//        crawlDataDetail();
    }
    
}
