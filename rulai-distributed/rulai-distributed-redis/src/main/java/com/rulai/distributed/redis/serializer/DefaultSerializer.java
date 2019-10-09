package com.rulai.distributed.redis.serializer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 17:46
 */
public class DefaultSerializer implements Serializer<Object> {
    
    @Override
    public void serializer(Object object, OutputStream outputStream) throws IOException {
        if (!(object instanceof Serializable)) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " requires a serializable payload" +
                    "but received an object of type [" + object.getClass().getName() + "]");
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
    }
    
}
