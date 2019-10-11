package com.rulai.component.rulaimq;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/10 16:28
 */
public abstract class RulaiConsumer<T> extends Thread {

    private RulaiMessageQueue<T> messageQueue;

    public RulaiConsumer(RulaiMessageQueue<T> messageQueue) {
        super();
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            doBussiness(messageQueue.poll());
        }
    }
    
    public abstract void doBussiness(Message<T> message);
    
}
