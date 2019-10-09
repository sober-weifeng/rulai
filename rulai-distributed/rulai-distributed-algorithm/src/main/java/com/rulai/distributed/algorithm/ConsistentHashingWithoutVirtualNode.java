package com.rulai.distributed.algorithm;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <p>不带虚拟节点的一致性Hash算法</p>
 * <p>重点：1.如何造一个hash环，2.如何在哈希环上映射服务器节点，3.如何找到对应的节点</p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/9 14:25
 */
public class ConsistentHashingWithoutVirtualNode {

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = { "192.168.0.0:111", "192.168.0.1:111",
            "192.168.0.2:111", "192.168.0.3:111", "192.168.0.4:111" };
    
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();
    
    static {
        for (int i = 0, len = servers.length; i < len; i++) {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
            sortedMap.put(hash, servers[i]);
        }
    }

    /**
     * 得到应当路由到的结点
     * @param key
     * @return
     */
    private static String getServer(String key) {
        int hash = getHash(key);
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if (subMap.isEmpty()) {
            Integer i = sortedMap.firstKey();
            return sortedMap.get(i);
        } else {
            Integer i = subMap.firstKey();
            return subMap.get(i);
        }
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     * @param value
     * @return
     */
    private static int getHash(String value) {
        int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0, len = value.length(); i < len; i++) {
            hash = (hash ^ value.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

}
