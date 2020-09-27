package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0221 {

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int [][]dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 边上
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(
                                    Math.min(dp[i - 1][j - 1], dp[i - 1][j])
                                , dp[i][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        LeetCode0221 main = new LeetCode0221();
        System.out.println(main.maximalSquare(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }));
    }
}
