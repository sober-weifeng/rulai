package com.rulai.mybatis.config;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:12
 */
public class MapperStatement {
    
    private String id;
    
    private String sql;
    
    private String resultType;
    
    private String queryType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
