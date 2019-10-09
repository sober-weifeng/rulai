package com.rulai.distributed.redis.serializer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 17:45
 */
public interface Serializer<T> {
    
    void serializer(T object, OutputStream outputStream) throws IOException;
    
}
