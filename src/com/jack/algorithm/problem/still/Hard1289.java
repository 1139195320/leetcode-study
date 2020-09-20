package com.jack.algorithm.problem.still;

/**
 * @author jack
 */
public class Hard1289 {

    public int minFallingPathSum(int[][] arr) {
        int res = 100;
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            dp[0][i] = arr[0][i];
            res = Math.min(res, dp[0][i]);
        }
        for (int i = 1; i < row; i++) {
            res = 100;
            for (int j = 0; j < col; j++) {
                dp[i][j] = 100;
                for (int k = 0; k < col; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i][j],
                                arr[i][j] + dp[i - 1][k]);
                    }
                }
                if (i == row - 1) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public int minFallingPathSum2(int[][] arr) {
        int MAX = 100;
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        int minVal = MAX;
        int minIdx = 0;
        int secMinVal = MAX;
        for (int i = 0; i < col; i++) {
            int cur = arr[0][i];
            dp[0][i] = cur;
            if (cur < minVal) {
                secMinVal = minVal;
                minVal = cur;
                minIdx = i;
            }
        }
        for (int i = 1; i < row; i++) {
            int curMinVal = MAX;
            int curSecMinVal = MAX;
            int curMinIdx = 0;
            for (int j = 0; j < col; j++) {
                dp[i][j] = arr[i][j] + (j != minIdx ? minVal : secMinVal);
                int cur = dp[i][j];
                if (cur < curMinVal) {
                    curSecMinVal = curMinVal;
                    curMinVal = cur;
                    curMinIdx = j;
                }
            }
            minVal = curMinVal;
            minIdx = curMinIdx;
            secMinVal = curSecMinVal;
        }
        int res = dp[row - 1][0];
        for (int i = 0; i < col; i++) {
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Hard1289 main = new Hard1289();
        System.out.println(main.minFallingPathSum(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        ));
        System.out.println(main.minFallingPathSum2(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        ));
    }
}