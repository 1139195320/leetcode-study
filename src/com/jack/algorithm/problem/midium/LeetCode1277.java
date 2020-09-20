package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1277 {

    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // dp[i][j]：以该点为右下角的最大正方形边长
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        int res = dp[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0];
            res += dp[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = matrix[0][i];
            res += dp[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    int m = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    if (m > 1) {
                        m = Math.min(m, dp[i - 1][j - 1] + 1);
                    }
                    dp[i][j] = m;
                    res += m;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1277 main = new LeetCode1277();
        System.out.println(main.countSquares(
                new int[][]{
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                }
        ));
        System.out.println(main.countSquares(
                new int[][]{
                        {1, 0, 1},
                        {1, 1, 0},
                        {1, 1, 0}
                }
        ));
    }
}