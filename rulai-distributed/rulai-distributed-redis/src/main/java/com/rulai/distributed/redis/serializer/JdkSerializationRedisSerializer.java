package com.rulai.distributed.redis.serializer;

import com.rulai.distributed.redis.serializer.converter.Converter;
import com.rulai.distributed.redis.serializer.exception.SerializationFailedException;
import com.rulai.distributed.redis.serializer.support.DeserializingConverter;
import com.rulai.distributed.redis.serializer.support.SerializingConverter;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 17:39
 */
public class JdkSerializationRedisSerializer implements RedisSerializer<Object> {
    
    private final Converter<Object, byte[]> serializer;
    private final Converter<byte[], Object> deserializer;

    public JdkSerializationRedisSerializer() {
        this(new SerializingConverter(), new DeserializingConverter());
    }

    public JdkSerializationRedisSerializer(ClassLoader classLoader) {
        this(new SerializingConverter(), new DeserializingConverter(classLoader));
    }

    public JdkSerializationRedisSerializer(Converter<Object, byte[]> serializer, Converter<byte[], Object> deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    @Override
    public byte[] serialize(Object object) {
        if (null == object) {
            return SerializationUtils.EMPTY_ARRAY;
        }
        try {
            return serializer.convert(object);
        } catch (Exception e) {
            throw new SerializationFailedException(e);
        }
    }
    
    @Override
    public Object deserialize(byte[] bytes) {
        if (SerializationUtils.isEmpty(bytes)) {
            return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            throw new SerializationFailedException(e);
        }
    }
}
