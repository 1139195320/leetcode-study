package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0477 {

    public int totalHammingDistance(int[] nums) {
        // 超时
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            int num1 = entry1.getKey();
            int count1 = entry1.getValue();
            for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
                int num2 = entry2.getKey();
                if (num2 == num1) {
                    continue;
                }
                int count2 = entry2.getValue();
                res += cal(num1, num2) * count1 * count2;
            }
        }
        return res >> 1;
    }
    private int cal(int num1, int num2) {
        return Integer.bitCount(num1 ^ num2);
    }

    public int totalHammingDistance2(int[] nums) {
        int res = 0;
        int n = 31;
        while (n >= 0) {
            int cur = 1 << n;
            int zeroC = 0;
            int oneC = 0;
            for (int num : nums) {
                if ((num & cur) == 0) {
                    zeroC ++;
                } else {
                    oneC ++;
                }
            }
            res += zeroC * oneC;
            n --;
        }
        return res;
    }
}
