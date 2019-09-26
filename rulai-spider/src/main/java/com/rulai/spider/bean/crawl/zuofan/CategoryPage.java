package com.rulai.spider.bean.crawl.zuofan;

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
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/11 18:47
 */
@Data
@Slf4j
public class CategoryPage {
    
    private String orginUrl;
    
    private List<Category> categories;
    
    @Data
    public static class Category {
        private String firstCategoryName;
        private String secondCategoryName;
        private String thirdCategoryName;
        private String categoryUrl;
    }
    
    public static BizResult<CategoryPage> crawl(WebClient webClient) {
       BizResult<CategoryPage> result = BizResult.custom();
       try {
           String prefix = "http://www.zuofan.cn";
           String url = "http://www.zuofan.cn/";
           log.info("爬取分类页面：{}", url);
           HtmlPage page = webClient.getPage(url);
           if (HtmlUnitHelper.isFailPage(page)) {
               log.error("获取页面不正确，url：{}", url);
               return result.fail("获取页面不正确");
           }
           List<HtmlElement> contentElements = page.getByXPath("//div[@class='w1180 wa relative zindex99']//dl");
           if (CollectionUtils.isNotEmpty(contentElements)) {
               contentElements.remove(0);
           }
           List<Category> categories = Lists.newArrayList();
           for (int i = 0, len = contentElements.size(); i < len; i++) {
               HtmlElement contentElement = contentElements.get(i);
               String firstCategoryName = contentElement.getElementsByTagName("dt").stream().findFirst().map(HtmlElement::asText).orElse("");
               List<DomElement> secondContentElements = contentElement.getElementsByTagName("dd")
                       .stream().findFirst().map(e -> Lists.newArrayList(e.getChildElements())).orElse(Lists.newArrayList());
               if (CollectionUtils.isNotEmpty(secondContentElements)) {
                   secondContentElements.remove(0);
               }
               for (int j = 0, secondLen = secondContentElements.size(); j < secondLen - 1; j++) {
                   if (j % 2 != 0) {
                       continue;
                   }
                   String secondCategoryName = secondContentElements.get(j).asText();
                   List<HtmlElement> thirdElements = secondContentElements.get(j + 1).getElementsByTagName("a");
                   for (HtmlElement thirdElement : thirdElements) {
                       String thirdCategoryName = thirdElement.asText();
                       String categoryUrl = prefix.concat(thirdElement.getAttribute("href"));
                       Category category = new Category();
                       category.setFirstCategoryName(firstCategoryName);
                       category.setSecondCategoryName(secondCategoryName);
                       category.setThirdCategoryName(thirdCategoryName);
                       category.setCategoryUrl(categoryUrl);
                       categories.add(category);
                   }
               }
           }
           CategoryPage categoryPage = new CategoryPage();
           categoryPage.setOrginUrl(url);
           categoryPage.setCategories(categories);
           result.success().data(categoryPage);
       } catch (Exception e) {
           log.error(e.getMessage(), e);
           result.fail(BizResultCodeEnum.EXCEPTION);
       }
       return result;
    }

    public static void main(String[] args) {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        log.info(JSON.toJSONString(crawl(webClient)));
        webClient.close();
    }
    
}
