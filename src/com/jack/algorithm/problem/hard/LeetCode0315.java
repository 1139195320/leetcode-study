package com.jack.algorithm.problem.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jack
 */
public class LeetCode0315 {

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        List<Integer> dataList = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = nums[i];
            dataList.add(cur);
            Integer key = map.floorKey(cur);
            if (key == null) {
                res.addFirst(0);
                map.put(cur, 0);
                map.put(cur + 1,
                        map.getOrDefault(cur + 1, 0) + 1);
            } else {
                if (key == cur) {
                    res.addFirst(map.get(key));
                } else {
                    // cur > key
                    int val = map.get(key);
                    if (dataList.contains(key)) {
                        val ++;
                    }
                    res.addFirst(val);
                    map.put(cur, val);
                }
                if (map.containsKey(cur + 1)) {
                    map.put(cur + 1, map.get(cur + 1) + 1);
                } else {
                    map.put(cur + 1, map.get(cur) + 1);
                }
            }
            Integer fKey = map.ceilingKey(cur + 2);
            while (fKey != null) {
                map.put(fKey, map.get(fKey) + 1);
                fKey = map.ceilingKey(fKey + 1);
            }
        }
        return res;
    }

    public List<Integer> countSmaller2(int[] nums) {
        int[] res = new int[nums.length];
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count ++;
                }
                if (nums[i] == nums[j]) {
                    count += res[j];
                    break;
                }
            }
            res[i] = count;
        }
        return Arrays.stream(res).boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LeetCode0315 main = new LeetCode0315();
        main.testCountSmaller2();
    }

    private void testCountSmaller() {
        System.out.println(countSmaller(
                // 0 3 1 1 0
                new int[] {1, 9, 7, 8, 5}
        ));
        System.out.println(countSmaller(
                // 2 1 1 0
                new int[] {5, 2, 6, 1}
        ));
        System.out.println(countSmaller(
                // 5 4 4 1 1 0 0
                new int[] {5, 2, 6, 1, 1, 0, 1}
        ));
        System.out.println(countSmaller(
                // 8 4 7 1 0 4 3 0 1 0
                new int[] {5, 2, 6, 1, 0, 4, 3, 1, 2, 1}
        ));
    }
    private void testCountSmaller2() {
        System.out.println(countSmaller2(
                // 0 3 1 1 0
                new int[] {1, 9, 7, 8, 5}
        ));
        System.out.println(countSmaller2(
                // 2 1 1 0
                new int[] {5, 2, 6, 1}
        ));
        System.out.println(countSmaller2(
                // 5 4 4 1 1 0 0
                new int[] {5, 2, 6, 1, 1, 0, 1}
        ));
        System.out.println(countSmaller2(
                // 8 4 7 1 0 4 3 0 1 0
                new int[] {5, 2, 6, 1, 0, 4, 3, 1, 2, 1}
        ));
    }
}