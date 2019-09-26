package com.rulai.spider.bean.crawl.tiantian;

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
 * @date 2019/9/11 18:47
 */
@Data
@Slf4j
public class SecondCategoryPage {
    
    private String orginUrl;
    
    private List<SecondCategory> categories;
    
    @Data
    public static class SecondCategory {
        private String fatherName;
        private String categoryName;
        private String categoryUrl;
    }
    
    public static BizResult<SecondCategoryPage> crawl(String url, WebClient webClient) {
       BizResult<SecondCategoryPage> result = BizResult.custom();
       try {
           String prefix = "http://www.ttmeishi.com";
           log.info("爬取顶级分类页面：{}", url);
           HtmlPage page = webClient.getPage(url);
           if (HtmlUnitHelper.isFailPage(page)) {
               log.error("获取页面不正确，url：{}", url);
               return result.fail("获取页面不正确");
           }
           List<HtmlElement> contentElements = page.getByXPath("//div[@class='cx_i_main']");
           HtmlElement contentElement = contentElements.stream().findFirst().orElse(null);
           if (null == contentElement) {
               log.error("内容无分类导航，url：{}", url);
               return result.fail("内容无分类导航");
           }
           List<DomElement> categoryElements = Lists.newArrayList(contentElement.getChildElements());
           categoryElements = categoryElements.stream().filter(e -> !"div".equals(e.getTagName())).collect(Collectors.toList());
           List<SecondCategory> secondCategories = Lists.newArrayList();
           for (int i = 0, len = categoryElements.size(); i < len - 1; i++) {
               if (i % 2 != 0) {
                   continue;
               }
               DomElement fatherElement = categoryElements.get(i);
               List<HtmlElement> secondElements = categoryElements.get(i + 1).getElementsByTagName("a");
               String fatherName = Optional.ofNullable(fatherElement).map(DomElement::asText).orElse("");
               for (HtmlElement secondElement : secondElements) {
                   secondElement.removeChild("span", 0);
                   String categoryName = secondElement.asText();
                   String categoryUrl = prefix.concat(secondElement.getAttribute("href"));
                   SecondCategory secondCategory = new SecondCategory();
                   secondCategory.setCategoryName(categoryName);
                   secondCategory.setCategoryUrl(categoryUrl);
                   secondCategory.setFatherName(fatherName);
                   secondCategories.add(secondCategory);
               }
           }
           SecondCategoryPage categoryPage = new SecondCategoryPage();
           categoryPage.setOrginUrl(url);
           categoryPage.setCategories(secondCategories);
           result.success().data(categoryPage);
       } catch (Exception e) {
           log.error(e.getMessage(), e);
           result.fail(BizResultCodeEnum.EXCEPTION);
       }
       return result;
    }

    public static void main(String[] args) {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        String url = "http://www.ttmeishi.com/CaiXi/tese/";
        log.info(JSON.toJSONString(crawl(url, webClient)));
        webClient.close();
    }
    
}
