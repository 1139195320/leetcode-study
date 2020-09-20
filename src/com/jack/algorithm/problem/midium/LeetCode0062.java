package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0062 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LeetCode0062 main = new LeetCode0062();
        System.out.println(main.uniquePaths(3, 2));
        System.out.println(main.uniquePaths(7, 3));
    }
}