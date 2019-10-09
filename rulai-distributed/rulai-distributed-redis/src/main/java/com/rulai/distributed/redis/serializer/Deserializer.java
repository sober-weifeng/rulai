package com.rulai.distributed.redis.serializer;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 15:10
 */
public interface Deserializer<T> {
    
    T deserialize(InputStream inputStream) throws IOException;
    
}
