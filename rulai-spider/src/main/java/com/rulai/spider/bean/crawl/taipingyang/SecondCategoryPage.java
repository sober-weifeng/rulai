package com.rulai.spider.bean.crawl.taipingyang;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/21 14:05
 */
@Data
@Slf4j
public class SecondCategoryPage {
    
    private String originUrl;
    
    private List<SecondCategory> secondCategories;
    
    @Data
    public static class SecondCategory {
        private String categoryName;
        private String labelId;
        private List<ThirdCategory> thirdCategories;
    }

    @Data
    public static class ThirdCategory {
        private String categoryName;
        private String firstCategoryUrl;
    }
    
    public static SecondCategoryPage crawlSecondCategoryPage(String originUrl) throws IOException {
        String protocol = originUrl.split("//")[0];
        WebClient webClient = HtmlUnitHelper.getWebClient();
        HtmlPage page = webClient.getPage(originUrl);
        int responseCode = page.getWebResponse().getStatusCode();
        if (200 != responseCode) {
            log.error("获取页面不正确，code：{}，url：{}", responseCode, originUrl);
            return null;
        }
        List<HtmlElement> contentElement = page.getByXPath("//div[@id='Jbaike']/div");
        int length = contentElement.size();
        if (length % 2 != 0) {
            return null;
        }
        SecondCategoryPage secondCategoryPage = new SecondCategoryPage();
        String secondCategoryName;
        List<SecondCategory> secondCategories = Lists.newArrayList();
        SecondCategory secondCategory;
        for (int i = 0, len = contentElement.size(); i < len - 1; i++) {
            if (i % 2 == 1) {
                continue;
            }
            HtmlElement secondCategoryElement = contentElement.get(i);
            HtmlElement thirdCategoryElement = contentElement.get(i + 1);
            secondCategoryName = secondCategoryElement.asText();
            secondCategory = new SecondCategory();
            secondCategory.setCategoryName(secondCategoryName);
            secondCategory.setLabelId(secondCategoryElement.getAttribute("id"));
            secondCategory.setThirdCategories(analysisThirdCategoryList(thirdCategoryElement, protocol));
            secondCategories.add(secondCategory);
        }
        webClient.close();
        secondCategoryPage.setSecondCategories(secondCategories);
        secondCategoryPage.setOriginUrl(originUrl);
        return secondCategoryPage;
    }

    public static List<ThirdCategory> analysisThirdCategoryList(HtmlElement element, String protocol) {
        List<HtmlElement> thirdCategoryElements = element.getElementsByTagName("dt");
        List<ThirdCategory> thirdCategories = thirdCategoryElements.stream()
                .map(e -> analysisThirdCategory(e, protocol)).collect(Collectors.toList());
        return thirdCategories;
    }

    public static ThirdCategory analysisThirdCategory(HtmlElement element, String protocol) {
        ThirdCategory thirdCategory = new ThirdCategory();
        HtmlElement hrefElement = element.getElementsByTagName("a").get(0);
        thirdCategory.setCategoryName(hrefElement.asText());
        String firstUrl = protocol.concat(hrefElement.getAttribute("href"));
        thirdCategory.setFirstCategoryUrl(firstUrl);
        return thirdCategory;
    }

//    public static void main(String[] args) throws IOException {
//        log.info(JSON.toJSONString(crawlSecondCategoryPage("https://baike.pcbaby.com.cn/recipe/mama.html")));
//    }
    
}
