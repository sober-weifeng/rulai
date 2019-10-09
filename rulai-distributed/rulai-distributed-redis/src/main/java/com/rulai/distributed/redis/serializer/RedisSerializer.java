package com.rulai.distributed.redis.serializer;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 17:02
 */
public interface RedisSerializer<T> {
    
    byte[] serialize(T t);
    
    T deserialize(byte[] bytes);
    
}
