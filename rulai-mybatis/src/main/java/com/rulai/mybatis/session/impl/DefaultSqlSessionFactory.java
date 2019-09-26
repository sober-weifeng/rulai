package com.rulai.mybatis.session.impl;

import com.rulai.mybatis.config.Configuration;
import com.rulai.mybatis.session.Executor;
import com.rulai.mybatis.session.SqlSession;
import com.rulai.mybatis.session.SqlSessionFactory;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:17
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Executor executor = new SimpleExecutor(configuration.getJdbcProperties());
        SqlSession sqlSession = new DefaultSqlSession(configuration, executor);
        return sqlSession; 
    }
}
