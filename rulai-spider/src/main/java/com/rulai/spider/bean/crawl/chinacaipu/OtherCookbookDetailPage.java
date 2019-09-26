package com.rulai.spider.bean.crawl.chinacaipu;

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

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/29 15:35
 */
@Data
@Slf4j
public class OtherCookbookDetailPage {

    public static final String PREFIX = "http://www.chinacaipu.com/menu";

    private String originUrl;
    
    private OtherCookbookDetail otherCookbookDetail;
    
    @Data
    public static class OtherCookbookDetail {
        private String title;
        private String author;
        private String editTime;
        private String description;
        private String coverPicture;
        private String detail;
    }
    
    public static OtherCookbookDetailPage crawlOtherCookbookDetailPage(String url, WebClient webClient) 
            throws IOException {
        log.info("爬取食谱明细页面：{}", url);
        if (!url.startsWith(PREFIX)) {
            log.error("该页面不是第三方食谱页面，爬取方式不同");
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
        HtmlElement titleElement = (HtmlElement) page.getByXPath("//h1[@class='contit']").get(0);
        String title = titleElement.asText();
        List<HtmlElement> infoElements = page.getByXPath("//div[@class='info']//span[@class='info_txt']");
        String author = infoElements.size() >= 1 ? infoElements.get(0).asText() : "";
        String editTime = infoElements.size() >= 2 ? infoElements.get(1).asText() : "";

        HtmlElement contentElement = (HtmlElement) page.getByXPath("//div[@id='content']").get(0);
        List<DomElement> contentElements = Lists.newArrayList(contentElement.getChildElements());
        String description = "";
        String coverPicture = "";
        if (CollectionUtils.isNotEmpty(contentElements)) {
            DomElement tmpElement = contentElements.get(0).getFirstElementChild();
            String tmp = null != tmpElement ? tmpElement.getAttribute("src") : "";
            if (StringUtils.isNotEmpty(tmp)) {
                description = "";
                coverPicture = tmp;
            } else {
                if (contentElements.size() >= 2) {
                    tmpElement = contentElements.get(1).getFirstElementChild();
                    tmp = null != tmpElement ? tmpElement.getAttribute("src") : "";
                    if (StringUtils.isNotEmpty(tmp)) {
                        coverPicture = tmp;
                        description = contentElements.size() >= 1 ? contentElements.get(0).asText() : "";
                    }
                }
            }
        }
        
        String detail = "";
        if (contentElements.size() > 6) {
            StringBuilder detailBuilder = new StringBuilder(500);
            List<DomElement> detailElements = contentElements.subList(3, contentElements.size() - 3);
            DomElement domNode;
            for (int i = 0, len = detailElements.size(); i < len; i++) {
                domNode = detailElements.get(i);
                detailBuilder.append(domNode.asText());
                if (i != len - 1) {
                    detailBuilder.append("\r\n");
                }
            }
            detail = detailBuilder.toString();
        }
        
        OtherCookbookDetail otherCookbookDetail = new OtherCookbookDetail();
        otherCookbookDetail.setTitle(title);
        otherCookbookDetail.setAuthor(author);
        otherCookbookDetail.setEditTime(editTime);
        otherCookbookDetail.setDescription(description.trim());
        otherCookbookDetail.setCoverPicture(coverPicture);
        otherCookbookDetail.setDetail(detail.trim());
        OtherCookbookDetailPage otherCookbookDetailPage = new OtherCookbookDetailPage();
        otherCookbookDetailPage.setOriginUrl(url);
        otherCookbookDetailPage.setOtherCookbookDetail(otherCookbookDetail);
        return otherCookbookDetailPage;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.chinacaipu.com/menu/shuichanshipu/4146.html";
        WebClient webClient = HtmlUnitHelper.getWebClient();
        log.info(JSON.toJSONString(crawlOtherCookbookDetailPage(url, webClient)));
        webClient.close();
    }
    
}
