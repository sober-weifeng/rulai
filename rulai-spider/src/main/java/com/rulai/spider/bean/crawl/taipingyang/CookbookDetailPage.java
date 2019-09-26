package com.rulai.spider.bean.crawl.taipingyang;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/20 13:59
 */
@Data
@Slf4j
public class CookbookDetailPage {
    
    private String originUrl;

    private CookbookDetail cookbookDetail;
    
    @Data
    public static class CookbookDetail {
        /**
         * 标题
         */
        private String title;

        /**
         * 标签列表
         */
        private List<Label> labels;

        /**
         * 封面图片
         */
        private String coverPicture;

        /**
         * 描述
         */
        private String description;

        /**
         * 推荐人群
         */
        private List<String> recommendCrowd;

        /**
         * 忌食人群
         */
        private List<String> avoidCrowd;

        /**
         * 主料
         */
        private List<FoodMaterial> mainIngredients;

        /**
         * 调料
         */
        private List<FoodMaterial> seasonings;

        /**
         * 步骤
         */
        private List<Step> steps;

        /**
         * 烹饪小贴士
         */
        private String tip;
    }

    @Data
    public static class FoodMaterial {
        private String name;
        private String usage;
        public static FoodMaterial analysisElement(HtmlElement element) {
            FoodMaterial foodMaterial = new FoodMaterial();
            foodMaterial.setName(element.getElementsByTagName("a").get(0).asText());
            foodMaterial.setUsage(element.getElementsByTagName("span").get(0).asText());
            return foodMaterial;
        }
    }

    @Data
    public static class Label {
        private String labelName;
        private String labelUrl;
        public static Label analysisElement(HtmlElement element, String protocol) {
            Label label = new Label();
            label.setLabelUrl(protocol.concat(element.getAttribute("href")));
            label.setLabelName(element.asText());
            return label;
        }
    }

    @Data
    public static class Step {
        private String desc;
        private List<String> pictures;
        public static Step analysisElement(HtmlElement element, String protocol) {
            Step step = new Step();
            String picture = protocol.concat(element.getElementsByTagName("img").get(0).getAttribute("src"));
            step.setPictures(Lists.newArrayList(picture));
            step.setDesc(element.getElementsByTagName("dd").get(0).asText());
            return step;
        }
    }
    
    public static CookbookDetailPage crawlCookbookDetailPage(String originUrl) throws IOException {
        String protocol = originUrl.split("//")[0];
        
        WebClient webClient = HtmlUnitHelper.getWebClient();
        HtmlPage page = webClient.getPage(originUrl);
        int responseCode = page.getWebResponse().getStatusCode();
        if (200 != responseCode) {
            log.error("获取页面不正确，code：{}，url：{}", responseCode, originUrl);
            return null;
        }
//        HtmlElement titleElement = (HtmlElement) page.getByXPath("//dl[@class='headtxt']//dt").get(0);
//        String title = titleElement.asText();
        String title = "";
        List<HtmlElement> labelElements = page.getByXPath("//dd[@class='hdd1']/a");
        List<Label> labels = labelElements.stream().map(e -> Label.analysisElement(e, protocol)).collect(Collectors.toList());
        
        HtmlElement coverPictureElement;
        List<HtmlElement> coverPictureElements = page.getByXPath("//span[@class='headpic ']//img");
        if (CollectionUtils.isEmpty(coverPictureElements)) {
            coverPictureElements = page.getByXPath("//a[@class='headpic ']//img");
        }
        coverPictureElement = CollectionUtils.isNotEmpty(coverPictureElements) ? coverPictureElements.get(0) : null;
        String coverPicture = null != coverPictureElement ? protocol.concat(coverPictureElement.getAttribute("src")) : "";
        
        List<HtmlElement> descElements = page.getByXPath("//dd[@class='txtmaxheight']");
        String desc = CollectionUtils.isNotEmpty(descElements) ? descElements.get(0).asText() : "";
        
        List<HtmlElement> crowdElements = page.getByXPath("//div[@class='notes-item']");
        List<HtmlElement> recommendCrowdElements = CollectionUtils.isNotEmpty(crowdElements) && crowdElements.size() >= 1 ?
                crowdElements.get(0).getElementsByTagName("span") : Lists.newArrayList();
        List<HtmlElement> avoidCrowdElements = CollectionUtils.isNotEmpty(crowdElements) && crowdElements.size() >= 2 ?
                crowdElements.get(1).getElementsByTagName("span") : Lists.newArrayList();
        List<String> recommendCrowds = recommendCrowdElements.stream().map(HtmlElement::asText).collect(Collectors.toList());
        List<String> avoidCrowds = avoidCrowdElements.stream().map(HtmlElement::asText).collect(Collectors.toList());

        List<HtmlElement> foodMaterialElements = page.getByXPath("//div[@class='dosing-wrap']//td");
        int mainIngredientIndex = -1;
        int seasoningIndex = -1;
        HtmlElement foodMaterialElement;
        for (int i = 0, len = foodMaterialElements.size(); i < len; i++) {
            foodMaterialElement = foodMaterialElements.get(i);
            String text = foodMaterialElement.asText();
            if (text.contains("主料")) {
                mainIngredientIndex = i;
            }
            if (text.contains("调料")) {
                seasoningIndex = i;
                break;
            }
        }
        List<HtmlElement> mainIngredientElements;
        List<HtmlElement> seasoningElements;
        if (mainIngredientIndex > -1) {
            if (seasoningIndex - mainIngredientIndex >= 2) {
                mainIngredientElements = foodMaterialElements.subList(mainIngredientIndex + 1, seasoningIndex);
                seasoningElements = foodMaterialElements.subList(seasoningIndex + 1, foodMaterialElements.size());
            } else {
                mainIngredientElements = foodMaterialElements.subList(mainIngredientIndex + 1, foodMaterialElements.size());
                seasoningElements = Lists.newArrayList();
            }
        } else {
            if (seasoningIndex > -1) {
                mainIngredientElements = Lists.newArrayList();
                seasoningElements = foodMaterialElements.subList(seasoningIndex + 1, foodMaterialElements.size());
            } else {
                mainIngredientElements = Lists.newArrayList();
                seasoningElements = Lists.newArrayList();
            }
        }
        List<FoodMaterial> mainIngredients = mainIngredientElements.stream().map(FoodMaterial::analysisElement).collect(Collectors.toList());
        List<FoodMaterial> seasonings = seasoningElements.stream().map(FoodMaterial::analysisElement).collect(Collectors.toList());
        
        List<HtmlElement> stepElements = page.getByXPath("//div[@id='JaList']//li");
        List<Step> steps = stepElements.stream().map(e -> Step.analysisElement(e, protocol)).collect(Collectors.toList());

        List<HtmlElement> tipElements = page.getByXPath("//div[@class='xtips']//p");
        String tip = CollectionUtils.isNotEmpty(tipElements) ? tipElements.get(0).asText() : "";
        
        webClient.close();
        
        CookbookDetail cookbookDetail = new CookbookDetail();
        cookbookDetail.setTitle(title);
        cookbookDetail.setLabels(labels);
        cookbookDetail.setCoverPicture(coverPicture);
        cookbookDetail.setDescription(desc);
        cookbookDetail.setRecommendCrowd(recommendCrowds);
        cookbookDetail.setAvoidCrowd(avoidCrowds);
        cookbookDetail.setMainIngredients(mainIngredients);
        cookbookDetail.setSeasonings(seasonings);
        cookbookDetail.setSteps(steps);
        cookbookDetail.setTip(tip);
        CookbookDetailPage cookbookDetailPage = new CookbookDetailPage();
        cookbookDetailPage.setOriginUrl(originUrl);
        cookbookDetailPage.setCookbookDetail(cookbookDetail);
        return cookbookDetailPage;
    }

//    public static void main(String[] args) throws IOException {
//        log.info(JSON.toJSONString(crawlCookbookDetailPage("https://baike.pcbaby.com.cn/recipe/k935.html")));
//    }
    
}
