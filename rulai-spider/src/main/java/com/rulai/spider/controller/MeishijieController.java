package com.rulai.spider.controller;

import com.rulai.common.component.BizResult;
import com.rulai.spider.service.MeishijieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/3 15:12
 */
@RestController
@RequestMapping("/meishijie")
public class MeishijieController {
    
    @Autowired
    private MeishijieService meishijieService;
    
    @GetMapping("/crawl-top-category")
    public BizResult crawlTopCategory() {
        return meishijieService.crawlTopCategory();
    }

    @GetMapping("/crawl-second-category")
    public BizResult crawlSecondCategory() {
        return meishijieService.crawlSecondCategory();
    }

    @GetMapping("/crawl-cookbook-url-list")
    public BizResult crawlCookbookUrlList() {
        return meishijieService.crawlCookbookUrlList();
    }
    
    @GetMapping("/crawl-cookbook-detail")
    public BizResult crawlCookbookDetail() {
        return meishijieService.crawlCookbookDetail();
    }
    
}
