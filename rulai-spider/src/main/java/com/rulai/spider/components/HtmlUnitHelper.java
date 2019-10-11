package com.rulai.spider.components;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.google.common.collect.Lists;
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

    private static List<ProxyConfig> httpProxies = Lists.newArrayList();
    private static List<ProxyConfig> httpsProxies = Lists.newArrayList();
    
    static {
        httpProxies.add(new ProxyConfig("124.207.82.166", 8008));
//        httpProxies.add(new ProxyConfig("180.117.128.143", 8118));
//        httpProxies.add(new ProxyConfig("27.128.187.22", 3128));
        httpProxies.add(new ProxyConfig("120.25.253.234", 8118));
        httpProxies.add(new ProxyConfig("222.249.238.138", 8080));
//        httpProxies.add(new ProxyConfig("222.240.184.126", 8086));
        
//        httpsProxies.add(new ProxyConfig("119.39.68.130", 808));
        httpsProxies.add(new ProxyConfig("61.128.208.94", 3128));
//        httpsProxies.add(new ProxyConfig("113.119.38.204", 3128));
        httpsProxies.add(new ProxyConfig("27.191.234.69", 9999));
//        httpsProxies.add(new ProxyConfig("124.205.143.213", 32612));
        httpsProxies.add(new ProxyConfig("124.232.133.199", 3128));
//        httpsProxies.add(new ProxyConfig("221.229.252.98", 8080));
        httpsProxies.add(new ProxyConfig("120.78.225.5", 3128));
    }
    
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

    public static void main(String[] args) {
        int timeout = 60000;
        int waitForBackgroundJavaScript = 20000;
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setTimeout(timeout);
        webClient.setJavaScriptTimeout(timeout);
        webClient.waitForBackgroundJavaScript(waitForBackgroundJavaScript);

        String httpsUrl = "https://www.163.com";
        String httpUrl = "http://www.xiachufang.com/category/40078/";
        for (ProxyConfig httpsProxy : httpsProxies) {
            webClient.getOptions().setProxyConfig(httpsProxy);
            try {
                Page page = webClient.getPage(httpsUrl);
                int responseCode = page.getWebResponse().getStatusCode();
                log.info("https proxy {} {} success, code = {}", httpsProxy.getProxyHost(), httpsProxy.getProxyPort(), responseCode);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                log.info("https proxy {} {} error", httpsProxy.getProxyHost(), httpsProxy.getProxyPort());
            }
        }

        for (ProxyConfig httpProxy : httpProxies) {
            webClient.getOptions().setProxyConfig(httpProxy);
            try {
                Page page = webClient.getPage(httpUrl);
                int responseCode = page.getWebResponse().getStatusCode();
                log.info("http proxy {} {} success, code = {}", httpProxy.getProxyHost(), httpProxy.getProxyPort(), responseCode);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                log.info("http proxy {} {} error", httpProxy.getProxyHost(), httpProxy.getProxyPort());
            }
        }
    }

}
