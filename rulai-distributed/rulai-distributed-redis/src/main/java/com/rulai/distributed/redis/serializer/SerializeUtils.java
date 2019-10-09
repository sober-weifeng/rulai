package com.rulai.distributed.redis.serializer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 15:35
 */
@Slf4j
public class SerializeUtils {
    
    private SerializeUtils() {
    }

    public static byte[] serialize(Object value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (Exception e) {
            log.error("serialize error " + JSON.toJSONString(value), e);
        } finally {
            close(os);
            close(bos);
        }
        return rv;
    }

    public static Object deserialize(byte[] in) {
        return deserialize(in, Object.class);
    }

    public static <T> T deserialize(byte[] in, Class<T> requiredType) {
        T rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                rv = (T) is.readObject();
            }
        } catch (Exception e) {
            log.error("serialize error {}", in);
        } finally {
            close(is);
            close(bis);
        }
        return rv;
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                log.error("close stream error");
            }
        }
    }

}
