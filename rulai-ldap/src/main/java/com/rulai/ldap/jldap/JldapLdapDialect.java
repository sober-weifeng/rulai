package com.rulai.ldap.jldap;

import com.novell.ldap.*;
import com.novell.ldap.util.Base64;
import com.rulai.ldap.AbstractLdapDialect;
import com.rulai.ldap.LdapException;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/29 17:47
 */
public class JldapLdapDialect extends AbstractLdapDialect {

    private LDAPConnection connection;

    protected JldapLdapDialect(LdapProperties properties) {
        super(properties);
    }

    @Override
    public void connect() throws LdapException {
        try {
            connection.connect(properties.getHost(), properties.getPort());
            connection.bind(properties.getVersion(), properties.getUsername(), properties.getPassword().getBytes("UTF8"));
        } catch (LDAPException | UnsupportedEncodingException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void close() throws LdapException {
        try {
            connection.disconnect();
        } catch (LDAPException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void add(String dn, Map<String, String> attributes) throws LdapException {
        LDAPAttributeSet attributeSet = new LDAPAttributeSet();
        if (null != attributes && attributes.size() > 0) {
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                attributeSet.add(new LDAPAttribute(entry.getKey(), entry.getValue()));
            }
        }
        LDAPEntry entry = new LDAPEntry(dn, attributeSet);
        try {
            connection.add(entry);
        } catch (LDAPException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void delete(String dn) throws LdapException {
        try {
            connection.delete(dn);
        } catch (LDAPException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void modify(String dn, List<ModifyObj> modifyObjs) throws LdapException {
        if (null == modifyObjs || modifyObjs.size() == 0) {
            return;
        }
        LDAPModification[] ldapModifications = modifyObjs.stream().map(e -> {
            LDAPAttribute ldapAttribute = new LDAPAttribute(e.getId(), e.getValue().toString());
            return new LDAPModification(convertOps(e.getType()), ldapAttribute);
        }).toArray(LDAPModification[]::new);
        try {
            connection.modify(dn, ldapModifications);
        } catch (LDAPException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public List<Map<String, Object>> search(String dn) throws LdapException {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            LDAPSearchResults searchResults = connection.search(dn, LDAPConnection.SCOPE_BASE, null, null, false);
            Map<String, Object> resultMap;
            while (searchResults.hasMore()) {
                LDAPEntry entry = searchResults.next();
                LDAPAttributeSet attributeSet = entry.getAttributeSet();
                Iterator<LDAPAttribute> allAttributes = attributeSet.iterator();
                resultMap = new HashMap<>();
                while (allAttributes.hasNext()) {
                    LDAPAttribute attribute = allAttributes.next();
                    String attributeName = attribute.getName();
                    Enumeration<String> allValues = attribute.getStringValues();
                    if (null == allValues) {
                        continue;
                    }
                    List<String> values = new ArrayList<>();
                    while (allValues.hasMoreElements()) {
                        String value = allValues.nextElement();
                        if (!Base64.isLDIFSafe(value)) {
                            value = Base64.encode(value.getBytes());
                        }
                        values.add(value);
                    }
                    resultMap.put(attributeName, values.toArray());
                }
                result.add(resultMap);
            }
        } catch (LDAPException e) {
            throw new LdapException(e);
        }
        return result;
    }
    
    @Override
    protected int convertOps(ModifyTypeEnum modifyTypeEnum) {
        int ops;
        switch (modifyTypeEnum) {
            case REMOVE:
                ops = LDAPModification.DELETE;
                break;
            case REPLACE:
                ops = LDAPModification.REPLACE;
                break;
            case ADD:
            default:
                ops = LDAPModification.ADD;
                break;
        }
        return ops;
    }
    
    public boolean verifyPassword(String dn, String userPassword) throws LdapException {
        try {
            LDAPAttribute attribute = new LDAPAttribute("userPassword", userPassword);
            return connection.compare(dn, attribute);
        } catch (LDAPException e) {
            throw new LdapException(e);
        }
    }

    public static JldapLdapDialect custom(LdapProperties properties) {
        return new JldapLdapDialect(properties);
    }
    
}
