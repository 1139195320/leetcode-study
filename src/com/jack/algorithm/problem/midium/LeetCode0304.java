package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0304 {

    public static void main(String[] args) {
        NumMatrix matrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
        System.out.println(matrix.sumRegion(1, 1, 2, 2));
        System.out.println(matrix.sumRegion(1, 2, 2, 4));
    }
}

class NumMatrix {

    private int[][]dp;
    private boolean isEmpty;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            isEmpty = true;
            return;
        }
        int col = matrix[0].length;
        if (col == 0) {
            isEmpty = true;
            return;
        }
        dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j]
                        + dp[i][j - 1]
                        - dp[i - 1][j - 1]
                        + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1,
                         int row2, int col2) {
        if (isEmpty) {
            return 0;
        }
        if (row1 > 0 && col1 > 0) {
            return dp[row2][col2] + dp[row1 - 1][col1 - 1]
                    - dp[row1 - 1][col2] - dp[row2][col1 - 1];
        }
        if (row1 > 0) {
            return dp[row2][col2] - dp[row1 - 1][col2];
        }
        if (col1 > 0) {
            return dp[row2][col2] - dp[row2][col1 - 1];
        }
        return dp[row2][col2];
    }
}

class NumMatrix2 {

    private int[][]data;

    public NumMatrix2(int[][] matrix) {
        data = matrix;
    }

    public int sumRegion(int row1, int col1,
                         int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += data[i][j];
            }
        }
        return sum;
    }
}