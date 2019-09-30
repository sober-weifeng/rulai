package com.rulai.bigdata.hbase;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 11:34
 */
public class HBaseException extends Exception {
    
    public HBaseException() {
        super();
    }

    public HBaseException(String message) {
        super(message);
    }

    public HBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public HBaseException(Throwable cause) {
        super(cause);
    }

    protected HBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
