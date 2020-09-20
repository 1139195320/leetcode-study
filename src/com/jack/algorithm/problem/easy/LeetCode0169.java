package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public int majorityElement2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode0169 main = new LeetCode0169();
        System.out.println(main.majorityElement(
                new int[] {3, 2, 3}
        ));
        System.out.println(main.majorityElement(
                new int[]{2, 2, 1, 1, 1, 2, 2}
        ));
        System.out.println(main.majorityElement2(
                new int[] {3, 2, 3}
        ));
        System.out.println(main.majorityElement2(
                new int[]{2, 2, 1, 1, 1, 2, 2}
        ));
    }
}