package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard0552 {

    public int checkRecord(int n) {
        int MOD = 1_000_000_007;
        // 'A' : Absent，缺勤
        // 'L' : Late，迟到
        // 'P' : Present，到场
        // 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
        long[] dp = new long[n <= 5 ? 6 : n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 + dp[i - 4];
            dp[i] %= MOD;
        }
        long sum = dp[n];
        for (int i = 1; i <= n; i++) {
            sum += dp[i - 1] * dp[n - i];
            sum %= MOD;
        }
        return (int) sum;
    }

    public int checkRecord2(int n) {
        int MOD = 1_000_000_007;
        long a0l0 = 1;
        long a0l1 = 0;
        long a0l2 = 0;
        long a1l0 = 0;
        long a1l1 = 0;
        long a1l2 = 0;
        for (int i = 0; i <= n; i++) {
            long a0l0_ = (a0l0 + a0l1 + a0l2) % MOD;
            a0l2 = a0l1;
            a0l1 = a0l0;
            a0l0 = a0l0_;
            long a1l0_ = (a0l0 + a1l0 + a1l1 + a1l2) % MOD;
            a1l2 = a1l1;
            a1l1 = a1l0;
            a1l0 = a1l0_;
        }
        return (int) a1l0;
    }

    public static void main(String[] args) {
        Hard0552 main = new Hard0552();
        System.out.println(main.checkRecord(2));
        System.out.println(main.checkRecord2(2));
    }
}