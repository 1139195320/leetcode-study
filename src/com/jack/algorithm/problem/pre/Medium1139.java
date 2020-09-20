package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row][col][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        int res = 0;
        for (int i = 1; i < row; i++) {
            if (grid[i][0] == 1) {
                dp[i][0][0] = 1;
                dp[i][0][1] = dp[i - 1][0][1] + 1;
                res = 1;
            }
        }
        for (int i = 1; i < col; i++) {
            if (grid[0][i] == 1) {
                dp[0][i][0] = dp[0][i - 1][0] + 1;
                dp[0][i][1] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] == 1) {
                    int[] up = dp[i - 1][j];
                    int[] left = dp[i][j - 1];
                    int k = Math.min(left[0], up[1]) + 1;
                    for (; k > 1; k--) {
                        if (dp[i - k + 1][j][0] == k && dp[i][j - k + 1][1] == k) {
                            break;
                        }
                    }
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    res = Math.max(res, k * k);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1139 main = new Medium1139();
        System.out.println(main.largest1BorderedSquare(
                new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                }
        ));
        System.out.println(main.largest1BorderedSquare(
                new int[][]{
                        {1, 1, 0, 0},
                }
        ));
    }
}
