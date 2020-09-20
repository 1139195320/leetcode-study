package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0097 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j]
                            || (dp[i - 1][j]
                            && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j]
                            || (dp[i][j - 1]
                            && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j]
                            && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    dp[j] = dp[j]
                            || (dp[j - 1]
                            && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        LeetCode0097 main = new LeetCode0097();
    }
}