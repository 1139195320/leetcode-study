package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1140 {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= n; M++) {
                if (i + 2 * M >= n) {
                    // 可以一次性拿完
                    dp[i][M] = sum;
                } else {
                    // 可以拿 1 - 2M
                    for (int j = 1; j <= (M * 2); j++) {
                        dp[i][M] = Math.max(dp[i][M],
                                sum - dp[i + j][Math.max(M, j)]);
                    }
                }
            }
        }
        return dp[0][1];
    }


    public static void main(String[] args) {
        Medium1140 main = new Medium1140();
        System.out.println(main.stoneGameII(
                new int[]{2, 7, 9, 4, 4}
        ));
    }
}