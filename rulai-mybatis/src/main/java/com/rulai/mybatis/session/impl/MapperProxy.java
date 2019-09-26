package com.rulai.mybatis.session.impl;

import com.rulai.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:43
 */
public class MapperProxy implements InvocationHandler {
    
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statement = method.getDeclaringClass().getName() + "." + method.getName();
        if (Collection.class.isAssignableFrom(method.getReturnType())) {
            return sqlSession.selectList(statement, null != args ? args[0] : null);
        } else {
            return sqlSession.selectOne(statement, null != args ? args[0] : null);
        }
    }
}
