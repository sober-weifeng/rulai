package com.rulai.mybatis.config;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:11
 */
public class JdbcProperties {
    
    private String url;
    
    private String driver;
    
    private String username;
    
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
