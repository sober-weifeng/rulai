package com.rulai.mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:13
 */
public class Configuration {
    
    private JdbcProperties jdbcProperties;
    
    private Map<String, MapperStatement> mapperMap = new HashMap<>();
    
    public MapperStatement getMapperStatement(String id) {
        return mapperMap.get(id);
    }
    
    public void addMapperStatement(MapperStatement mapperStatement) {
        mapperMap.put(mapperStatement.getId(), mapperStatement);
    }

    public JdbcProperties getJdbcProperties() {
        return jdbcProperties;
    }

    public void setJdbcProperties(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }
}
