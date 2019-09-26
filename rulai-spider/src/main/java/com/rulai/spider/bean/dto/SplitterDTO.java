package com.rulai.spider.bean.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/12 14:21
 */
@Data
public class SplitterDTO {

    private BigDecimal minVal;

    private BigDecimal maxVal;

    private int totalCount;
    
}
