package com.rulai.spider.bean.crawl.zuofan;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/12 11:07
 */
@Data
@Slf4j
public class CookbookDetailPage {

//    public static final String HTTP_PREFIX = "http://www.xiachufang.com/recipe";
    
    private String originUrl;
    
    private String title;
    
    private String coverPicture;

    /**
     * 食材
     */
    private List<FoodMaterial> ingredients;

    /**
     * 调料
     */
    private List<FoodMaterial> seasonings;
    
    private List<Step> steps;
    
    private String tip;

    /**
     * 营养密语
     */
    private String cryptolalia;

    @Data
    public static class FoodMaterial {
        private String name;
        private String usage;
    }

    @Data
    public static class Step {
        private String desc;
        private String picture;
    }
    
    public static BizResult<CookbookDetailPage> crawl(String url, WebClient webClient) {
        BizResult<CookbookDetailPage> result = BizResult.custom();
        try {
            log.info("爬取食谱明细页面：{}", url);
//            if (!(url.startsWith(HTTP_PREFIX))) {
//                log.error("该页面不是食谱明细页面，爬取方式不同");
//                return result.fail("该页面不是食谱明细页面，爬取方式不同");
//            }
            HtmlPage page = webClient.getPage(url);
            if (HtmlUnitHelper.isFailPage(page)) {
                log.error("获取页面不正确，url：{}", url);
                return result.fail("获取页面不正确");
            }
            String redirectUrl = page.getUrl().toString();
//            if (!(redirectUrl.startsWith(HTTP_PREFIX))) {
//                log.error("该页面重定向后不是食谱明细页面，爬取方式不同");
//                return result.fail("该页面重定向后不是食谱明细页面，爬取方式不同");
//            }
            if (!redirectUrl.equals(url)) {
                log.error("该页面重定向后不是当前页面了，跳过爬取");
                return result.fail("该页面重定向后不是当前页面了，跳过爬取");
            }
            List<HtmlElement> titleElements = page.getByXPath("//div[@class='center']/h1");
            String title = titleElements.stream().findFirst().map(HtmlElement::asText).orElse("");
            List<HtmlElement> coverElements = page.getByXPath("//div[@class='pic']//img");
            String coverPicture = coverElements.stream().findFirst().map(e -> e.getAttribute("src")).orElse("");
            List<HtmlElement> ingredientElements = page.getByXPath("//div[@class='yuanliao']//li");
            List<FoodMaterial> ingredients = ingredientElements.stream().map(e -> {
                String usage = e.getElementsByTagName("span").stream().findFirst().map(DomElement::asText).orElse("");
                e.removeChild("span", 0);
                String name = e.asText();
                FoodMaterial foodMaterial = new FoodMaterial();
                foodMaterial.setName(name);
                foodMaterial.setUsage(usage);
                return foodMaterial;
            }).collect(Collectors.toList());
            List<HtmlElement> seasoningElements = page.getByXPath("//div[@class='tiaoliao']//li");
            List<FoodMaterial> seasonings = seasoningElements.stream().map(e -> {
                String usage = e.getElementsByTagName("span").stream().findFirst().map(DomElement::asText).orElse("");
                e.removeChild("span", 0);
                String name = e.asText();
                FoodMaterial foodMaterial = new FoodMaterial();
                foodMaterial.setName(name);
                foodMaterial.setUsage(usage);
                return foodMaterial;
            }).collect(Collectors.toList());
            List<HtmlElement> stepElements = page.getByXPath("//div[@class='zuofa']//li");
            List<Step> steps = stepElements.stream().map(e -> {
                String desc = Optional.ofNullable(e.getLastElementChild()).map(DomElement::asText).orElse("");
                String picture = Optional.ofNullable(e.getFirstElementChild()).map(i -> i.getAttribute("src")).orElse("");
                Step step = new Step();
                step.setDesc(desc);
                step.setPicture(picture);
                return step;
            }).collect(Collectors.toList());
            List<HtmlElement> tipElements = page.getByXPath("//div[@class='jiqiao']/p");
            String tip = tipElements.stream().findFirst().map(HtmlElement::asText).orElse("");
            List<HtmlElement> cryptolaliaElements = page.getByXPath("//div[@class='miyu']/p");
            String cryptolalia = cryptolaliaElements.stream().findFirst().map(HtmlElement::asText).orElse("");
            CookbookDetailPage cookbookDetailPage = new CookbookDetailPage();
            cookbookDetailPage.setOriginUrl(url);
            cookbookDetailPage.setTitle(title);
            cookbookDetailPage.setCoverPicture(coverPicture);
            cookbookDetailPage.setIngredients(ingredients);
            cookbookDetailPage.setSeasonings(seasonings);
            cookbookDetailPage.setSteps(steps);
            cookbookDetailPage.setTip(tip);
            cookbookDetailPage.setCryptolalia(cryptolalia);
            result.success().data(cookbookDetailPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public static void main(String[] args) {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "http://www.zuofan.cn/182214.html";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
