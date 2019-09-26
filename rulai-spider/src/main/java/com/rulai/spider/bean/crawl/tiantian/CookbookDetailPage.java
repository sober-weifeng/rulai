package com.rulai.spider.bean.crawl.tiantian;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
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

    public static final String HTTP_PREFIX = "http://www.ttmeishi.com/CaiPu";
    
    private String originUrl;
    
    private String title;
    
    private String coverPicture;
    
    private List<Label> labels;

    private List<FoodMaterial> ingredients;
    
    private List<Step> steps;
    
    private String tip;
    
    @Data
    public static class Label {
        private String name;
        private String type;
    }

    @Data
    public static class FoodMaterial {
        private String name;
        private String usage;
    }

    @Data
    public static class Step {
        private String desc;
        private List<String> pictures;
    }
    
    public static BizResult<CookbookDetailPage> crawl(String url, WebClient webClient) {
        BizResult<CookbookDetailPage> result = BizResult.custom();
        try {
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
            List<HtmlElement> titleElements = page.getByXPath("//div[@id='content']/h1");
            String title = titleElements.stream().findFirst().map(e -> {
                e.removeChild("span", 0);
                return e.asText();
            }).orElse("");
            List<HtmlElement> coverElements = page.getByXPath("//div[@id='cpimgshow1']//img");
            String coverPicture = coverElements.stream().findFirst().map(e -> e.getAttribute("src")).orElse("");
            List<HtmlElement> labelElements = page.getByXPath("//ul[@class='fenlei_ul'][0]/li");
            List<Label> labels = labelElements.stream().map(e -> {
                String name = e.getFirstElementChild().asText();
                String type = e.getLastElementChild().asText();
                Label label = new Label();
                label.setName(name);
                label.setType(type);
                return label;
            }).collect(Collectors.toList());
            List<HtmlElement> ingredientElements = page.getByXPath("//ul[@class='fenlei_ul'][1]/li");
            List<FoodMaterial> ingredients = ingredientElements.stream().map(e -> {
                String name = e.getFirstElementChild().asText();
                String usage = e.getLastElementChild().asText();
                FoodMaterial foodMaterial = new FoodMaterial();
                foodMaterial.setName(name);
                foodMaterial.setUsage(usage);
                return foodMaterial;
            }).collect(Collectors.toList());
            
            List<HtmlElement> stepElements = page.getByXPath("//div[@class='c_bz_hang_b0ah']");
            List<Step> steps = stepElements.stream().map(e -> {
                String desc = e.getFirstElementChild().asText();
                List<String> pictures = e.getLastElementChild().getElementsByTagName("img")
                        .stream()
                        .map(i -> i.getAttribute("src"))
                        .collect(Collectors.toList());
                Step step = new Step();
                step.setDesc(desc);
                step.setPictures(pictures);
                return step;
            }).collect(Collectors.toList());
            List<HtmlElement> tipElements = page.getByXPath("//div[@class='c_tieshi cbox']");
            String tip = tipElements.stream().findFirst().map(HtmlElement::asText).orElse("");
            CookbookDetailPage cookbookDetailPage = new CookbookDetailPage();
            cookbookDetailPage.setOriginUrl(url);
            cookbookDetailPage.setTitle(title);
            cookbookDetailPage.setCoverPicture(coverPicture);
            cookbookDetailPage.setLabels(labels);
            cookbookDetailPage.setIngredients(ingredients);
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
        String url = "http://www.ttmeishi.com/CaiPu/0c3c37d72a227f68.htm";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
