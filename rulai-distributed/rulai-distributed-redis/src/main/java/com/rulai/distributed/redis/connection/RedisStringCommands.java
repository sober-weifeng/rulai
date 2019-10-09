package com.rulai.distributed.redis.connection;

import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 16:51
 */
public interface RedisStringCommands {
    
    public enum BitOperation {
        AND, OR, XOR, NOT;
    }

    byte[] get(byte[] key);

    byte[] getSet(byte[] key, byte[] value);

    List<byte[]> mGet(byte[]... keys);

    void set(byte[] key, byte[] value);
    
    
    
}
