package com.rulai.component.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/9 16:14
 */
public class RulaiThreadPoolExecutor implements Executor {

    /**
     * 线程池的名称
     */
    private String name;

    /**
     * 线程序列号
     */
    private AtomicInteger sequence = new AtomicInteger(0);

    /**
     * 核心线程数
     */
    private int coreSize;

    /**
     * 最大线程数
     */
    private int maxSize;

    /**
     * 任务队列
     */
    private BlockingQueue<Runnable> taskQueue;

    /**
     * 拒绝策略
     */
    private RejectPolicy rejectPolicy;

    /**
     * 当前正在运行的线程数
     * 需要修改时线程间立即感知，所以使用AtomicInteger
     * 或者也可以使用volatile并结合Unsafe做CAS操作（参考Unsafe篇章讲解）
     */
    private AtomicInteger runningCount = new AtomicInteger(0);

    public RulaiThreadPoolExecutor(String name, int coreSize, int maxSize, BlockingQueue<Runnable> taskQueue, RejectPolicy rejectPolicy) {
        this.name = name;
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.taskQueue = taskQueue;
        this.rejectPolicy = rejectPolicy;
    }

    @Override
    public void execute(Runnable command) {
        int count = runningCount.get();
        if (count < coreSize) {
            if (addWorker(command, true)) {
                return;
            }
        }
        if (taskQueue.offer(command)) {
            
        } else {
            if (!addWorker(command, false)) {
                rejectPolicy.reject(command, this);
            }
        }
    }

    private boolean addWorker(Runnable newTask, boolean core) {
        for (; ; ) {
            int count = runningCount.get();
            int max = core ? coreSize : maxSize;
            if (count >= max) {
                return false;
            }
            if (runningCount.compareAndSet(count, count + 1)) {
                String threadName = (core ? "core_" : "") + name + sequence.incrementAndGet();
                new Thread(() -> {
                    System.out.println("thread name: " + Thread.currentThread().getName());
                    Runnable task = newTask;
                    while (task != null || (task = getTask()) != null) {
                        try {
                            task.run();
                        } finally {
                            task = null;
                        }
                    }
                }, threadName).start();
                break;
            }
        }
        return true;
    }

    private Runnable getTask() {
        try {
            return taskQueue.take();
        } catch (InterruptedException e) {
            runningCount.decrementAndGet();
            return null;
        }
    }

}
