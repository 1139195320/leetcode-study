package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0137 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        Set<Long> set = new HashSet<>();
        long actualSum = 0;
        for (long num : nums) {
            set.add(num);
            actualSum += num;
        }
        long expectSum = 0;
        for (long i : set) {
            expectSum += i;
        }
        return (int) ((expectSum * 3 - actualSum) / 2);
    }

    public int singleNumber3(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < counts.length; i++) {
                if ((num & 1) == 1) {
                    counts[i] ++;
                }
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 3 == 1) {
                res += (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0137 main = new LeetCode0137();
        System.out.println(main.singleNumber(new int[]{2, 2, 1, 2}));
        System.out.println(main.singleNumber(new int[]{4, 1, 2, 1, 4, 4, 1}));
        System.out.println(main.singleNumber2(new int[]{2, 2, 1, 2}));
        System.out.println(main.singleNumber2(new int[]{4, 1, 2, 1, 4, 4, 1}));
        System.out.println(main.singleNumber3(new int[]{2, 2, 1, 2}));
        System.out.println(main.singleNumber3(new int[]{4, 1, 2, 1, 4, 4, 1}));
    }
}
