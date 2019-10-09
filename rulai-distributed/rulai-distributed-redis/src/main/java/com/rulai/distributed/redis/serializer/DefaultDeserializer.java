package com.rulai.distributed.redis.serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 15:11
 */
public class DefaultDeserializer implements Deserializer<Object> {
    
    private final ClassLoader classLoader;

    public DefaultDeserializer() {
        this.classLoader = null;
    }

    public DefaultDeserializer(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public Object deserialize(InputStream inputStream) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            return objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Failed to deserialize object type", e);
        }
    }
    
}
