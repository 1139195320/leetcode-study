package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0883 {

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int maxX = 0, maxY = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    res ++;
                }
                maxX = Math.max(maxX, grid[i][j]);
                maxY = Math.max(maxY, grid[j][i]);
            }
            res += maxX;
            res += maxY;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0883 main = new LeetCode0883();
        System.out.println(main.projectionArea(new int[][]{
                {1, 2}, {3, 4}
        }));
    }
}
