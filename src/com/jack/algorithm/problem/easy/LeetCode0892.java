package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0892 {

    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int allSum = 0, sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = grid[i][j];
                if (cur == 0) {
                    continue;
                }
                // 块的个数
                allSum += cur;
                // 这一堆上下之间的接触面
                sum += (cur - 1);
                // 这一堆与 x 左之间的接触面
                if (i > 0) {
                    sum += Math.min(cur, grid[i - 1][j]);
                }
                // 这一堆与 y 左之间的接触面
                if (j > 0) {
                    sum += Math.min(cur, grid[i][j - 1]);
                }
            }
        }
        return 6 * allSum - 2 * sum;
    }
}
