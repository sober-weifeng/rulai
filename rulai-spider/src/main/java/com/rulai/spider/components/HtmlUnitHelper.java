package com.rulai.spider.components;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/19 18:50
 */
@Slf4j
public class HtmlUnitHelper {

    private static List<String> userAgents = Lists.newArrayList(
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 OPR/26.0.1656.60"
            , "Opera/8.0 (Windows NT 5.1; U; en)"
            , "Mozilla/5.0 (Windows NT 5.1; U; en; rv:1.8.1) Gecko/20061208 Firefox/2.0.0 Opera 9.50"
            , "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; en) Opera 9.50"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0"
            , "Mozilla/5.0 (X11; U; Linux x86_64; zh-CN; rv:1.9.2.10) Gecko/20100922 Ubuntu/10.10 (maverick) Firefox/3.6.10"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36"
            , "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11"
            , "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.133 Safari/534.16"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.11 TaoBrowser/2.0 Safari/536.11"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.71 Safari/537.1 LBBROWSER"
            , "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; LBBROWSER)"
            , "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E; LBBROWSER)"
            , "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; QQBrowser/7.0.3698.400)"
            , "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E)"
            , "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.84 Safari/535.11 SE 2.X MetaSr 1.0"
            , "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SV1; QQDownload 732; .NET4.0C; .NET4.0E; SE 2.X MetaSr 1.0)"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Maxthon/4.4.3.4000 Chrome/30.0.1599.101 Safari/537.36"
            , "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 UBrowser/4.0.3214.0 Safari/537.36"
    );
    
    public static WebClient getWebClient() {
        return getWebClient(Boolean.FALSE.booleanValue());
    }

    /**
     * 生成webclient
     * @return
     */
    public static WebClient getWebClient(boolean javaScriptEnabled) {
        int timeout = 30000;
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

    /**
     * 随机获取user agent
     * @return
     */
    public static String getRandomUserAgent() {
        return userAgents.get(new Random().nextInt(userAgents.size()));
    }

    /**
     * 随机获取一个代理ip
     * @return
     * @throws IOException
     */
    public static String getRandomProxy() throws IOException {
        String proxyUrl = "http://10.0.10.101:5010/get/";
        String proxy = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(proxyUrl);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity, "utf-8");
            JSONObject data = JSON.parseObject(body);
            proxy = data.getString("proxy");
        }
        httpclient.close();
        return proxy;
    }

    public static ProxyConfig getProxyConfig(String proxy) throws IOException {
        String[] ipAndPort = proxy.split(":");
        return new ProxyConfig(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
    }
    
    public static ProxyConfig getRandomProxyConfig() throws IOException {
        return getProxyConfig(getRandomProxy());
    }
    
    public static void deleteProxy(String proxy) throws IOException {
        String url = "http://10.0.10.101:5010/delete/?proxy=" + proxy;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpclient.execute(httpGet);
        httpclient.close();
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRandomProxy());
        }
    }

}
