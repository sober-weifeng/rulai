package com.rulai.distributed.redis.connection;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 16:33
 */
public interface RedisKeyCommands {
    
    Boolean exists(byte[] key);
    
    Long del(byte[]... keys);
    
    DataType type(byte[] key);

    Set<byte[]> keys(byte[] pattern);
    
    byte[] randomKey();

    void rename(byte[] oldName, byte[] newName);

    Boolean renameNX(byte[] oldName, byte[] newName);

    Boolean expire(byte[] key, long seconds);

    Boolean pExpire(byte[] key, long millis);

    Boolean expireAt(byte[] key, long unixTime);

    Boolean pExpireAt(byte[] key, long unixTimeInMillis);
    
    Boolean persist(byte[] key);

    Boolean move(byte[] key, int dbIndex);

    Long ttl(byte[] key);

    Long ttl(byte[] key, TimeUnit timeUnit);

    Long pttl(byte[] key);

    Long pttl(byte[] key, TimeUnit timeUnit);

    byte[] dump(byte[] key);

    void restore(byte[] key, long ttlInMillis, byte[] serializedValue);
    
}
