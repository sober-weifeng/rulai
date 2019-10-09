package com.rulai.distributed.redis;

import com.rulai.distributed.redis.serializer.RedisSerializer;
import com.rulai.distributed.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 16:29
 */
public class StringRedisClient extends RedisClient<String, String> {
    
    public StringRedisClient(JedisPool jedisPool) {
        super(jedisPool);
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        setKeySerializer(stringRedisSerializer);
        setValueSerializer(stringRedisSerializer);
        setHashKeySerializer(stringRedisSerializer);
        setHashValueSerializer(stringRedisSerializer);
    }
    
}
