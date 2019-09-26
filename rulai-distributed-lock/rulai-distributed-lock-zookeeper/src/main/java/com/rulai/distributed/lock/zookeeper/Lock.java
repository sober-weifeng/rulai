package com.rulai.distributed.lock.zookeeper;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/25 19:18
 */
public interface Lock {
    
    void lock();
    
    void unlock();
    
}
