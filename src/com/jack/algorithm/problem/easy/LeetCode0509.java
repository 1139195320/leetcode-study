package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0509 {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        LeetCode0509 main = new LeetCode0509();
    }
}