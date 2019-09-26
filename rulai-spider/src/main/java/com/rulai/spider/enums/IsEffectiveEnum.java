package com.rulai.spider.enums;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/8/22 17:38
 */
public enum IsEffectiveEnum {
    
    YES(1, "有效"),
    NO(2, "无效"),
    ;
    
    private int code;
    
    private String message;

    IsEffectiveEnum(int code, String message) {
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
