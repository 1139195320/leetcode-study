package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode1365 {

    public int[] smallerNumbersThanCurrent(int[] src) {
        int n = src.length;
        if (n == 0) {
            return new int[]{};
        }
        int[] arr = src.clone();
        Arrays.sort(arr);
        Map<Integer, Integer> countMap = new HashMap<>(n);
        int pre = arr[0];
        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            if (cur == pre) {
                continue;
            }
            countMap.put(cur, i);
            pre = cur;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = countMap.getOrDefault(src[i], 0);
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode1365 main = new LeetCode1365();
        // 4 0 1 1 3
        System.out.println(Arrays.toString(main.smallerNumbersThanCurrent(
                new int[]{8, 1, 2, 2, 3}
        )));
        // 2 1 0 3
        System.out.println(Arrays.toString(main.smallerNumbersThanCurrent(
                new int[]{6, 5, 4, 8}
        )));
        // 0 0 0 0
        System.out.println(Arrays.toString(main.smallerNumbersThanCurrent(
                new int[]{7, 7, 7, 7}
        )));
    }

}
