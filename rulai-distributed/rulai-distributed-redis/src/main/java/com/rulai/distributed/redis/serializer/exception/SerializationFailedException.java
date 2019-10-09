package com.rulai.distributed.redis.serializer.exception;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 15:05
 */
public class SerializationFailedException extends RuntimeException {
    
    public SerializationFailedException() {
        super();
    }

    public SerializationFailedException(String message) {
        super(message);
    }

    public SerializationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationFailedException(Throwable cause) {
        super(cause);
    }

    protected SerializationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
