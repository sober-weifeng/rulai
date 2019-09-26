package com.rulai.spider.bean.crawl.fancai;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
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

    public static final String HTTP_PREFIX = "https://www.fancai.com/meishi";
    
    private String originUrl;
    
    private String title;
    
    private String coverPicture;

    private List<FoodMaterial> mainIngredients;
    
    private List<FoodMaterial> supIngredients;

    /**
     * 调料
     */
    private List<FoodMaterial> seasonings;
    
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
            String prefix = "https://www.fancai.com";
            log.info("爬取食谱明细页面：{}", url);
            if (!(url.startsWith(HTTP_PREFIX))) {
                log.error("该页面不是食谱明细页面，爬取方式不同");
                return result.fail("该页面不是食谱明细页面，爬取方式不同");
            }
            HtmlPage page = webClient.getPage(url);
            if (HtmlUnitHelper.isFailPage(page)) {
                log.error("获取页面不正确，url：{}", url);
                return result.fail("获取页面不正确");
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
            List<HtmlElement> titleElements = page.getByXPath("//div[@class='menucont_main']/div[@class='menucont_title']/h1");
            String title = titleElements.stream().findFirst().map(e -> {
                e.removeChild("a", 0);
                return e.asText();
            }).orElse("");
            List<HtmlElement> coverElements = page.getByXPath("//div[@class='menucont_text']//img");
            String coverPicture = coverElements.stream().findFirst().map(e -> prefix.concat(e.getAttribute("src"))).orElse("");
            List<HtmlElement> ingredientElements = page.getByXPath("//div[@class='yong_box']/div");
            List<FoodMaterial> mainIngredients = Lists.newArrayList();
            List<FoodMaterial> supIngredients = Lists.newArrayList();
            List<FoodMaterial> seasonings = Lists.newArrayList();
            for (HtmlElement ingredientElement : ingredientElements) {
                String tipName = ingredientElement.getFirstElementChild().asText();
                HtmlElement shiListElements = ingredientElement.getElementsByAttribute("div", "class", "shi_list").stream().findFirst().orElse(null);
                List<DomElement> materialElements = Optional.ofNullable(shiListElements)
                        .map(element -> Optional.ofNullable(element.getFirstElementChild())
                                .map(e -> Lists.newArrayList(e.getChildElements()))
                                .orElse(Lists.newArrayList()))
                        .orElse(Lists.newArrayList());
                for (DomElement materialElement : materialElements) {
                    String name = materialElement.getElementsByTagName("li").stream()
                            .filter(e -> "shi_list_name".equals(e.getAttribute("class")))
                            .findFirst().map(HtmlElement::asText).orElse("");
                    String usage = materialElement.getElementsByTagName("li").stream()
                            .filter(e -> "liangbei".equals(e.getAttribute("class")))
                            .findFirst().map(HtmlElement::asText).orElse("");
                    FoodMaterial foodMaterial = new FoodMaterial();
                    foodMaterial.setName(name);
                    foodMaterial.setUsage(usage);
                    switch (tipName) {
                        case "主料":
                            mainIngredients.add(foodMaterial);
                            break;
                        case "辅料":
                            supIngredients.add(foodMaterial);
                            break;
                        case "调料":
                            seasonings.add(foodMaterial);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            List<HtmlElement> stepElements = page.getByXPath("//table[@class='menucont_step']//tr");
            List<Step> steps = stepElements.stream().filter(e -> {
                String height = e.getAttribute("height");
                return !"30px".equals(height);
            }).map(e -> {
                String desc = e.asText();
                String picture = e.getElementsByTagName("img").stream().findFirst().map(i -> prefix.concat(i.getAttribute("src"))).orElse("");
                Step step = new Step();
                step.setDesc(desc);
                step.setPicture(picture);
                return step;
            }).collect(Collectors.toList());
            List<HtmlElement> tipElements = page.getByXPath("//div[@class='menucont_msg']/p");
            String tip = tipElements.stream().findFirst().map(HtmlElement::asText).orElse("");
            CookbookDetailPage cookbookDetailPage = new CookbookDetailPage();
            cookbookDetailPage.setOriginUrl(url);
            cookbookDetailPage.setTitle(title);
            cookbookDetailPage.setCoverPicture(coverPicture);
            cookbookDetailPage.setMainIngredients(mainIngredients);
            cookbookDetailPage.setSupIngredients(supIngredients);
            cookbookDetailPage.setSeasonings(seasonings);
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
        String url = "https://www.fancai.com/meishi/217845/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
