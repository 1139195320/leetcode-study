package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0509 {

    public int fib(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Easy0509 main = new Easy0509();
    }
}