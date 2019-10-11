package com.rulai.component.rulaimq;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/10 16:34
 */
public abstract class RulaiProducer<T> extends Thread {
    
    private RulaiMessageQueue<T> messageQueue;

    public RulaiProducer(RulaiMessageQueue<T> messageQueue) {
        super();
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        messageQueue.push(generateMessage());
    }
    
    public abstract Message<T> generateMessage();
    
}
