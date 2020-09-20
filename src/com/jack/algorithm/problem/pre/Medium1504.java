package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1504 {

    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        // dp[i][j] 横向往左的长度，向上的高度
        int[][][] dp = new int[row][col][2];
        int res = mat[0][0];
        dp[0][0][0] = mat[0][0];
        dp[0][0][1] = mat[0][0];
        for (int i = 1; i < row; i++) {
            if (mat[i][0] == 1) {
                dp[i][0][0] = 1;
                dp[i][0][1] = dp[i - 1][0][1] + 1;
                res += dp[i][0][1];
            }
        }
        for (int i = 1; i < col; i++) {
            if (mat[0][i] == 1) {
                dp[0][i][0] = dp[0][i - 1][0] + 1;
                dp[0][i][1] = 1;
                res += dp[0][i][0];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    int cur = dp[i][j - 1][0] + dp[i - 1][j][1] + 1;
                    // 当前处的高度
                    int curH = dp[i][j][1];
                    int k = 1;
                    for (; k < dp[i][j][0]; k++) {
                        // 当前往左走 k 步时可成矩形的高度
                        // 此时有 curH * (k + 1) 的矩形
                        curH = Math.min(dp[i][j - k][1], curH);
                        if (curH <= 1) {
                            break;
                        }
                        cur += (curH - 1);
                    }
                    res += cur;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1504 main = new Medium1504();
        System.out.println(
                main.numSubmat(
                        new int[][]{
                                {1, 0, 1},
                                {1, 1, 0},
                                {1, 1, 0}
                        }
                )
        );
        System.out.println(
                main.numSubmat(
                        new int[][]{
                                {0, 1, 1, 0},
                                {0, 1, 1, 1},
                                {1, 1, 1, 0}
                        }
                )
        );
    }
}