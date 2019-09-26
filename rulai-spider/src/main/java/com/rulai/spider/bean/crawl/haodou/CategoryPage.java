package com.rulai.spider.bean.crawl.haodou;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
        private String categoryUrl;
    }
    
    public static BizResult<CategoryPage> crawl(WebClient webClient) {
       BizResult<CategoryPage> result = BizResult.custom();
       try {
           String prefix = "https://www.haodou.com";
           String url = "https://www.haodou.com/recipe/all";
           log.info("爬取分类页面：{}", url);
           HtmlPage page = webClient.getPage(url);
           if (HtmlUnitHelper.isFailPage(page)) {
               log.error("获取页面不正确，url：{}", url);
               return result.fail("获取页面不正确");
           }
           List<HtmlElement> contentElements = page.getByXPath("//div[@class='category-tag-list']");
           List<Category> categories = Lists.newArrayList();
           for (HtmlElement contentElement : contentElements) {
               String firstCategoryName = contentElement.getElementsByTagName("h3").stream().findFirst().map(HtmlElement::asText).orElse("");
               List<HtmlElement> secondElements = contentElement.getElementsByTagName("a");
               for (HtmlElement secondElement : secondElements) {
                   String secondCategoryName = secondElement.asText();
                   String categoryUrl = prefix.concat(secondElement.getAttribute("href"));
                   Category category = new Category();
                   category.setFirstCategoryName(firstCategoryName);
                   category.setSecondCategoryName(secondCategoryName);
                   category.setCategoryUrl(categoryUrl);
                   categories.add(category);
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
