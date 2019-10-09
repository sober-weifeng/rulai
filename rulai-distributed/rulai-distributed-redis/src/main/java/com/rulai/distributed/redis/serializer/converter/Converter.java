package com.rulai.distributed.redis.serializer.converter;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 17:43
 */
public interface Converter<S, T> {
    
    T convert(S source);
    
}
