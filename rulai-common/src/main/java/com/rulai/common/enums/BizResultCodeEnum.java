package com.rulai.common.enums;

/**
 * Created by zhaoshuai on 2017/2/14.
 */
public enum BizResultCodeEnum {
    
    /*
     * 错误码结构: 两位一级类别+两位二级类别代码+三位错误码<br>
     * 00表示系统,所以系统级别的错误代码以0000开头<br>
     * 其他一级类别或者二级类别添加后请继续在下面添加说明<br>
     * ===========================================<br>
     * 00表示系统类别<br>
     * 10表示通用类别<br>
     */
    // 00表示系统级别错误
    SYS_ERROR("0000001", "系统内部错误"),
    EXCEPTION("0000002", "系统异常"),

    // 10表示通用类别
    SUCCESS("1000001", "成功"),
    FAILURE("1000002", "失败"),
    NOT_LOGINED("1000003", "用户未登录"),
    ERROR_TOKEN("1000004", "无效的token"),
    NO_PERMISSION("1000005", "无权限，请尽快申请"),
    SEND_MAIL_FAIL("1000006", "发送邮件失败"),
    ERROR_404("1000007", "访问页面不存在"),
    ERROR_500("1000008", "访问错误"),
    DELETED("1000009", "数据已被删除"),
    ERROR_BASIC("1000010", "访问出错"),
    NO_DATA("1000011", "无数据"),

    // 1001表示通用类别中的参数子类错误
    PARAM_ERROR("1001003", "参数错误"),
    PARAM_BLANK("1001004", "参数为空"),
    // 1002表示通用列表中的登录相关的错误
    LOGIN_FAILED("1002001", "登录失败"),
    LOGIN_FAILED_INVALID_SESSION("1002002", "登录失败:无效的会话"),
    LOGIN_FAILED_USER_OR_PASS_ERROR("1002003", "登录失败:用户名或密码错误"),
    LOGIN_FAILED_USER_OR_PASS_BLANK("1002004", "登录失败:用户名或密码为空"),
    LOGIN_FAILED_USER_NOT_EXIST("1002005", "登录失败:用户不存在"),
    LOGIN_FAILED_VALIDATE_FAIL("1002006", "登录验证失败"),
    // 1003表示通用列表中的登录相关的错误
    LOGOUT_FAILED("1003001", "退出失败"),
    LOGOUT_FAILED_INVALID_SESSION("1003002", "退出失败:无效的会话"),
    
    PROXY_ERROR("1004001", "代理失败"),
    ;

    private String code;

    private String message;

    BizResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString(){
        return code + " : " + message;
    }
    
}
