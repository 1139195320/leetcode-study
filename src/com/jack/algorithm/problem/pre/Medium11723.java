package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11723 {

    public int[] findSquare(int[][] matrix) {
        int[] res = new int[3];
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        boolean isInit = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][col - 1] == 0) {
                dp[i][col - 1] = 1;
                if (!isInit) {
                    res[0] = i;
                    res[1] = col - 1;
                    res[2] = 1;
                    isInit = true;
                }
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[row - 1][i] == 0) {
                dp[row - 1][i] = 1;
                if (!isInit) {
                    res[0] = row - 1;
                    res[1] = i;
                    res[2] = 1;
                    isInit = true;
                }
            }
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = Math.min(
                            Math.min(dp[i + 1][j], dp[i][j + 1]),
                            dp[i + 1][j + 1]) + 1;
                    if (dp[i][j] >= res[2]) {
                        res[0] = i;
                        res[1] = j;
                        res[2] = dp[i][j];
                    }
                }
            }
        }
        if (res[2] == 0) {
            return new int[]{};
        }
        return res;
    }

    public static void main(String[] args) {
        Medium11723 main = new Medium11723();
        System.out.println(Arrays.toString(
                main.findSquare(
                        new int[][]{
                                {1, 1, 1},
                        }
                )
        ));
        System.out.println(Arrays.toString(
                main.findSquare(
                        new int[][]{
                                {1, 0, 1},
                                {0, 0, 1},
                                {0, 0, 1}
                        }
                )
        ));
        System.out.println(Arrays.toString(
                main.findSquare(
                        new int[][]{
                                {0, 1, 1},
                                {1, 0, 1},
                                {1, 1, 0}
                        }
                )
        ));
    }
}