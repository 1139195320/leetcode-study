package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode11624 {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int other = target - num;
            int count = countMap.getOrDefault(num, 0);
            if (num == other) {
                if (count >= 2) {
                    res.add(Arrays.asList(num, other));
                    countMap.put(num, count - 2);
                }
            }
            else {
                int count2 = countMap.getOrDefault(other, 0);
                if (count > 0 && count2 > 0) {
                    res.add(Arrays.asList(num, other));
                    countMap.put(num, count - 1);
                    countMap.put(other, count2 - 1);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> pairSums2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r --;
            } else if (sum < target) {
                l ++;
            } else {
                res.add(Arrays.asList(nums[l ++], nums[r --]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode11624 main = new LeetCode11624();
        System.out.println(main.pairSums(
                new int[]{5, 6, 5}, 11
        ));
        System.out.println(main.pairSums(
                new int[]{5, 6, 5, 6}, 11
        ));
    }
}