package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0063 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (i == 0) {
                dp[0][i] = obstacleGrid[0][i] == 0 ? 1 : 0;
            } else {
                dp[0][i] = obstacleGrid[0][i] == 0
                        && dp[0][i - 1] == 1 ? 1 : 0;
            }
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = obstacleGrid[i][0] == 0
                    && dp[i - 1][0] == 1 ? 1 : 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        LeetCode0063 main = new LeetCode0063();
        System.out.println(main.uniquePathsWithObstacles(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }
        ));
    }
}