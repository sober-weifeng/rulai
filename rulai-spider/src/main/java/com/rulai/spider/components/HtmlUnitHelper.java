package com.rulai.spider.components;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/19 18:50
 */
@Slf4j
public class HtmlUnitHelper {

    public static WebClient getWebClient() {
        return getWebClient(Boolean.FALSE.booleanValue());
    }

    /**
     * 生成webclient
     * @return
     */
    public static WebClient getWebClient(boolean javaScriptEnabled) {
        int timeout = 60000;
        int waitForBackgroundJavaScript = 20000;
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(javaScriptEnabled);
        webClient.getOptions().setTimeout(timeout);
        webClient.setJavaScriptTimeout(timeout);
        webClient.waitForBackgroundJavaScript(waitForBackgroundJavaScript);
        return webClient;
    }

    /**
     * 获取post的page
     * @param url
     * @param webClient
     * @param params
     * @param headers
     * @return
     */
    public static Page getPostResponse(String url,
                                       WebClient webClient,
                                       Map<String, String> params,
                                       Map<String, String> headers) {
        try {
            WebRequest request = new WebRequest(new URL(url), HttpMethod.POST);
            request.setAdditionalHeaders(headers);
            List<NameValuePair> requestParameters = params.entrySet()
                    .stream().map(e -> new NameValuePair(e.getKey(), e.getValue())).collect(Collectors.toList());
            request.setRequestParameters(requestParameters);
            return webClient.getPage(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载图片
     * @param url
     * @param fileName
     * @param savePath
     * @param imageFormat
     * @throws IOException
     */
    public static void downloadImage(String url, String fileName, String savePath, String imageFormat) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            File imageFile = new File(savePath + fileName + imageFormat);
            FileUtils.copyToFile(inputStream, imageFile);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
    
    public static boolean isSuccessPage(Page page) {
        if (null == page) {
            log.error("获取到的html page对象为空");
            return false;
        }
        int responseCode = page.getWebResponse().getStatusCode();
        boolean isSuccess = 200 == responseCode;
        if (!isSuccess) {
            log.error("responseCode : {}", responseCode);
        }
        if (StringUtils.isEmpty(page.getWebResponse().getContentAsString())) {
            log.error("页面内容为空");
            return false;
        }
        return isSuccess;
    }

    public static boolean isFailPage(Page page) {
        return !isSuccessPage(page);
    }

//    public static void main(String[] args) throws IOException {
//        WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setJavaScriptEnabled(false);
//        HtmlPage page = webClient.getPage("https://www.pcbaby.com.cn/shipu/398/3981388.html");
//        HtmlElement titleElement = (HtmlElement) page.getByXPath("//h1[@class='artTit']").get(0);
//        String title = titleElement.asText();
//        List<HtmlElement> commonInfoElements = page.getByXPath("//p[@class='artSub']//span");
//        String createTime = commonInfoElements.get(0).asText();
//        String from = commonInfoElements.get(1).asText();
//        String auth = commonInfoElements.get(2).asText();
//        List<HtmlElement> contentList = page.getByXPath("//div[@class='artText']//p");
//        
//        for (HtmlElement htmlElement : contentList) {
//            System.out.println("内容：" + htmlElement.asXml());
//            List<HtmlElement> imageList = htmlElement.getElementsByTagName("img");
//            if (!imageList.isEmpty()) {
//                for (HtmlElement element : imageList) {
//                    System.out.println("图片：https:" + element.getAttribute("#src"));
//                }
//            }
//        }
//    }

}
