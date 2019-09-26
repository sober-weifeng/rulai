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
 * @date 2019/9/11 18:47
 */
@Data
@Slf4j
public class TopCategoryPage {
    
    private String orginUrl;
    
    private List<TopCategory> categories;
    
    @Data
    public static class TopCategory {
        private String categoryName;
        private String categoryUrl;
    }
    
    public static BizResult<TopCategoryPage> crawl(WebClient webClient) {
       BizResult<TopCategoryPage> result = BizResult.custom();
       try {
           String prefix = "http://www.ttmeishi.com";
           String url = "http://www.ttmeishi.com/";
           log.info("爬取顶级分类页面：{}", url);
           HtmlPage page = webClient.getPage(url);
           if (HtmlUnitHelper.isFailPage(page)) {
               log.error("获取页面不正确，url：{}", url);
               return result.fail("获取页面不正确");
           }
           List<HtmlElement> contentElements = page.getByXPath("//ul[@id='navs_zhu']/li/a");
           if (contentElements.size() > 2) {
               contentElements.remove(contentElements.size() - 1);
               contentElements.remove(0);
           }
           List<TopCategory> topCategories = contentElements.stream().map(e -> {
               String categoryName = e.asText();
               String categoryUrl = prefix.concat(e.getAttribute("href"));
               TopCategory topCategory = new TopCategory();
               topCategory.setCategoryName(categoryName);
               topCategory.setCategoryUrl(categoryUrl);
               return topCategory;
           }).collect(Collectors.toList());
           TopCategoryPage categoryPage = new TopCategoryPage();
           categoryPage.setOrginUrl(url);
           categoryPage.setCategories(topCategories);
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
