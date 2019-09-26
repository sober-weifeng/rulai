package com.rulai.spider.bean.crawl.meishijie;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
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
 * @date 2019/9/3 13:32
 */
@Data
@Slf4j
public class CookbookDetailPage {

    public static final String HTTP_PREFIX = "http://www.meishij.net/zuofa";
    public static final String HTTPS_PREFIX = "https://www.meishij.net/zuofa";
    
    //1为正确，-1为页面非明细页面，-2为可能需要其他解析方式，-3解析页面出错
//    private int status;
    
    private String originUrl;
    
    private String title;

    private String coverPicture;

    /**
     * 工艺
     */
    private String technology;

    /**
     * 难度
     */
    private String difficulty;

    /**
     * 人数
     */
    private String numberOfPeople;

    /**
     * 口味
     */
    private String taste;

    /**
     * 准备时间
     */
    private String setupTime;

    /**
     * 烹饪时间
     */
    private String cookTime;

    private String description;

    /**
     * 主料
     */
    private List<FoodMaterial> mainIngredients;

    /**
     * 辅料
     */
    private List<FoodMaterial> supIngredients;
    
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
    
    public static CookbookDetailPage crawl(String url, WebClient webClient) throws IOException {
        log.info("爬取食谱明细页面：{}", url);
        if (!(url.startsWith(HTTP_PREFIX) || url.startsWith(HTTPS_PREFIX))) {
            log.error("该页面不是食谱明细页面，爬取方式不同");
            return null;
        }
        HtmlPage page = webClient.getPage(url);
        if (HtmlUnitHelper.isFailPage(page)) {
            log.error("获取页面不正确，url：{}", url);
            return null;
        }
        String redirectUrl = page.getUrl().toString();
        if (!(redirectUrl.startsWith(HTTP_PREFIX) || redirectUrl.startsWith(HTTPS_PREFIX))) {
            log.error("该页面重定向后不是食谱明细页面，爬取方式不同");
            return null;
        }
        
        List<HtmlElement> coverElements = page.getByXPath("//div[@class='cp_headerimg_w']//img");
        String coverPicture = CollectionUtils.isNotEmpty(coverElements) ? coverElements.get(0).getAttribute("src") : "";
        List<HtmlElement> titleElements = page.getByXPath("//a[@id='tongji_title']");
        String title = CollectionUtils.isNotEmpty(titleElements) ? titleElements.get(0).asText() : "";
        if (StringUtils.isEmpty(title)) {
            log.error("该页面不是食谱明细页面，爬取方式不同");
            return null;
        }
        List<HtmlElement> labelElements = page.getByXPath("//div[@class='info2']//li");
        String technology = "";
        String difficulty = "";
        String numberOfPeople = "";
        String taste = "";
        String setupTime = "";
        String cookTime = "";
        for (HtmlElement labelElement : labelElements) {
            String labelName = labelElement.getFirstElementChild().asText();
            String labelValue = labelElement.getLastElementChild().asText();
            switch (labelName) {
                case "工艺":
                    technology = labelValue;
                    break;
                case "难度":
                    difficulty = labelValue;
                    break;
                case "人数":
                    numberOfPeople = labelValue;
                    break;
                case "口味":
                    taste = labelValue;
                    break;
                case "准备时间":
                    setupTime = labelValue;
                    break;
                case "烹饪时间":
                    cookTime = labelValue;
                    break;
                default:
                    break;
            }
        }
        List<HtmlElement> descriptionElements = page.getByXPath("//div[@class='materials']/p");
        String description = CollectionUtils.isNotEmpty(descriptionElements) ? descriptionElements.get(0).asText() : "";

        List<HtmlElement> materialElements = page.getByXPath("//div[@class='materials_box']/div");
        List<FoodMaterial> mainIngredients = Lists.newArrayList();
        List<FoodMaterial> supIngredients = Lists.newArrayList();
        for (HtmlElement materialElement : materialElements) {
            String materialTitle = materialElement.getElementsByTagName("h3").get(0).asText();
            switch (materialTitle) {
                case "主料":
                    List<HtmlElement> mainElements = materialElement.getElementsByTagName("h4");
                    mainIngredients = mainElements.stream().map(e -> {
                        FoodMaterial foodMaterial = new FoodMaterial();
                        foodMaterial.setName(e.getFirstElementChild().asText());
                        foodMaterial.setUsage(e.getLastElementChild().asText());
                        return foodMaterial;
                    }).collect(Collectors.toList());
                    break;
                case "辅料":
                    List<HtmlElement> supElements = materialElement.getElementsByTagName("li");
                    supIngredients = supElements.stream().map(e -> {
                        FoodMaterial foodMaterial = new FoodMaterial();
                        foodMaterial.setName(e.getElementsByTagName("h4").get(0).asText());
                        foodMaterial.setUsage(e.getElementsByTagName("span").get(0).asText());
                        return foodMaterial;
                    }).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        
        List<HtmlElement> stepElements = page.getByXPath("//div[@class='editnew edit']//div[@class='content clearfix']");
        List<Step> steps = Lists.newArrayList();
        if (CollectionUtils.isEmpty(stepElements)) {
            stepElements = page.getByXPath("//div[@class='edit edit_class_0']/p");
            if (CollectionUtils.isEmpty(stepElements)) {
                stepElements = page.getByXPath("//div[@class='edit edit_class_0 edit_class_13']/p");
            }
            if (CollectionUtils.isEmpty(stepElements)) {
                stepElements = page.getByXPath("//div[@class='edit edit_class_13 edit_class_10']/p");
            }
            if (CollectionUtils.isEmpty(stepElements)) {
                stepElements = page.getByXPath("//div[@class='edit edit_class_0 edit_class_2']/p");
            }
            if (CollectionUtils.isEmpty(stepElements)) {
                stepElements = page.getByXPath("//div[@class='measure']//div[@data-plugin='keyword']/p");
            }
            HtmlElement stepElement;
            HtmlElement pictureElement;
            for (int i = 0, len = stepElements.size(); i < len; i++) {
                stepElement = stepElements.get(i);
                if (!isStepElement(stepElement)) {
                    continue;
                }
                if (isStepPictureElement(stepElement)) {
                    continue;
                }
                Step step = new Step();
                step.setDesc(stepElement.asText());
                if (i + 1 < len) {
                    pictureElement = stepElements.get(i + 1);
                    if (isStepPictureElement(pictureElement)) {
                        step.setPicture(pictureElement.getElementsByTagName("img").get(0).getAttribute("src"));
                    }
                }
                steps.add(step);
            }
        } else {
            steps = stepElements.stream().map(e -> {
                Step step = new Step();
                step.setDesc(e.asText());
                List<HtmlElement> imgElements = e.getElementsByTagName("img");
                String picture = CollectionUtils.isNotEmpty(imgElements) ? imgElements.get(0).getAttribute("src") : "";
                step.setPicture(picture);
                return step;
            }).collect(Collectors.toList());
        }
        
        List<HtmlElement> contentElements = page.getByXPath("//div[@class='editnew edit']");
        if (CollectionUtils.isEmpty(contentElements)) {
            contentElements = page.getByXPath("//div[@class='edit edit_class_0']");
            if (CollectionUtils.isEmpty(contentElements)) {
                contentElements = page.getByXPath("//div[@class='edit edit_class_0 edit_class_13']");
            }
            if (CollectionUtils.isEmpty(contentElements)) {
                contentElements = page.getByXPath("//div[@class='edit edit_class_13 edit_class_10']");
            }
            if (CollectionUtils.isEmpty(contentElements)) {
                contentElements = page.getByXPath("//div[@class='edit edit_class_0 edit_class_2']");
            }
            if (CollectionUtils.isEmpty(contentElements)) {
                contentElements = page.getByXPath("//div[@class='measure']//div[@data-plugin='keyword']");
            }
        }
        HtmlElement contentElement = contentElements.get(0);
        List<DomElement> contentChildrenElements = Lists.newArrayList(contentElement.getChildElements());
        String tip = "";
        if (CollectionUtils.isNotEmpty(contentChildrenElements) && contentChildrenElements.size() >= 2) {
            DomElement jiqiaoElement = contentChildrenElements.get(contentChildrenElements.size() - 2);
            if ("烹饪技巧".equals(jiqiaoElement.asText())) {
                tip = contentChildrenElements.get(contentChildrenElements.size() - 1).asText();
            }
        }
        CookbookDetailPage cookbookDetailPage = new CookbookDetailPage();
        cookbookDetailPage.setOriginUrl(url);
        cookbookDetailPage.setTitle(title);
        cookbookDetailPage.setCoverPicture(coverPicture);
        cookbookDetailPage.setTechnology(technology);
        cookbookDetailPage.setDifficulty(difficulty);
        cookbookDetailPage.setNumberOfPeople(numberOfPeople);
        cookbookDetailPage.setTaste(taste);
        cookbookDetailPage.setSetupTime(setupTime);
        cookbookDetailPage.setCookTime(cookTime);
        cookbookDetailPage.setDescription(description);
        cookbookDetailPage.setMainIngredients(mainIngredients);
        cookbookDetailPage.setSupIngredients(supIngredients);
        cookbookDetailPage.setSteps(steps);
        cookbookDetailPage.setTip(tip);
        return cookbookDetailPage;
    }
    
    public static boolean isStepElement(HtmlElement htmlElement) {
        boolean flag = false;
        List<HtmlElement> emElements = htmlElement.getElementsByTagName("em");
        if (CollectionUtils.isNotEmpty(emElements)) {
            HtmlElement emElement = emElements.get(0);
            String classAttr = emElement.getAttribute("class");
            if ("step".equals(classAttr)) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean isStepPictureElement(HtmlElement htmlElement) {
        boolean flag = false;
        List<HtmlElement> emElements = htmlElement.getElementsByTagName("img");
        if (CollectionUtils.isNotEmpty(emElements)) {
            HtmlElement emElement = emElements.get(0);
            String classAttr = emElement.getAttribute("class");
            if ("conimg".equals(classAttr)) {
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "https://www.meishij.net/zuofa/laizuojidaofengxiongcai.html";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
