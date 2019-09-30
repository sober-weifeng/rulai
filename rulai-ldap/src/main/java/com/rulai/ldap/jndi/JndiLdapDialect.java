package com.rulai.ldap.jndi;

import com.rulai.ldap.AbstractLdapDialect;
import com.rulai.ldap.LdapException;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.*;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/29 17:09
 */
public class JndiLdapDialect extends AbstractLdapDialect {

    private LdapContext context;

    protected JndiLdapDialect(LdapProperties properties) {
        super(properties);
    }

    @Override
    public void connect() throws LdapException {
        try {
            if (null == context) {
                Hashtable<String, Object> env = new Hashtable<>();
                String url = "ldap://" + properties.getHost() + ":" + properties.getPort();
                env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
                env.put(Context.PROVIDER_URL, url);
                env.put(Context.SECURITY_AUTHENTICATION, "simple");
                env.put(Context.SECURITY_PRINCIPAL, properties.getAccountDN());
                env.put(Context.SECURITY_CREDENTIALS, properties.getPassword());
                context = new InitialLdapContext(env, null);
            }
        } catch (NamingException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void close() throws LdapException {
        try {
            context.close();
            context = null;
        } catch (NamingException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void add(String dn, Map<String, String> attributes) throws LdapException {
        try {
            Attributes attributeList = new BasicAttributes();
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                attributeList.put(entry.getKey(), entry.getValue());
            }
            context.createSubcontext(dn, attributeList);
        } catch (NamingException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void delete(String dn) throws LdapException {
        try {
            context.destroySubcontext(dn);
        } catch (NamingException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public void modify(String dn, List<ModifyObj> modifyObjs) throws LdapException {
        ModificationItem[] modificationItems = modifyObjs.stream().map(e -> {
            Attribute attribute = new BasicAttribute(e.getId(), e.getValue());
            ModificationItem modificationItem = new ModificationItem(convertOps(e.getType()), attribute);
            return modificationItem;
        }).toArray(ModificationItem[]::new);
        try {
            context.modifyAttributes(dn, modificationItems);
        } catch (NamingException e) {
            throw new LdapException(e);
        }
    }

    @Override
    public List<Map<String, Object>> search(String dn) throws LdapException {
        try {
            List<Map<String, Object>> result = new ArrayList<>();
            NamingEnumeration<SearchResult> namingEnumeration = context.search(dn, null);
            Map<String, Object> resultMap;
            while (namingEnumeration.hasMoreElements()) {
                SearchResult match = namingEnumeration.nextElement();
                System.out.println(match.getName());
                Attributes attributes = match.getAttributes();
                NamingEnumeration<? extends Attribute> allAttributes = attributes.getAll();
                resultMap = new HashMap<>();
                while (allAttributes.hasMoreElements()) {
                    Attribute attribute = allAttributes.nextElement();
                    System.out.println(attribute.getID());
                    int size = attribute.size();
                    if (size > 1) {
                        Object[] objects = new Object[size];
                        for (int i = 0; i < size; i++) {
                            objects[i] = attribute.get(i);
                        }
                        resultMap.put(attribute.getID(), objects);
                    } else {
                        resultMap.put(attribute.getID(), attribute.get(0));
                    }
                }
                result.add(resultMap);
            }
            return result;
        } catch (NamingException e) {
            throw new LdapException(e);
        }
    }

    @Override
    protected int convertOps(ModifyTypeEnum modifyTypeEnum) {
        int ops;
        switch (modifyTypeEnum) {
            case REMOVE:
                ops = DirContext.REMOVE_ATTRIBUTE;
                break;
            case REPLACE:
                ops = DirContext.REPLACE_ATTRIBUTE;
                break;
            case ADD:
            default:
                ops = DirContext.ADD_ATTRIBUTE;
                break;
        }
        return ops;
    }

    public static JndiLdapDialect custom(LdapProperties properties) {
        return new JndiLdapDialect(properties);
    }
}
