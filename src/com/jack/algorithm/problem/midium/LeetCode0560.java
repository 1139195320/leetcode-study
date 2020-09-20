package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0560 {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res ++;
                }
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0560 main = new LeetCode0560();
        System.out.println(main.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(main.subarraySum(new int[]{1, 2, 1, 2}, 2));
        System.out.println(main.subarraySum(new int[]{1, 3, 1, 4}, 2));
        System.out.println(main.subarraySum(new int[]{1, 3, 1, 4}, 4));
        System.out.println(main.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(main.subarraySum(new int[]{-1, -1, 1, 1}, 0));
        System.out.println("=========================");
        System.out.println(main.subarraySum2(new int[]{1, 1, 1}, 2));
        System.out.println(main.subarraySum2(new int[]{1, 2, 1, 2}, 2));
        System.out.println(main.subarraySum2(new int[]{1, 3, 1, 4}, 2));
        System.out.println(main.subarraySum2(new int[]{1, 3, 1, 4}, 4));
        System.out.println(main.subarraySum2(new int[]{-1, -1, 1}, 0));
        System.out.println(main.subarraySum2(new int[]{-1, -1, 1, 1}, 0));
    }
}
