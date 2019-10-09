package com.rulai.distributed.redis.serializer.support;

import com.rulai.distributed.redis.serializer.DefaultDeserializer;
import com.rulai.distributed.redis.serializer.Deserializer;
import com.rulai.distributed.redis.serializer.converter.Converter;
import com.rulai.distributed.redis.serializer.exception.SerializationFailedException;

import java.io.ByteArrayInputStream;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 15:08
 */
public class DeserializingConverter implements Converter<byte[], Object> {
    
    private final Deserializer<Object> deserializer;

    public DeserializingConverter() {
        this.deserializer = new DefaultDeserializer();
    }

    public DeserializingConverter(ClassLoader classLoader) {
        this.deserializer = new DefaultDeserializer(classLoader);
    }

    public DeserializingConverter(Deserializer<Object> deserializer) {
        this.deserializer = deserializer;
    }

    @Override
    public Object convert(byte[] source) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source);
        try {
            return deserializer.deserialize(byteArrayInputStream);
        } catch (Throwable e) {
            throw new SerializationFailedException(e);
        }
    }
    
}
