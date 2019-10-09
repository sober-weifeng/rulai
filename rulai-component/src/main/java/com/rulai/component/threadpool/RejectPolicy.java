package com.rulai.component.threadpool;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/9 16:16
 */
public interface RejectPolicy {
    
    void reject(Runnable task, RulaiThreadPoolExecutor executor);
    
}
