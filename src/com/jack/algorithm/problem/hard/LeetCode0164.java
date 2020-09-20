package com.jack.algorithm.problem.hard;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0164 {

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int maxDiff = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        LeetCode0164 main = new LeetCode0164();
    }
}