package com.rulai.spider.components;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author z```s
 * @version 1.0
 * @date 2019/8/19 18:34
 */
public class JsoupHelper {

    public static Object fetchNode(String url, String xpath) throws Exception {
        String html;
        try {
            Connection connect = Jsoup.connect(url);
            html = connect.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        HtmlCleaner hc = new HtmlCleaner();
        TagNode tn = hc.clean(html);
        Document dom = new DomSerializer(new CleanerProperties()).createDOM(tn);
        XPath xPath = XPathFactory.newInstance().newXPath();
        Object result = xPath.evaluate(xpath, dom, XPathConstants.NODESET);
        return result;
    }

    /**
     * 获取xpath下的a标签的文本值及href属性值
     * @param url
     * @param xpath
     * @return
     * @throws Exception
     */
    public static Map<String, String> fetchByMap(String url, String xpath) throws Exception {
        Map<String, String> nodeMap = new LinkedHashMap<>();
        Object result = fetchNode(url, xpath);
        if (result instanceof NodeList) {
            NodeList nodeList = (NodeList) result;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node == null) {
                    continue;
                }
                nodeMap.put(node.getTextContent(), node.getAttributes().getNamedItem("href") != null ?
                        node.getAttributes().getNamedItem("href").getTextContent() : "");
            }
        }
        return nodeMap;
    }

    /**
     * 获取xpath下的某个属性值
     * @param url
     * @param xpath
     * @param attr
     * @return
     * @throws Exception
     */
    public static List<String> fetchAttribute(String url, String xpath, String attr) throws Exception {
        List<String> list = new ArrayList<>();
        Object result = fetchNode(url, xpath);
        if (result instanceof NodeList) {
            NodeList nodeList = (NodeList) result;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node == null) {
                    continue;
                }
                list.add(node.getAttributes().getNamedItem(attr).getTextContent());
            }
        }
        return list;
    }

}
