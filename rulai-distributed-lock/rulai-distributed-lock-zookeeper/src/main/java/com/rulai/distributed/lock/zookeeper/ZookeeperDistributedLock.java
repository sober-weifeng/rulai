package com.rulai.distributed.lock.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/25 19:23
 */
public class ZookeeperDistributedLock extends ZookeeperAbstractLock {

    private CountDownLatch countDownLatch = null;
    
    public ZookeeperDistributedLock(ZkClient zkClient) {
        super(zkClient);
    }

    @Override
    public void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                if (null != countDownLatch) {
                    countDownLatch.countDown();
                }
            }
        };
        zkClient.subscribeDataChanges(lockPath, iZkDataListener);
        if (zkClient.exists(lockPath)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(lockPath, iZkDataListener);
    }

    @Override
    public boolean tryLock() {
        try {
            zkClient.createEphemeral(lockPath);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
