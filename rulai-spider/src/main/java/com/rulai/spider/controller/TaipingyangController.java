package com.rulai.spider.controller;

import com.rulai.common.component.BizResult;
import com.rulai.spider.service.TaipingyangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/22 16:38
 */
@RestController
@RequestMapping("/taipingyang")
public class TaipingyangController {
    
    @Autowired
    private TaipingyangService taipingyangService;
    
    @GetMapping("/crawl-top-categories")
    public BizResult crawlTopCategories() {
        return taipingyangService.crawlTopCategories();
    }

    @GetMapping("/crawl-second-categories")
    public BizResult crawlSecondCategories() {
        return taipingyangService.crawlSecondCategories();
    }
    
    @GetMapping("/crawl-cookbook-urls")
    public BizResult crawlCookbookUrls() {
        return taipingyangService.crawlCookbookUrls();
    }

    @GetMapping("/crawl-cookbook-details")
    public BizResult crawlCookbookDetails() {
        return taipingyangService.crawlCookbookDetails();
    }
    
    @GetMapping("/crawl-all-from-start")
    public BizResult crawlAllFromStart() {
        return taipingyangService.crawlAll(Boolean.TRUE.booleanValue());
    }

    @GetMapping("/crawl-all-go-on-last-time")
    public BizResult crawlAllGoOnLastTime() {
        return taipingyangService.crawlAll(Boolean.FALSE.booleanValue());
    }
    
}
