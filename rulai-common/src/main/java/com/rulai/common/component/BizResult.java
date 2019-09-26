package com.rulai.common.component;

import com.rulai.common.enums.BizResultCodeEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * biz result
 * @author weifeng
 */
public class BizResult<T> implements Serializable {

    private static final long serialVersionUID = -2303180381762553037L;
    
    private String code;

    private String message;

    private T data;

    BizResult() {
        this(BizResultCodeEnum.SYS_ERROR.getCode(), 
                BizResultCodeEnum.SYS_ERROR.getMessage(), 
                null);
    }

    BizResult(final String code, final String message, final T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return BizResultCodeEnum.SUCCESS.getCode().equals(code);
    }

    public boolean isFail() {
        return !isSuccess();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BizResult code(String code) {
        this.code = code;
        return this;
    }

    public BizResult message(String message) {
        this.message = message;
        return this;
    }

    public BizResult data(T data) {
        this.data = data;
        return this;
    }
    
    public BizResult fail(String code, String message) {
        return code(code).message(message);
    }
    
    public BizResult fail(String message) {
        return fail(BizResultCodeEnum.SYS_ERROR.getCode(), message);
    }
    
    public BizResult fail(BizResultCodeEnum bizResultCodeEnum) {
        return fail(bizResultCodeEnum.getCode(), bizResultCodeEnum.getMessage());
    }
    
    public BizResult success() {
        return success(BizResultCodeEnum.SUCCESS.getMessage());
    }

    public BizResult success(String message) {
        return code(BizResultCodeEnum.SUCCESS.getCode()).message(message);
    }
    
    public Map<String, Object> toResponseMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("message", message);
        result.put("data", data);
        return result;
    }

    public static <T> BizResult<T> custom() {
        return new BizResult<>();
    }
}
