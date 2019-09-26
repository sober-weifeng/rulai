package com.rulai.distributed.lock.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/25 16:31
 */
@SuppressWarnings("SqlResolve")
public class MysqlDistributedLock {
    
    private Connection connection;

    public MysqlDistributedLock(Connection connection) {
        this.connection = connection;
    }
    
    public boolean lock(String methodName, long timeOuts) throws SQLException, InterruptedException {
        String sql = "SELECT id FROM method_lock WHERE method_name = ? FOR UPDATE";
        long futureTime = System.currentTimeMillis() + timeOuts;
        long ranMain;
        long timeRange = 500;
        connection.setAutoCommit(Boolean.FALSE.booleanValue());
        while (true) {
            CountDownLatch latch = new CountDownLatch(1);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, methodName);
                statement.setInt(2, 1);
                statement.setLong(1, System.currentTimeMillis());
                boolean ifSuccess = statement.execute();
                if (ifSuccess) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            latch.await(timeRange, TimeUnit.MILLISECONDS);
            ranMain = futureTime - System.currentTimeMillis();
            if (ranMain <= 0) {
                break;
            }
            if (ranMain < timeRange) {
                timeRange = ranMain;
            }
            continue;
        }
        return false;
    }
    
    public void unlock(String lockId) throws SQLException {
        connection.commit();
    }
    
}
