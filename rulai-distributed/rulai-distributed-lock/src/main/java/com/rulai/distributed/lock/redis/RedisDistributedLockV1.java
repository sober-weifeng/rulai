package com.rulai.distributed.lock.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * <p>Used jedis 3.1.0</p>
 * @author z```s
 * @version 1.0
 * @see Jedis
 * @date 2019/9/25 18:02
 */
public class RedisDistributedLockV1 {
    
    private static final String LOCK_SUCCESS = "OK";
    private static final Long UNLOCK_SUCCESS = 1L;
    private static final long DEFAULT_MAX_LOCK_TIME = 300000L;
    public static final String DELETE_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    private Jedis jedis;
    
    private String key;
    
    private long lockTime;
    
    private RedisDistributedLockV1(Jedis jedis, String key, long lockTime) {
        this.jedis = jedis;
        this.key = key;
        this.lockTime = lockTime;
    }

    public static RedisDistributedLockV1 build(Jedis jedis, String key) {
        return build(jedis, key, DEFAULT_MAX_LOCK_TIME);
    }
    
    public static RedisDistributedLockV1 build(Jedis jedis, String key, long lockTime) {
        return new RedisDistributedLockV1(jedis, key, lockTime);
    }
    
    public boolean lock() {
        return lock(0, 0L);
    }
    
    public boolean lock(int retryTimes, long retryIntervalTimeMillis) {
        int times = retryTimes + 1;
        for (int i = 0; i < times; i++) {
            SetParams setParams = SetParams.setParams();
            setParams.nx().ex((int) (lockTime / 1000L));
            String result = jedis.set(key, String.valueOf(key.hashCode()), setParams);
            if (LOCK_SUCCESS.equals(result)) {
                return true;
            }
            if (retryIntervalTimeMillis > 0) {
                try {
                    Thread.sleep(retryIntervalTimeMillis);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
        }
        return false;
    }
    
    public boolean unlock() {
        Object result = jedis.eval(DELETE_SCRIPT, Collections.singletonList(key), Collections.singletonList(String.valueOf(key.hashCode())));
        return UNLOCK_SUCCESS.equals(result);
    }
    
}
