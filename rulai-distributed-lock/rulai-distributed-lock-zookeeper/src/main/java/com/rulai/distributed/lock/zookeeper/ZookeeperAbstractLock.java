package com.rulai.distributed.lock.zookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/25 19:20
 */
public abstract class ZookeeperAbstractLock implements Lock {
    
    protected ZkClient zkClient;

    protected String lockPath="/lockPath";

    public ZookeeperAbstractLock(ZkClient zkClient) {
        this.zkClient = zkClient;
    }

    @Override
    public void lock() {
        if (tryLock()) {
            System.out.println("#####成功获取锁#####");
        } else {
            waitLock();
        }
    }

    @Override
    public void unlock() {
        if (null != zkClient) {
            zkClient.close();
            System.out.println("#####释放锁完毕#####");
        }
    }
    
    public abstract void waitLock();
    
    public abstract boolean tryLock();
    
}
