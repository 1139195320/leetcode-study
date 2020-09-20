package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard1240 {

    public int tilingRectangle(int n, int m) {
        if (n == m) {
            return 1;
        }
        int[][]dp = new int[15][15];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = i == j ? 1 : i * j;
                for (int k = 1; k < i; k++) {
                    // 纵切刀
                    dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    // 横切刀
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
                for (int x = 2; x < i; x++) {
                    for (int y = 2; y < j; y++) {
                        // 中间挖块儿
                        int tmp = Math.min(i - x, j - y);
                        for (int boxSize = 1; boxSize < tmp; boxSize++) {
                            dp[i][j] = Math.min(dp[i][j],
                                    dp[x][y + boxSize]
                                    + dp[x + boxSize][j - (y + boxSize)]
                                    + dp[i - x][y]
                                    + dp[i - (x + boxSize)][j - y] + 1);
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Hard1240 main = new Hard1240();
        System.out.println(main.tilingRectangle(2, 3));
        System.out.println(main.tilingRectangle(5, 8));
        System.out.println(main.tilingRectangle(11, 13));
    }
}