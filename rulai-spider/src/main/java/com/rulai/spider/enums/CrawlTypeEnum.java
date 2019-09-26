package com.rulai.spider.enums;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/22 17:38
 */
public enum CrawlTypeEnum {
    
    ORIGIN(1, "通用"),
    OTHER(2, "其他"),
    ;
    
    private int code;
    
    private String message;

    CrawlTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
