package com.rulai.component.rulaimq.queue;

import com.rulai.component.rulaimq.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/10 15:42
 */
public class RulaiPushBlockQueue extends LinkedBlockingQueue<Message> {
    
    private static final long serialVersionUID = -6007119291777472273L;
    
    private AbstractRulaiBlockQueueHandler handler;
    
    private boolean status;
    
    private ExecutorService executorService;
    
    private RulaiPushBlockQueue(AbstractRulaiBlockQueueHandler handler) {
        super();
        this.handler = handler;
        this.status = false;
        this.executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }
    
    public void start() {
        if (!status) {
            status = true;
        }
        new Thread(() -> {
            while (status) {
                try {
                    Message message = take();
                    executorService.execute(() -> handler.doBussiness(message));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    public void stop() {
        status = false;
    }
    
}
