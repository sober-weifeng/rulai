package com.rulai.bigdata.hbase;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 11:34
 */
public class HbaseException extends Exception {
    
    public HbaseException() {
        super();
    }

    public HbaseException(String message) {
        super(message);
    }

    public HbaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public HbaseException(Throwable cause) {
        super(cause);
    }

    protected HbaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
