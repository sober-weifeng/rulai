package com.rulai.spider.bean.crawl.proxy;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rulai.common.component.BizResult;
import com.rulai.common.enums.BizResultCodeEnum;
import com.rulai.spider.components.HtmlUnitHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/10 17:59
 */
@Slf4j
@Data
public class XicidailiHttpPage {
    
    private List<Proxy> proxies;
    
    @Data
    public static class Proxy {
        private String host;
        private int port;
    }
    
    public static BizResult<XicidailiHttpPage> crawl(WebClient webClient) {
        BizResult<XicidailiHttpPage> result = BizResult.custom();
        try {
//            String prefix = "http://www.xiachufang.com";
            String url = "https://www.xicidaili.com/wt/";
            log.info("代理页面：{}", url);
            HtmlPage page = webClient.getPage(url);
            if (HtmlUnitHelper.isFailPage(page)) {
                log.error("获取页面不正确，url：{}", url);
                return result.fail("获取页面不正确");
            }
            List<HtmlElement> contentElements = page.getByXPath("//table[@id='ip_list']//tr");
            if (CollectionUtils.isNotEmpty(contentElements)) {
                contentElements.remove(0);
            }
            List<Proxy> proxies = contentElements.parallelStream().map(element -> {
                List<HtmlElement> tdElements = element.getElementsByTagName("td");
                Proxy proxy = new Proxy();
                proxy.setHost(tdElements.get(1).asText().trim());
                proxy.setPort(Optional.ofNullable(tdElements.get(2).asText().trim()).map(Integer::parseInt).orElse(0));
                return proxy;
            }).collect(Collectors.toList());
            XicidailiHttpPage xicidailiHttpPage = new XicidailiHttpPage();
            xicidailiHttpPage.setProxies(proxies);
            result.success().data(xicidailiHttpPage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.fail(BizResultCodeEnum.EXCEPTION);
        }
        return result;
    }
    
    public static void analsisProxy() {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        BizResult<XicidailiHttpPage> result = crawl(webClient);
        if (result.isFail()) {
            return;
        }
        List<ProxyConfig> proxyConfigs = result.getData().getProxies().parallelStream()
                .map(proxy -> new ProxyConfig(proxy.getHost(), proxy.getPort()))
                .collect(Collectors.toList());
        for (ProxyConfig proxyConfig : proxyConfigs) {
            webClient.getOptions().setProxyConfig(proxyConfig);
            try {
                Page page = webClient.getPage("http://www.xiachufang.com/category/40078/");
                int responseCode = page.getWebResponse().getStatusCode();
                log.info("http proxy {} {} success, code = {}", proxyConfig.getProxyHost(), proxyConfig.getProxyPort(), responseCode);
            } catch (IOException e) {
                //log.error(e.getMessage(), e);
                //log.info("http proxy {} {} error", proxyConfig.getProxyHost(), proxyConfig.getProxyPort());
            }
        }
        webClient.close();
    }

    public static void main(String[] args) {
        analsisProxy();
    }
    
}
