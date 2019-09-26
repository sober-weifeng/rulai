package com.rulai.spider.controller;

import com.rulai.common.component.BizResult;
import com.rulai.spider.service.ChinacaipuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/27 18:12
 */
@RestController
@RequestMapping("/chinacaipu")
public class ChinacaipuController {
    
    @Autowired
    private ChinacaipuService chinacaipuService;
    
    @GetMapping("/crawl-top-category-page")
    public BizResult crawlTopCategoryPage() {
        return chinacaipuService.crawlTopCategoryPage();
    }
    
    @GetMapping("/crawl-second-cookbook-list-page")
    public BizResult crawlSecondCookbookListPage() {
        return chinacaipuService.crawlSecondCookbookListPage();
    }

    @GetMapping("/crawl-top-cookbook-list-page")
    public BizResult crawlTopCookbookListPage() {
        return chinacaipuService.crawlTopCookbookListPage();
    }

    @GetMapping("/crawl-original-cookbook-detail-page")
    public BizResult crawlOriginalCookbookDetailPage() {
        return chinacaipuService.crawlOriginalCookbookDetailPage();
    }

    @GetMapping("/crawl-other-cookbook-detail-page")
    public BizResult crawlOtherCookbookDetailPage() {
        return chinacaipuService.crawlOtherCookbookDetailPage();
    }
    
}
