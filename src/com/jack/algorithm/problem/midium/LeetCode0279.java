package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode0279 main = new LeetCode0279();
        System.out.println(main.numSquares(12));
        System.out.println(main.numSquares(13));
    }
}
