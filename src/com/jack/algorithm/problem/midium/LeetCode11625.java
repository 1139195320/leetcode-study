package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode11625 {

    public static void main(String[] args) {
        LRUCache4 cache = new LRUCache4(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 返回  1
        System.out.println(cache.get(1));
        // 该操作会使得密钥 2 作废
        cache.put(3, 3);
        // 返回 -1 (未找到)
        System.out.println(cache.get(2));
        // 该操作会使得密钥 1 作废
        cache.put(4, 4);
        // 返回 -1 (未找到)
        System.out.println(cache.get(1));
        // 返回  3
        System.out.println(cache.get(3));
        // 返回  4
        System.out.println(cache.get(4));
    }
}

class LRUCache {

    private Queue<Integer> keyQueue;
    private Map<Integer, Integer> map;
    private int capacity;
    public LRUCache(int capacity) {
        keyQueue = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 删除原来的位置
            keyQueue.remove(key);
            // 放到最新的位置
            keyQueue.add(key);
            return map.get(key);
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keyQueue.contains(key)) {
            // 删除原来的位置
            keyQueue.remove(key);
        }
        else {
            // 新插入数据
            if (capacity > 0) {
                // 还有容量
                capacity --;
            }
            else {
                // 容量已满
                // 删除最久远的数据
                int oldKey = keyQueue.remove();
                map.remove(oldKey);
            }
        }
        // 放到最新的位置
        keyQueue.add(key);
        // 插入数据（可能会更新）
        map.put(key, value);
    }
}

class LRUCache4 {

    private int[] arr;
    private int pos;
    private Map<Integer, Integer> map;
    private int capacity;
    public LRUCache4(int capacity) {
        arr = new int[capacity];
        pos = 0;
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            moveKey(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    private void moveKey(int key) {
        // 将 key 挪到最后
        boolean isFind = false;
        for (int i = 0; i < pos - 1; i++) {
            if (arr[i] == key) {
                isFind = true;
            }
            if (isFind) {
                arr[i] = arr[i + 1];
            }
        }
        arr[pos - 1] = key;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 删除原来的位置
            moveKey(key);
        }
        else {
            // 新插入数据
            if (pos < capacity) {
                // 还有容量
                arr[pos ++] = key;
            }
            else {
                // 容量已满
                // 删除最久远的数据
                map.remove(arr[0]);
                moveKey(arr[0]);
                arr[pos - 1] = key;
            }
        }
        // 插入数据（可能会更新）
        map.put(key, value);
    }
}

class LRUCache5 {

    private Map<Integer, Integer> map;
    public LRUCache5(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity,
                0.75f, true) {
            private static final long serialVersionUID = -6999391428634754068L;
            @Override
            protected boolean removeEldestEntry(
                    Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}