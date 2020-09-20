package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode10029 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[0];
        }
        if (matrix.length == 1) {
            return matrix[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean [][]visited = new boolean[row][col];
        boolean toRight = true;
        boolean toLeft = false;
        boolean toDown = false;
        int[] res = new int[row * col];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k != res.length) {
            res[k++] = matrix[i][j];
            visited[i][j] = true;
            if (toRight) {
                if (j + 1 < col && !visited[i][j + 1]) {
                    j ++;
                } else {
                    toRight = false;
                    toDown = true;
                    i ++;
                }
            } else if (toDown) {
                if (i + 1 < row && !visited[i + 1][j]) {
                    i ++;
                } else {
                    toDown = false;
                    toLeft = true;
                    j --;
                }
            } else if (toLeft) {
                if (j - 1 >= 0 && !visited[i][j - 1]) {
                    j --;
                } else {
                    toLeft = false;
                    i --;
                }
            } else {
                if (i - 1 >= 0 && !visited[i - 1][j]) {
                    i --;
                } else {
                    toRight = true;
                    j ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode10029 main = new LeetCode10029();
        System.out.println(Arrays.toString(main.spiralOrder(
                new int[][] {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                }
        )));
        System.out.println(Arrays.toString(main.spiralOrder(
                new int[][] {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                }
        )));
    }
}