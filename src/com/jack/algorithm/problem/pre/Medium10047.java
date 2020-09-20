package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium10047 {

    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][]dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = find(grid, i, j, dp);
            }
        }
        return dp[row - 1][col - 1];
    }
    private int find(int[][] grid, int x, int y, int[][]dp) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (dp[x][y] == 0) {
            dp[x][y] = grid[x][y] +
                    Math.max(find(grid, x - 1, y, dp),
                            find(grid, x, y - 1, dp));
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        Medium10047 main = new Medium10047();
        System.out.println(
                main.maxValue(
                        new int[][]{
                                {1, 3, 1},
                                {1, 5, 1},
                                {4, 2, 1}
                        }
                )
        );
    }
}