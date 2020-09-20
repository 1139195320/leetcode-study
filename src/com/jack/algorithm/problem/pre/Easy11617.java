package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy11617 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
