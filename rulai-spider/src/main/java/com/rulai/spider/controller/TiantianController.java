package com.rulai.spider.controller;

import com.rulai.common.component.BizResult;
import com.rulai.spider.service.TiantianService;
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
@RequestMapping("/tiantian")
public class TiantianController {
    
    @Autowired
    private TiantianService tiantianService;
    
    @GetMapping("/crawl-top-category")
    public BizResult crawlTopCategory() {
        return tiantianService.crawlTopCategory();
    }

    @GetMapping("/crawl-second-category")
    public BizResult crawlSecondCategory() {
        return tiantianService.crawlSecondCategory();
    }
    
    @GetMapping("/crawl-cookbook-url-with-splitter")
    public BizResult crawlCookbookUrlWithSplitter() {
        return tiantianService.crawlCookbookUrlWithSplitter();
    }

    @GetMapping("/crawl-cookbook-detail-with-splitter")
    public BizResult crawlCookbookDetailWithSplitter() {
        return tiantianService.crawlCookbookDetailWithSplitter();
    }
    
}
