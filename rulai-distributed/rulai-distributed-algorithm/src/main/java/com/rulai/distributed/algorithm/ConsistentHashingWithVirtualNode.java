package com.rulai.distributed.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <p>带虚拟节点的一致性Hash算法</p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/9 14:35
 */
public class ConsistentHashingWithVirtualNode {

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    /**
     * 真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
     */
    private static List<String> realNodes = new LinkedList<>();

    /**
     * 虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
     */
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    /**
     * 虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应5个虚拟节点
     */
    private static final int VIRTUAL_NODES = 5;
    
    static {
        for (String server : servers) {
            realNodes.add(server);
        }
        for (String realNode : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = realNode + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
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

    /**
     * 得到应当路由到的结点
     * @param key
     * @return
     */
    public static String getServer(String key) {
        int hash = getHash(key);
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        String virtualNode;
        if (subMap.isEmpty()) {
            Integer i = virtualNodes.firstKey();
            virtualNode = virtualNodes.get(i);
        } else {
            Integer i = subMap.firstKey();
            virtualNode = subMap.get(i);
        }
        if (null != virtualNode && !virtualNode.isEmpty()) {
            return virtualNode.substring(0, virtualNode.indexOf("&&"));
        }
        return null;
    }

    /**
     * 添加节点
     * @param node
     */
    public static void addNode(String node) {
        if (!realNodes.contains(node)) {
            realNodes.add(node);
            System.out.println("真实节点[" + node + "] 上线添加");
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNode = node + "&&VN" + i;
                int hash = getHash(virtualNode);
                virtualNodes.put(hash, virtualNode);
                System.out.println("虚拟节点[" + virtualNode + "] hash:" + hash + "，被添加");
            }
        }
    }

    /**
     * 删除节点
     * @param node
     */
    public static void deleteNode(String node) {
        if (realNodes.contains(node)) {
            realNodes.remove(node);
            System.out.println("真实节点[" + node + "] 下线移除");
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNode = node + "&&VN" + i;
                int hash = getHash(virtualNode);
                virtualNodes.remove(hash);
                System.out.println("虚拟节点[" + virtualNode + "] hash:" + hash + "，被移除");
            }
        }
    }

}
