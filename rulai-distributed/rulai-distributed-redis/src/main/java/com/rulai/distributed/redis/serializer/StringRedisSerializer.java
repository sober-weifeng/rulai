package com.rulai.distributed.redis.serializer;

import java.nio.charset.Charset;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 15:28
 */
public class StringRedisSerializer implements RedisSerializer<String> {
    
    private final Charset charset;

    public StringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public StringRedisSerializer(Charset charset) {
        this.charset = charset;
    }

    @Override
    public byte[] serialize(String string) {
        return (null == string ? null : string.getBytes(charset));
    }

    @Override
    public String deserialize(byte[] bytes) {
        return (null == bytes ? null : new String(bytes, charset));
    }
    
}
