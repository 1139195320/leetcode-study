package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard0903 {

    public int numPermsDISequence(String S) {
        int n = S.length();
        int MOD = 1_000_000_007;
        // 0-i 以 j 结尾
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (S.charAt(i - 1) == 'D') {
                    // 下降
                    for (int k = j; k <= (i - 1); k++) {
                        // 前 i - 1 个，以大于等于 j 结尾的
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                } else {
                    // 上升
                    for (int k = 0; k <= (j - 1); k++) {
                        // 前 i - 1 个，以小于 j 结尾的
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += dp[n][i];
            res %= MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        Hard0903 main = new Hard0903();
        System.out.println(main.numPermsDISequence("DID"));
    }
}