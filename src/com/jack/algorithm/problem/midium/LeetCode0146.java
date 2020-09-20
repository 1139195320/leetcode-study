package com.jack.algorithm.problem.midium;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0146 {

    public static void main(String[] args) {
        testLRUCache2();
    }

    private static void testLRUCache2() {
        /* 缓存容量 */
        LRUCache2 cache = new LRUCache2( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        // 返回 1
        System.out.println(cache.get(1));
        // 该操作会使得密钥 2 作废
        cache.put(3, 3);
        // 返回 -1 (未找到)
        System.out.println(cache.get(2));
        // 该操作会使得密钥 1 作废
        cache.put(4, 4);
        // 返回 -1 (未找到)
        System.out.println(cache.get(1));
        // 返回 3
        System.out.println(cache.get(3));
        // 返回 4
        System.out.println(cache.get(4));
    }
}

class LRUCache2 {

    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return val;
    }
    public void put(int key, int value) {
        cache.remove(key);
        if (capacity == cache.size()) {
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);
    }
}

class LRUCache3 {

    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache3(int capacity) {
        // 借助 LinkedHashMap 已经实现的 删除最近最少使用的元素 方法
        this.cache = new LinkedHashMap<Integer, Integer>(
                capacity, 0.75f, true) {
            private static final long serialVersionUID = 7092792612517215069L;
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
