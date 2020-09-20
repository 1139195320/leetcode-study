package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jack
 */
public class LeetCode1146 {

    public static void main(String[] args) {
        SnapshotArray obj = new SnapshotArray(1);
        obj.set(0, 15);
        System.out.println(obj.snap());
        System.out.println(obj.snap());
        System.out.println(obj.snap());
        System.out.println(obj.get(0, 2));
        System.out.println(obj.snap());
        System.out.println(obj.snap());
        System.out.println(obj.get(0, 0));
    }
}

class SnapshotArray {
    private int snap = 0;
    private List<TreeMap<Integer, Integer>> list;
    SnapshotArray(int length) {
        list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new TreeMap<>());
        }
    }
    void set(int index, int val) {
        TreeMap<Integer, Integer> map = list.get(index);
        if (map != null) {
            map.put(snap, val);
        }
    }
    int snap() {
        return snap ++;
    }
    int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = list.get(index);
        // 方法调用返回的最大键小于等于key，或者null，如果不存在这样的键
        Integer key = map.floorKey(snap_id);
        return key != null ? map.get(key) : 0;
    }
}