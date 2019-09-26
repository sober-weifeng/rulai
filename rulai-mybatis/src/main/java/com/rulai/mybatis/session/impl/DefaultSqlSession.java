package com.rulai.mybatis.session.impl;

import com.rulai.mybatis.config.Configuration;
import com.rulai.mybatis.session.Executor;
import com.rulai.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:32
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> list = executor.query(configuration.getMapperStatement(statement), null);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public <E> List<E> selectList(String statement) {
        return executor.query(configuration.getMapperStatement(statement), null);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return executor.query(configuration.getMapperStatement(statement), parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        T newProxyInstance = (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy(this));
        return newProxyInstance;
    }
}
