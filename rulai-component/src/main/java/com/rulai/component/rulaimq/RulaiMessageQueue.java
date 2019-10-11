package com.rulai.component.rulaimq;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/10 16:21
 */
@Slf4j
public class RulaiMessageQueue<T> {
    
    public static final int QUEUE_MAX_SIZE = 100;
    
    private LinkedBlockingQueue<Message<T>> blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    /**
     * 消息入列
     * @param message
     * @return
     */
    public boolean push(Message<T> message) {
        return blockingQueue.offer(message);
    }
    
    public Message<T> poll() {
        Message<T> message = null;
        try {
            message = blockingQueue.take();
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return message;
    }
    
    public int size() {
        return blockingQueue.size();
    }
    
}
