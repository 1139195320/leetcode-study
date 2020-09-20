package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0931 {

    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row][col];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            dp[0][i] = A[0][i];
            if (row == 1) {
                res = Math.min(res, dp[0][i]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int adder = dp[i - 1][j];
                if (j > 0) {
                    adder = Math.min(adder, dp[i - 1][j - 1]);
                }
                if (j < col - 1) {
                    adder = Math.min(adder, dp[i - 1][j + 1]);
                }
                dp[i][j] = A[i][j] + adder;
                if (i == row - 1) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        return res;
    }


    public int minFallingPathSum2(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0) {
                    int adder = A[i - 1][j];
                    if (j > 0) {
                        adder = Math.min(adder, A[i - 1][j - 1]);
                    }
                    if (j < col - 1) {
                        adder = Math.min(adder, A[i - 1][j + 1]);
                    }
                    A[i][j] += adder;
                }
                if (i == row - 1) {
                    res = Math.min(res, A[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0931 main = new Medium0931();
        System.out.println(main.minFallingPathSum(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        ));
        System.out.println(main.minFallingPathSum2(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        ));
    }
}
