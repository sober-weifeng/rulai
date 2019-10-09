package com.rulai.distributed.redis.serializer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 17:04
 */
public class SerializationUtils {
    
    static final byte[] EMPTY_ARRAY = new byte[0];
    
    static boolean isEmpty(byte[] data) {
        return (null == data || data.length == 0);
    }
    
    static <T extends Collection<?>> T deserializeValues(Collection<byte[]> rawValues, Class<T> type, 
                                                         RedisSerializer<?> redisSerializer) {
        if (null == rawValues) {
            return null;
        }
        Collection<Object> values = List.class.isAssignableFrom(type) ? Lists.newArrayList() : Sets.newLinkedHashSet();
        for (byte[] rawValue : rawValues) {
            values.add(redisSerializer.deserialize(rawValue));
        }
        return (T) values;
    }
    
    
    public static <T> Set<T> deserialize(Set<byte[]> rawValues, RedisSerializer<T> redisSerializer) {
        return deserializeValues(rawValues, Set.class, redisSerializer);
    }

    public static <T> List<T> deserialize(List<byte[]> rawValues, RedisSerializer<T> redisSerializer) {
        return deserializeValues(rawValues, List.class, redisSerializer);
    }

    public static <T> Collection<T> deserialize(Collection<byte[]> rawValues, RedisSerializer<T> redisSerializer) {
        return deserializeValues(rawValues, List.class, redisSerializer);
    }
    
    public static <T> Map<T, T> deserialize(Map<byte[], byte[]> rawValues, RedisSerializer<T> redisSerializer) {
        if (null == rawValues) {
            return null;
        }
        Map<T, T> ret = Maps.newLinkedHashMap();
        for (Map.Entry<byte[], byte[]> entry : rawValues.entrySet()) {
            ret.put(redisSerializer.deserialize(entry.getKey()), redisSerializer.deserialize(entry.getValue()));
        }
        return ret;
    }
    
    public static <K, V> Map<K, V> deserialize(Map<byte[], byte[]> rawValues, RedisSerializer<K> hashKeySerializer, 
                                               RedisSerializer<V> hashValueSerializer) {
        if (null == rawValues) {
            return null;
        }
        Map<K, V> ret = Maps.newLinkedHashMap();
        for (Map.Entry<byte[], byte[]> entry : rawValues.entrySet()) {
            ret.put(hashKeySerializer.deserialize(entry.getKey()), hashValueSerializer.deserialize(entry.getValue()));
        }
        return ret;
    }
    
}
