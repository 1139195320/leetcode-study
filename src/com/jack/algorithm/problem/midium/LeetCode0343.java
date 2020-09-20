package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i],
                        Math.max(j , dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    public int integerBreak3(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode0343 main = new LeetCode0343();
        System.out.println(main.integerBreak(2));
        System.out.println(main.integerBreak(5));
        System.out.println(main.integerBreak(9));
        System.out.println(main.integerBreak(10));
    }
}