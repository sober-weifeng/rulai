package com.rulai.mybatis.session;

import com.rulai.mybatis.config.MapperStatement;

import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:27
 */
public interface Executor {

    <E> List<E> query(MapperStatement mapperStatement, Object parameter);
    
}
