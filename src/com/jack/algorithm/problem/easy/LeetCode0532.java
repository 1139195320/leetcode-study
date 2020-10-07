package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (cur == a && nums[j] == b) {
                    continue;
                }
                if (Math.abs(cur - nums[j]) == k) {
                    a = cur;
                    b = nums[j];
                    res ++;
                }
            }
        }
        return res;
    }

    public int findPairs2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Set<Integer> saw = new HashSet<>();
        Set<Integer> diff = new HashSet<>();
        for (int num : nums) {
            if (saw.contains(num - k)) {
                diff.add(num - k);
            }
            if (saw.contains(num + k)) {
                diff.add(num);
            }
            saw.add(num);
        }
        return diff.size();
    }

    public static void main(String[] args) {
        LeetCode0532 main = new LeetCode0532();
    }
}