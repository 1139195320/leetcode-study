package com.jack.algorithm.problem.hard;

/**
 * @author jack
 *
 * 101 010 121 020 202 212
 * 012 021 102 120 201 210
 *
 * ABA -> ABA 3
 * ABA -> ABC 2
 *
 * 101 ->
 * 010 020 212
 * 012 210
 *
 * ABC -> ABA 2
 * ABC -> ABC 2
 *
 * 012 ->
 * 101 121
 * 120 201
 */
public class LeetCode1411 {

    public int numOfWays(int n) {
        int MOD = 1_000_000_007;
        // ABA -> ABA 3
        // ABA -> ABC 2
        // ABC -> ABA 2
        // ABC -> ABC 2
        long[][] dp = new long[2][n];
        // 0：ABA   1：ABC
        dp[0][0] = 6;
        dp[1][0] = 6;
        for (int i = 1; i < n; i++) {
            // 前一个的 ABA + ABC -> ABA
            dp[0][i] = dp[0][i - 1] * 3 + dp[1][i - 1] * 2;
            dp[0][i] %= MOD;
            // 前一个的 ABA + ABC -> ABC
            dp[1][i] = dp[0][i - 1] * 2 + dp[1][i - 1] * 2;
            dp[1][i] %= MOD;
        }
        return (int) (dp[0][n - 1] + dp[1][n - 1]) % MOD;
    }

    public static void main(String[] args) {
        LeetCode1411 main = new LeetCode1411();
        System.out.println(main.numOfWays(1));
        System.out.println(main.numOfWays(2));
        System.out.println(main.numOfWays(3));
        System.out.println(main.numOfWays(7));
        System.out.println(main.numOfWays(5000));
    }
}