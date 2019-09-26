package com.rulai.spider.bean.crawl.chinacaipu;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
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
 * @date 2019/8/27 16:04
 */
@Data
@Slf4j
public class OriginalCookbookDetailPage {

    public static final String PREFIX = "http://www.chinacaipu.com/caipu";
    
    private String originUrl;
    
    private OriginalCookbookDetail originalCookbookDetail;
    
    @Data
    public static class OriginalCookbookDetail {
        private String title;
        private String cookbookUrl;
        private String description;
        private String coverPicture;
        /**
         * 烹饪难度
         */
        private String cookDifficult;
        /**
         * 烹饪时间
         */
        private String cookTime;
        
        /**
         * 主料
         */
        private List<FoodMaterial> mainIngredients;
        /**
         * 调料
         */
        private List<FoodMaterial> seasonings;
        private List<Step> steps;
        private List<String> tips;
    }
    
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
    
    public static OriginalCookbookDetailPage crawlOriginalCookbookDetailPage(String url, WebClient webClient) 
            throws IOException {
        log.info("爬取食谱明细页面：{}", url);
        if (!url.startsWith(PREFIX)) {
            log.error("该页面不是原创食谱页面，爬取方式不同");
            return null;
        }
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        if (StringUtils.isEmpty(page.asText())) {
            log.error("页面内容为空，url：{}", url);
            return null;
        }
        HtmlElement titleElement = (HtmlElement) page.getByXPath("//div[@class='cp-show-main-tt']//h1").get(0);
        String title = titleElement.asText();
        HtmlElement coverPictureElement = (HtmlElement) page.getByXPath("//img[@class='cp-show-pic']").get(0);
        String coverPicture = coverPictureElement.getAttribute("src");
        HtmlElement descriptionElement = (HtmlElement) page.getByXPath("//div[@class='cp-show-intro']").get(0);
        String description = descriptionElement.asText();
        
        List<HtmlElement> ingredientElements = page.getByXPath("//table[@class='cp-show-tab']//tr");
        String cookDifficult = "";
        String cookTime = "";
        List<FoodMaterial> mainIngredients = Lists.newArrayList();
        List<FoodMaterial> seasonings = Lists.newArrayList();
        int mainIngredientIndex = -1;
        int seasoningIndex = ingredientElements.size();
        HtmlElement ingredientElement;
        for (int i = 0, len = ingredientElements.size(); i < len; i++) {
            ingredientElement = ingredientElements.get(i);
            List<HtmlElement> thElements = ingredientElement.getElementsByTagName("th");
            if (CollectionUtils.isNotEmpty(thElements)) {
                int size = thElements.size();
                if (size < 2) {
                    HtmlElement thElement = thElements.get(0);
                    String txt = thElement.asText();
                    if (txt.contains("主料")) {
                        mainIngredientIndex = i;
                    }
                    if (txt.contains("调料")) {
                        seasoningIndex = i;
                    }
                } else {
                    cookDifficult = thElements.get(0).asText();
                    cookTime = thElements.get(1).asText();
                }
            } else {
                List<HtmlElement> tdElements = ingredientElement.getElementsByTagName("td");
                if (mainIngredientIndex > -1 && i < seasoningIndex) {
                    for (HtmlElement tdElement : tdElements) {
                        FoodMaterial foodMaterial = new FoodMaterial();
                        foodMaterial.setName(tdElement.getFirstElementChild().asText());
                        foodMaterial.setUsage(tdElement.getLastElementChild().asText());
                        mainIngredients.add(foodMaterial);
                    }
                }
                if (seasoningIndex < len && seasoningIndex > mainIngredientIndex) {
                    for (HtmlElement tdElement : tdElements) {
                        FoodMaterial foodMaterial = new FoodMaterial();
                        foodMaterial.setName(tdElement.getFirstElementChild().asText());
                        foodMaterial.setUsage(tdElement.getLastElementChild().asText());
                        seasonings.add(foodMaterial);
                    }
                }
            }
        }
        
        
        List<HtmlElement> stepElements = page.getByXPath("//div[@class='cp-show-main-step-item']");
        List<Step> steps = Lists.newArrayList();
        for (HtmlElement stepElement : stepElements) {
            Step step = new Step();
            step.setDesc(stepElement.asText());
            HtmlElement imageElement = stepElement.getElementsByTagName("img").stream().findFirst().orElse(null);
            if (null != imageElement) {
                step.setPicture(imageElement.getAttribute("src"));
            }
            steps.add(step);
        }
        
        List<HtmlElement> tipElements = page.getByXPath("//div[@class='cp-show-main-trick']");
        List<String> tips = tipElements.stream().map(HtmlElement::asText).collect(Collectors.toList());
        
        OriginalCookbookDetail originalCookbookDetail = new OriginalCookbookDetail();
        originalCookbookDetail.setTitle(title);
        originalCookbookDetail.setCookbookUrl(url);
        originalCookbookDetail.setDescription(description);
        originalCookbookDetail.setCoverPicture(coverPicture);
        originalCookbookDetail.setMainIngredients(mainIngredients);
        originalCookbookDetail.setSeasonings(seasonings);
        originalCookbookDetail.setSteps(steps);
        originalCookbookDetail.setTips(tips);
        originalCookbookDetail.setCookDifficult(cookDifficult);
        originalCookbookDetail.setCookTime(cookTime);
        OriginalCookbookDetailPage originalCookbookDetailPage = new OriginalCookbookDetailPage();
        originalCookbookDetailPage.setOriginUrl(url);
        originalCookbookDetailPage.setOriginalCookbookDetail(originalCookbookDetail);
        return originalCookbookDetailPage;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.chinacaipu.com/caipu/10940.html";
        WebClient webClient = HtmlUnitHelper.getWebClient();
        log.info(JSON.toJSONString(crawlOriginalCookbookDetailPage(url, webClient)));
        webClient.close();
    }
    
}
