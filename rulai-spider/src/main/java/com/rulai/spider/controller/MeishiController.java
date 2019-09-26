package com.rulai.spider.controller;

import com.rulai.common.component.BizResult;
import com.rulai.spider.service.MeishiService;
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
@RequestMapping("/meishi")
public class MeishiController {
    
    @Autowired
    private MeishiService meishiService;
    
    @GetMapping("/crawl-category")
    public BizResult crawlCategory() {
        return meishiService.crawlCategory();
    }
    
    @GetMapping("/crawl-cookbook-url-with-splitter")
    public BizResult crawlCookbookUrlWithSplitter() {
        return meishiService.crawlCookbookUrlWithSplitter();
    }

    @GetMapping("/crawl-cookbook-detail-with-splitter")
    public BizResult crawlCookbookDetailWithSplitter() {
        return meishiService.crawlCookbookDetailWithSplitter();
    }
    
}
