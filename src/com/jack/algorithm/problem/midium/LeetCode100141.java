package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode100141 {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 2; j < i / 2 + 1; j++) {
                int one = Math.max(j, dp[j]);
                int two = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], one * two);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode100141 main = new LeetCode100141();
        System.out.println(main.cuttingRope(2));
        System.out.println(main.cuttingRope(10));
        System.out.println(main.cuttingRope(58));
    }
}