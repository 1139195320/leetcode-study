package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0664 {

    public int strangePrinter(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] arr = s.toCharArray();
        int n = s.length();
        // 打印 i 到 j 需要的最少次数
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int pos = 1; pos < n; pos++) {
            for (int i = 0; i < n - pos; i++) {
                int j = i + pos;
                dp[i][j] = dp[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++) {
                    if (arr[i] == arr[k]) {
                        int left = dp[i][k - 1];
                        int right = (k + 1 <= j) ? dp[k + 1][j] : 0;
                        dp[i][j] = Math.min(dp[i][j], left + right);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LeetCode0664 main = new LeetCode0664();
        System.out.println(main.strangePrinter("aaabbb"));
        System.out.println(main.strangePrinter("aba"));
    }
}