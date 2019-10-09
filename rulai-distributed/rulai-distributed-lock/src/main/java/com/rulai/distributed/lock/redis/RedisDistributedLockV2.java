package com.rulai.distributed.lock.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 14:38
 */
public class RedisDistributedLockV2 implements Lock {

    /**
     * 上下文，保存当前锁的持有人id
     */
    private ThreadLocal<String> lockContext = new ThreadLocal<>();

    /**
     * 默认锁的超时时间
     */
    private long defaultTime = 100L;
    
    private Thread ownerThread;
    
    private Jedis jedis;

    private static final String DELETE_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    private static final String LOCK_SUCCESS = "OK";

    public RedisDistributedLockV2(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public void lock() {
        while (!tryLock()) {
            try {
                Thread.sleep(defaultTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return tryLock(defaultTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
        String id = UUID.randomUUID().toString();
        Thread t = Thread.currentThread();
        SetParams setParams = SetParams.setParams();
        setParams.nx().ex((int) unit.toMillis(time));
        if (LOCK_SUCCESS.equals(jedis.set("lock", id, setParams))) {
            lockContext.set(id);
            setOwnerThread(t);
            return true;
        } else if (ownerThread == t) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void unlock() {
        if (lockContext.get() == null) {
            return;
        }
        String script = DELETE_SCRIPT;
        jedis.eval(script, Collections.singletonList("lock"), Collections.singletonList(lockContext.get()));
        lockContext.remove();
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private void setOwnerThread(Thread ownerThread) {
        this.ownerThread = ownerThread;
    }
}
