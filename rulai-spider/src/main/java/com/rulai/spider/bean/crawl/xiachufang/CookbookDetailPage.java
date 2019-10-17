package com.rulai.spider.bean.crawl.xiachufang;

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

    public static final String HTTP_PREFIX = "http://www.xiachufang.com/recipe";
    
    private String originUrl;
    
    private String title;
    
    private String coverPicture;

    private List<FoodMaterial> ingredients;
    
    private List<Step> steps;
    
    private String tip;

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
            if (!(url.startsWith(HTTP_PREFIX))) {
                log.error("该页面不是食谱明细页面，爬取方式不同");
                return result.fail("该页面不是食谱明细页面，爬取方式不同");
            }
            HtmlPage page;
            try {
                page = webClient.getPage(url);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return result.fail(BizResultCodeEnum.PROXY_ERROR);
            }
            if (HtmlUnitHelper.isFailPage(page)) {
                int responseCode = page.getWebResponse().getStatusCode();
                if (responseCode != 200) {
                    return result.fail(BizResultCodeEnum.PROXY_ERROR);
                } else {
                    log.error("获取页面不正确，url：{}", url);
                    return result.fail("获取页面不正确");
                }
            }
            String redirectUrl = page.getUrl().toString();
            if (!(redirectUrl.startsWith(HTTP_PREFIX))) {
                log.error("该页面重定向后不是食谱明细页面，爬取方式不同");
                return result.fail("该页面重定向后不是食谱明细页面，爬取方式不同");
            }
            if (!redirectUrl.equals(url)) {
                log.error("该页面重定向后不是当前页面了，跳过爬取");
                return result.fail("该页面重定向后不是当前页面了，跳过爬取");
            }
            List<HtmlElement> coverElements = page.getByXPath("//div[@class='cover image expandable block-negative-margin']//img[@itemprop='image']");
            String coverPicture = coverElements.stream().findFirst().map(e -> e.getAttribute("src")).orElse("");
            List<HtmlElement> titleElements = page.getByXPath("//h1[@class='page-title']");
            String title = titleElements.stream().findFirst().map(HtmlElement::asText).orElse("");
            List<HtmlElement> materialElements = page.getByXPath("//div[@class='ings']//tr[@itemprop='recipeIngredient']");
            List<FoodMaterial> foodMaterials = materialElements.stream().map(e -> {
                String name = Optional.ofNullable(e.getFirstElementChild()).map(DomElement::asText).orElse("");
                String usage = Optional.ofNullable(e.getLastElementChild()).map(DomElement::asText).orElse("");
                FoodMaterial foodMaterial = new FoodMaterial();
                foodMaterial.setName(name);
                foodMaterial.setUsage(usage);
                return foodMaterial;
            }).collect(Collectors.toList());
            List<HtmlElement> stepElements = page.getByXPath("//div[@class='steps']//li");
            List<Step> steps = stepElements.stream().map(e -> {
                String desc = Optional.ofNullable(e.getFirstElementChild()).map(DomElement::asText).orElse("");
                String picture = Optional.ofNullable(e.getLastElementChild()).map(i -> i.getAttribute("src")).orElse("");
                Step step = new Step();
                step.setDesc(desc);
                step.setPicture(picture);
                return step;
            }).collect(Collectors.toList());
            List<HtmlElement> tipElements = page.getByXPath("//div[@class='tip']");
            String tip = tipElements.stream().findFirst().map(HtmlElement::asText).orElse("");
            CookbookDetailPage cookbookDetailPage = new CookbookDetailPage();
            cookbookDetailPage.setOriginUrl(url);
            cookbookDetailPage.setTitle(title);
            cookbookDetailPage.setCoverPicture(coverPicture);
            cookbookDetailPage.setIngredients(foodMaterials);
            cookbookDetailPage.setSteps(steps);
            cookbookDetailPage.setTip(tip);
            result.success().data(cookbookDetailPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }

    public static void main(String[] args) {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "http://www.xiachufang.com/recipe/100498308/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
