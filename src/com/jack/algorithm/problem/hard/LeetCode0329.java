package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0329 {

    private int[][] dp;
    private int row, col;
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] matrix;
    private int getMaxPath(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        int tmp = 0;
        for (int[] dir : dirs) {
            int preX = x + dir[0];
            int preY = y + dir[1];
            if (isValid(preX, preY)
                    && matrix[preX][preY] < matrix[x][y]) {
                tmp = Math.max(tmp, getMaxPath(preX, preY));
            }
        }
        tmp ++;
        dp[x][y] = tmp;
        return tmp;
    }
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.dp = new int[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, getMaxPath(i, j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0329 main = new LeetCode0329();
        System.out.println(main.longestIncreasingPath(
                new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                }
        ));
        System.out.println(main.longestIncreasingPath(
                new int[][]{
                        {3, 4, 5},
                        {2, 2, 6},
                        {2, 2, 1}
                }
        ));
    }
}