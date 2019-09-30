package com.rulai.ldap;

import com.rulai.ldap.jldap.JldapLdapDialect;
import com.rulai.ldap.jndi.JndiLdapDialect;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/29 17:37
 */
public abstract class AbstractLdapDialect {
    
    protected LdapProperties properties;

    protected AbstractLdapDialect(LdapProperties properties) {
        this.properties = properties;
    }

    /**
     * 连接
     * @throws LdapException
     */
    public abstract void connect() throws LdapException;

    /**
     * 关闭
     * @throws LdapException
     */
    public abstract void close() throws LdapException;

    /**
     * 增
     * @param dn
     * @param attributes
     * @throws LdapException
     */
    public abstract void add(String dn, Map<String, String> attributes) throws LdapException;

    /**
     * 删
     * @param dn
     * @throws LdapException
     */
    public abstract void delete(String dn) throws LdapException;

    /**
     * 改
     * @param dn
     * @param modifyObjs
     * @throws LdapException
     */
    public abstract void modify(String dn, List<ModifyObj> modifyObjs) throws LdapException;

    /**
     * 查
     * @param dn
     * @return
     * @throws LdapException
     */
    public abstract List<Map<String, Object>> search(String dn) throws LdapException;

    /**
     * 转换修改类型
     * @param modifyTypeEnum
     * @return
     */
    protected abstract int convertOps(ModifyTypeEnum modifyTypeEnum);
    
    public static AbstractLdapDialect custom(LdapTypeEnum ldapTypeEnum, LdapProperties properties) {
        AbstractLdapDialect ldap;
        switch (ldapTypeEnum) {
            case JLDAP:
                ldap = JldapLdapDialect.custom(properties);
                break;
            case JNDI:
            default:
                ldap = JndiLdapDialect.custom(properties);
                break;
        }
        return ldap;
    }
    
    @Data
    public static class ModifyObj {
        private String id;
        private Object value;
        private ModifyTypeEnum type;
    }
    
    public enum ModifyTypeEnum {
        ADD, REPLACE, REMOVE;
    }
    
    public enum LdapTypeEnum {
        JNDI, JLDAP;
    }
    
    @Builder
    @Data
    public static class LdapProperties {
        private String host;
        private int port;
        private String username;
        private String password;
        private int version;
    }
    
}
