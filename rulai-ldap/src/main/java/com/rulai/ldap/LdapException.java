package com.rulai.ldap;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/29 17:53
 */
public class LdapException extends Exception {

    private static final long serialVersionUID = -1397859639591205312L;

    public LdapException() {
        super();
    }

    public LdapException(String message) {
        super(message);
    }

    public LdapException(String message, Throwable cause) {
        super(message, cause);
    }

    public LdapException(Throwable cause) {
        super(cause);
    }

    protected LdapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
