package com.rulai.spider.controller;

import com.rulai.common.component.BizResult;
import com.rulai.spider.service.XinshipuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/6 10:24
 */
@RestController
@RequestMapping("/xinshipu")
public class XinshipuController {
    
    @Autowired
    private XinshipuService xinshipuService;
    
    @GetMapping("/crawl-category")
    public BizResult crawlCategory() {
        return xinshipuService.crawlCategory();
    }

    @GetMapping("/crawl-coobook-url-with-splitter")
    public BizResult crawlCookbookUrlWithSplitter() {
        return xinshipuService.crawlCookbookUrlWithSplitter();
    }

    @GetMapping("/crawl-coobook-url-with-thread")
    public BizResult crawlCookbookUrlWithThread() {
        return xinshipuService.crawlCookbookUrlWithThread();
    }
    
    @GetMapping("/crawl-coobook-detail-with-splitter")
    public BizResult crawlCookbookDetailWithSplitter() {
        return xinshipuService.crawlCookbookDetailWithSplitter();
    }
    
}
