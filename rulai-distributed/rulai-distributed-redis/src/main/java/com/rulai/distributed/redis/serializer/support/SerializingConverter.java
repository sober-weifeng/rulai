package com.rulai.distributed.redis.serializer.support;

import com.rulai.distributed.redis.serializer.DefaultSerializer;
import com.rulai.distributed.redis.serializer.Serializer;
import com.rulai.distributed.redis.serializer.converter.Converter;
import com.rulai.distributed.redis.serializer.exception.SerializationFailedException;

import java.io.ByteArrayOutputStream;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 17:44
 */
public class SerializingConverter implements Converter<Object, byte[]> {
    
    private final Serializer<Object> serializer;

    public SerializingConverter() {
        serializer = new DefaultSerializer();
    }

    public SerializingConverter(Serializer<Object> serializer) {
        this.serializer = serializer;
    }

    @Override
    public byte[] convert(Object source) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            serializer.serializer(source, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new SerializationFailedException("Failed to serialize object using " + 
                serializer.getClass().getSimpleName(), e);
        }
    }
}
