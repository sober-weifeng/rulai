package com.rulai.spider.bean.crawl.xinshipu;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/4 17:44
 */
@Data
@Slf4j
public class CookbookDetailPage {
    
    public static final String HTTPS_PREFIX = "https://www.xinshipu.com/zuofa";

    private String originUrl;

    private String title;
    
    private String coverPicture;
    
    private String description;
    
    private String ingredients;
    
    private String steps;
    
    private String tip;
    
    public static CookbookDetailPage crawl(String url, WebClient webClient) throws IOException {
        log.info("爬取食谱明细页面：{}", url);
        if (!(url.startsWith(HTTPS_PREFIX))) {
            log.error("该页面不是食谱明细页面，爬取方式不同");
            return null;
        }
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        String redirectUrl = page.getUrl().toString();
        log.info("转换页面：{}", redirectUrl);
        if (!(redirectUrl.startsWith(HTTPS_PREFIX))) {
            log.error("该页面重定向后不是食谱明细页面，爬取方式不同");
            return null;
        }
        if (!redirectUrl.equals(url)) {
            log.error("该页面重定向后不是当前页面了，跳过爬取");
            return null;
        }
        String picPrefix = redirectUrl.split("//")[0];

        List<HtmlElement> picElements = page.getByXPath("//div[@class='gallery']//img");
        String coverPicture = picElements.stream().findFirst().map(e -> picPrefix.concat(e.getAttribute("src"))).orElse("");
        
        List<HtmlElement> titleElements = page.getByXPath("//h1[@class='font18 no-overflow']");
        String title = titleElements.stream().findFirst().map(HtmlElement::asText).orElse("");

        List<HtmlElement> contentElements = page.getByXPath("//div[@class='bpannel mt20 p15 re-steps']/div");
        String description = "";
        String ingredients = "";
        String steps = "";
        String tip = "";
        for (HtmlElement contentElement : contentElements) {
            String type = contentElement.getFirstElementChild().asText();
            String content = contentElement.getLastElementChild().asText().trim();
            switch (type) {
                case "简介":
                    description = content;
                    break;
                case "材料":
                    ingredients = content;
                    break;
                case "做法":
                    steps = content;
                    break;
                case "小诀窍":
                    tip = content;
                    break;
                default:
                    break;
            }
        }
        
        CookbookDetailPage cookbookDetailPage = new CookbookDetailPage();
        cookbookDetailPage.setOriginUrl(url);
        cookbookDetailPage.setTitle(title);
        cookbookDetailPage.setCoverPicture(coverPicture);
        cookbookDetailPage.setDescription(description);
        cookbookDetailPage.setIngredients(ingredients);
        cookbookDetailPage.setSteps(steps);
        cookbookDetailPage.setTip(tip);
        return cookbookDetailPage;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://www.xinshipu.com/caipu/656/?page=11";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
