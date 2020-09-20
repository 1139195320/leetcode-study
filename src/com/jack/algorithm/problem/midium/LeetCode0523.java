package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (j > i && ((k == 0 && sum == k) || (k != 0 && sum % k == 0))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;
        for (int i = 0; i < nums.length; i ++) {
            pre += nums[i];
            if (k != 0) {
                pre %= k;
            }
            if (map.containsKey(pre)) {
                if (i - map.get(pre) > 1) {
                    return true;
                }
            } else {
                map.put(pre, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0523 main = new LeetCode0523();
        System.out.println(main.checkSubarraySum(new int[]{1, 5, 2, 3, 1}, 4));
        System.out.println(main.checkSubarraySum(new int[]{1, 5, 2, 3, 1}, 2));
        System.out.println(main.checkSubarraySum(new int[]{0, 1, 0}, 0));
        System.out.println(main.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println("==================");
        System.out.println(main.checkSubarraySum2(new int[]{1, 5, 2, 3, 1}, 4));
        System.out.println(main.checkSubarraySum2(new int[]{1, 5, 2, 3, 1}, 2));
        System.out.println(main.checkSubarraySum2(new int[]{0, 1, 0}, 0));
        System.out.println(main.checkSubarraySum2(new int[]{23, 2, 4, 6, 7}, 6));
    }
}
