package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard1444 {

    public int ways(String[] pizza, int k) {
        int MOD = 1_000_000_007;
        int row = pizza.length;
        int col = pizza[0].length();
        // 以 i, j 为左上角到右下角区域内的 appleCount 数量
        int[][] appleCount = new int[row + 1][col + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (pizza[i].charAt(j) == 'A') {
                    appleCount[i][j] = 1;
                }
                appleCount[i][j] += appleCount[i + 1][j]
                        + appleCount[i][j + 1]
                        - appleCount[i + 1][j + 1];
            }
        }
        // dp[n][i][j]：切了 n 次，剩余的区域为以 i, j为左上角的区域
        int[][][] dp = new int[k][row][col];
        dp[0][0][0] = 1;
        for (int n = 0; n < k; n++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int count = 0;
                    for (int l = 0; l < i; l++) {
                        int flag = appleCount[l][j] - appleCount[i][j];
                        // 切走的块上的 appleCount > 0
                        // 剩余块上的 appleCount > 0
                        if (flag > 0 && appleCount[i][j] > 0) {
                            // 上一个状态为 切了 n - 1 次
                            // 以 l, j 为左上角的区域
                            count += dp[n - 1][l][j];
                            count %= MOD;
                        }
                    }
                    for (int l = 0; l < j; l++) {
                        int flag = appleCount[i][l] - appleCount[i][j];
                        // 切走的块上的 appleCount > 0
                        // 剩余块上的 appleCount > 0
                        if (flag > 0 && appleCount[i][j] > 0) {
                            // 上一个状态为 切了 n - 1 次
                            // 以 i, l 为左上角的区域
                            count += dp[n - 1][i][l];
                            count %= MOD;
                        }
                    }
                    dp[n][i][j] = count;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res += dp[k - 1][i][j];
                res %= MOD;
            }
        }
        return res;
    }
}
