package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1509 {

    public int minDifference(int[] nums) {
        int c = 4;
        int n = nums.length;
        if (n <= c) {
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < c; i++) {
            res = Math.min(res, nums[n - c + i] - nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1509 main = new Medium1509();
    }
}