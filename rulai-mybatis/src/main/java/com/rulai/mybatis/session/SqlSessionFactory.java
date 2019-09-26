package com.rulai.mybatis.session;

import com.rulai.mybatis.config.Configuration;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:10
 */
public interface SqlSessionFactory {
    
    Configuration getConfiguration();
    
    SqlSession openSession();
    
}
