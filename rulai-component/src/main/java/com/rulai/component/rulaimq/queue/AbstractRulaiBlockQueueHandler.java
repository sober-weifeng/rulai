package com.rulai.component.rulaimq.queue;

import com.rulai.component.rulaimq.Message;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/10 15:45
 */
public abstract class AbstractRulaiBlockQueueHandler implements Runnable {
    
    /**
     * 业务相关
     */
    public abstract void doBussiness(Message message);
    
}
