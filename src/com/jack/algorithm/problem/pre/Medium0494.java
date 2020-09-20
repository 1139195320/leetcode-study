package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0494 {

    public int findTargetSumWays(int[] nums, int S) {
        // 初始的数组的和不会超过 1000
        // 正负区间为 -1000 ~ 1000
        int base = 1000;
        int[][] dp = new int[nums.length][(base << 1) + 1];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = - base; j <= base; j++) {
                if (dp[i - 1][j + 1000] > 0) {
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public static void main(String[] args) {
        Medium0494 main = new Medium0494();
        System.out.println(main.findTargetSumWays(
                new int[] {1, 1, 1, 1, 1}, 3
        ));
    }
}