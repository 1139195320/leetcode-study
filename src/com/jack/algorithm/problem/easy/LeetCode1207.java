package com.jack.algorithm.problem.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 * 独一无二的出现次数
 */
public class LeetCode1207 {

    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int cur : arr) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int count : map.values()) {
            if (set.contains(count)) {
                return false;
            }
            set.add(count);
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1207 main = new LeetCode1207();
        // 3 2 1 true
        System.out.println(main.uniqueOccurrences(
                new int[]{1, 2, 2, 1, 1, 3}
        ));
        // 1 1 false
        System.out.println(main.uniqueOccurrences(
                new int[]{1, 2}
        ));
    }
}
