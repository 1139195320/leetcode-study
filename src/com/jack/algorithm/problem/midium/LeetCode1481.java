package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        if (k >= n) {
            return 0;
        }
        if (k == n - 1) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int cur : arr) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        int[] countArr = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            countArr[i ++] = entry.getValue();
        }
        Arrays.sort(countArr);
        int j = 0;
        while (k > 0) {
            k -= countArr[j ++];
        }
        int res = countArr.length - j;
        if (k < 0) {
            // 当前这个没有减完
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1481 main = new LeetCode1481();
        // 1 2
        System.out.println(main.findLeastNumOfUniqueInts(
                new int[]{5, 5, 4}, 1
        ));
        // 1 1 2 3
        System.out.println(main.findLeastNumOfUniqueInts(
                new int[]{4, 3, 1, 1, 3, 3, 2}, 3
        ));
    }
}