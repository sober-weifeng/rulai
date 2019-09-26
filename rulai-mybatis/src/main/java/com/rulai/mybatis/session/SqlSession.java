package com.rulai.mybatis.session;

import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:10
 */
public interface SqlSession {

    <T> T selectOne(String statement, Object parameter);

    <E> List<E> selectList(String statement);

    <E> List<E> selectList(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
    
}
