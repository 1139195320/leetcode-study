package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0561 main = new LeetCode0561();
    }
}