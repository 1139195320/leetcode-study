package com.jack.algorithm.problem.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0136 {

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
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        LeetCode0136 main = new LeetCode0136();
        System.out.println(main.singleNumber(new int[]{2, 2, 1}));
        System.out.println(main.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(main.singleNumber2(new int[]{2, 2, 1}));
        System.out.println(main.singleNumber2(new int[]{4, 1, 2, 1, 2}));
    }
}
