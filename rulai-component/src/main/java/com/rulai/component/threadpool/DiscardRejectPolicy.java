package com.rulai.component.threadpool;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/9 16:17
 */
public class DiscardRejectPolicy implements RejectPolicy {
    
    @Override
    public void reject(Runnable task, RulaiThreadPoolExecutor executor) {
        System.out.println("discard one task");
    }
    
}
