package com.rulai.spider.controller;

import com.rulai.common.component.BizResult;
import com.rulai.spider.service.FancaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/12 14:03
 */
@RestController
@RequestMapping("/fancai")
public class FancaiController {
    
    @Autowired
    private FancaiService fancaiService;
    
    @GetMapping("/crawl-category")
    public BizResult crawlCategory() {
        return fancaiService.crawlCategory();
    }
    
    @GetMapping("/crawl-cookbook-url-with-splitter")
    public BizResult crawlCookbookUrlWithSplitter() {
        return fancaiService.crawlCookbookUrlWithSplitter();
    }

    @GetMapping("/crawl-cookbook-detail-with-splitter")
    public BizResult crawlCookbookDetailWithSplitter() {
        return fancaiService.crawlCookbookDetailWithSplitter();
    }
    
}
