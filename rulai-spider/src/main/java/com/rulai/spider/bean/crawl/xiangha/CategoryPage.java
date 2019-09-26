package com.rulai.spider.bean.crawl.xiangha;

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
           String url = "https://www.xiangha.com/caipu/";
           log.info("爬取分类页面：{}", url);
           HtmlPage page = webClient.getPage(url);
           if (HtmlUnitHelper.isFailPage(page)) {
               log.error("获取页面不正确，url：{}", url);
               return result.fail("获取页面不正确");
           }
           List<HtmlElement> contentElements = page.getByXPath("//div[@class='rec_classify_cell clearfix']");
           List<DomElement> contentsElements = contentElements.stream().findFirst().map(e -> Lists.newArrayList(e.getChildElements())).orElse(Lists.newArrayList());
           contentsElements.removeIf(e -> !e.hasChildNodes() && "ul".equals(e.getNodeName()));
           if (contentsElements.size() > 3) {
               contentsElements.remove(contentsElements.size() - 1);
               contentsElements.remove(contentsElements.size() - 1);
               contentsElements.remove(contentsElements.size() - 1);
           }
           List<Category> categories = Lists.newArrayList();
           for (int i = 0, len = contentsElements.size(); i < len - 1; i++) {
               if (i % 2 != 0) {
                   continue;
               }
               DomElement contentElement = contentsElements.get(i);
               String firstCategoryName = contentElement.asText();
               List<HtmlElement> secondElements = contentsElements.get(i + 1).getElementsByTagName("a");
               for (HtmlElement secondElement : secondElements) {
                   String secondCategoryName = secondElement.asText();
                   String categoryUrl = secondElement.getAttribute("href");
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
