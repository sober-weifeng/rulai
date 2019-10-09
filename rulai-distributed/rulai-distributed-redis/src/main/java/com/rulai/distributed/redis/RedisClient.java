package com.rulai.distributed.redis;

import com.rulai.distributed.redis.serializer.JdkSerializationRedisSerializer;
import com.rulai.distributed.redis.serializer.RedisSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 15:44
 */
public class RedisClient<K, V> {
    
    private Jedis jedis;
    
    private JedisPool jedisPool;
    
    private RedisSerializer<?> defaultSerializer;
    
    private RedisSerializer keySerializer;
    
    private RedisSerializer valueSerializer;
    
    private RedisSerializer hashKeySerializer;
    
    private RedisSerializer hashValueSerializer;

    public RedisClient(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        this.defaultSerializer = new JdkSerializationRedisSerializer();
        this.keySerializer = defaultSerializer;
        this.valueSerializer = defaultSerializer;
        this.hashKeySerializer = defaultSerializer;
        this.hashValueSerializer = defaultSerializer;
    }

    /**
     * 连接
     */
    public void connect() {
        if (null == jedis || !jedis.isConnected()) {
            jedis = jedisPool.getResource();
        }
    }

    /**
     * 关闭
     */
    public void close() {
        if (null != jedis) {
            jedis.close();
            jedis = null;
        }
    }

    /**
     * 简单的get
     * @param key
     * @return
     */
    public V get(K key) {
        return deserializeValue(jedis.get(serializeKey(key)));
    }

    /**
     * 简单的set
     * @param key
     * @param value
     */
    public void set(K key, V value) {
        jedis.set(serializeKey(key), serializeValue(value));
    }

    /**
     * 带过期时间的set
     * @param key
     * @param value
     * @param seconds 秒
     */
    public void setex(K key, V value, int seconds) {
        jedis.setex(serializeKey(key), seconds, serializeValue(value));
    }

    /**
     * hmget
     * @param key
     * @param fields
     * @return
     */
    public <HK, HV> List<HV> hmget(K key, HK ... fields) {
        List<byte[]> queryResult = jedis.hmget(serializeKey(key), serializeHashKeys(fields));
        return queryResult.parallelStream().map(b -> (HV) hashValueSerializer.deserialize(b)).collect(Collectors.toList());
    }

    /**
     * hset
     * @param key
     * @param field
     * @param value
     */
    public <HK, HV> void hset(K key, HK field, HV value) {
        jedis.hset(serializeKey(key), hashKeySerializer.serialize(field), hashValueSerializer.serialize(value));
    }

    /**
     * 删除map中的值
     * @param key
     * @param fields
     * @return
     */
    public <HK> Long hdel(K key, HK... fields) {
        return jedis.hdel(serializeKey(key), serializeHashKeys(fields));
    }

    /**
     * 往redis里取set整个集合
     * @param key
     * @return
     */
    public Set<V> smembers(K key) {
        Set<byte[]> queryResult = jedis.smembers(serializeKey(key));
        return queryResult.parallelStream().map(b -> deserializeValue(b)).collect(Collectors.toSet());
    }

    /**
     * 获取Set长度
     * @param key
     * @return
     */
    public Long scard(K key) {
        return jedis.scard(serializeKey(key));
    }
    
    /**
     * 删除keys
     * @param keys
     * @return
     */
    public Long del(K... keys) {
        return jedis.del(serializeKeys(keys));
    }

    /**
     * 删除Set
     * @param key
     * @param members
     * @return
     */
    public Long srem(K key, V... members) {
        return jedis.srem(serializeKey(key), serializeValues(members));
    }

    /**
     *  随机 Set 中的一个值
     * @param key
     * @return
     */
    public V srandmember(K key) {
        return deserializeValue(jedis.srandmember(serializeKey(key)));
    }

    /**
     * 随机 Set 中的count个值
     * @param key
     * @param count
     * @return
     */
    public List<V> srandmember(K key, int count) {
        List<byte[]> queryResult = jedis.srandmember(serializeKey(key), count);
        return queryResult.parallelStream().map(this::deserializeValue).collect(Collectors.toList());
    }

    /**
     * 往redis里存Set
     * @param key
     * @param members
     * @return
     */
    public Long sadd(K key, V ... members) {
        return jedis.sadd(serializeKey(key), serializeValues(members));
    }

    /**
     * 往redis里存List
     * @param key
     * @param values
     */
    public void rpush(K key, V... values) {
        jedis.rpush(serializeKey(key), serializeValues(values));
    }

    /**
     * 往redis里取list
     * @param key
     * @param start
     * @param stop
     * @return
     */
    public List<V> lrange(K key, long start, long stop) {
        List<byte[]> queryResult = jedis.lrange(serializeKey(key), start, stop);
        return queryResult.parallelStream().map(this::deserializeValue).collect(Collectors.toList());
    }

    /**
     * 获取list的长度
     * @param key
     * @return
     */
    public Long llen(K key) {
        return jedis.llen(serializeKey(key));
    }

    /**
     * 判断是否存在
     * @param key
     * @return
     */
    public Boolean exists(K key) {
        return jedis.exists(serializeKey(key));
    }
    
    /**
     * 判断是否存在
     * @param keys
     * @return
     */
    public Long exists(K... keys) {
        return jedis.exists(serializeKeys(keys));
    }

    public RedisSerializer<?> getDefaultSerializer() {
        return defaultSerializer;
    }

    public void setDefaultSerializer(RedisSerializer<?> defaultSerializer) {
        this.defaultSerializer = defaultSerializer;
    }

    public RedisSerializer<?> getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(RedisSerializer<?> keySerializer) {
        this.keySerializer = keySerializer;
    }

    public RedisSerializer<?> getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(RedisSerializer<?> valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public RedisSerializer<?> getHashKeySerializer() {
        return hashKeySerializer;
    }

    public void setHashKeySerializer(RedisSerializer<?> hashKeySerializer) {
        this.hashKeySerializer = hashKeySerializer;
    }

    public RedisSerializer<?> getHashValueSerializer() {
        return hashValueSerializer;
    }

    public void setHashValueSerializer(RedisSerializer<?> hashValueSerializer) {
        this.hashValueSerializer = hashValueSerializer;
    }
    
    private byte[] serializeKey(Object key) {
        if (null == keySerializer && key instanceof byte[]) {
            return (byte[]) key;
        }
        return keySerializer.serialize(key);
    }
    
    private K deserializeKey(byte[] value) {
        return keySerializer != null ? (K) keySerializer.deserialize(value) : (K) value;
    }
    
    private byte[] serializeValue(Object value) {
        if (null == valueSerializer && value instanceof byte[]) {
            return (byte[]) value;
        }
        return valueSerializer.serialize(value);
    }

    private V deserializeValue(byte[] value) {
        return valueSerializer != null ? (V) valueSerializer.deserialize(value) : (V) value;
    }
    
    private byte[][] serializeKeys(Object ... keys) {
        return Arrays.stream(keys).map(this::serializeValue).toArray(byte[][]::new);
    }

    private byte[][] serializeKeys(Collection<K> keys) {
        return keys.parallelStream().map(this::serializeValue).toArray(byte[][]::new);
    }
    
    private byte[][] serializeHashKeys(Object ... fields) {
        return Arrays.stream(fields).map(f -> hashKeySerializer.serialize(f)).toArray(byte[][]::new);
    }

    private byte[][] serializeValues(Object ... values) {
        return Arrays.stream(values).map(this::serializeValue).toArray(byte[][]::new);
    }
}
