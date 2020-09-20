package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy10801 {

    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int MOD = 1_000_000_007;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] %= MOD;
        }
        return dp[n];
    }
}
