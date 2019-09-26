package com.rulai.spider.enums;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/22 17:38
 */
public enum IsCrawledEnum {
    
    NO(1, "未爬"),
    YES(2, "已爬"),
    ;
    
    private int code;
    
    private String message;

    IsCrawledEnum(int code, String message) {
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
