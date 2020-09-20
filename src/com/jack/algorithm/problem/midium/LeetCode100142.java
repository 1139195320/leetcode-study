package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode100142 {

    public int cuttingRope(int n) {
        // error
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i / 2 + 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
            dp[i] %= MOD;
        }
        if (n <= 3) {
            return (int) dp[n] - 1;
        }
        return (int) dp[n];
    }

    public int cuttingRope2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int MOD = 1_000_000_007;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= MOD;
            n -= 3;
        }
        return (int) (res * n % MOD);
    }

    public static void main(String[] args) {
        LeetCode100142 main = new LeetCode100142();
        System.out.println(main.cuttingRope(2));
        System.out.println(main.cuttingRope(10));
        System.out.println(main.cuttingRope(8));
        System.out.println(main.cuttingRope(100));
        System.out.println(main.cuttingRope(1000));
        System.out.println(main.cuttingRope(120));
        System.out.println(main.cuttingRope(127));
    }
}