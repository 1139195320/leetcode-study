package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0260 {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[index ++] = entry.getKey();
            }
        }
        return res;
    }

    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int xi = 1;
        while ((xi & xor) == 0) {
            xi <<= 1;
        }
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        for (int num : nums) {
            if ((num & xi) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0260 main = new LeetCode0260();
        System.out.println(Arrays.toString(main.singleNumber(new int[]{1, 2, 4, 1, 2, 5})));
        System.out.println(Arrays.toString(main.singleNumber(new int[]{1, 2, 4, 1})));
        System.out.println(Arrays.toString(main.singleNumber2(new int[]{1, 2, 4, 1, 2, 5})));
        System.out.println(Arrays.toString(main.singleNumber2(new int[]{1, 2, 4, 1})));
    }
}
