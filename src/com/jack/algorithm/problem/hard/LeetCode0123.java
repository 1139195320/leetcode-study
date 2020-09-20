package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 赋初值
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][1][1] = - prices[i];
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    break;
                }
                if (j > (i / 2 + 1)) {
                    // 第 i 天最多买了 (i / 2 + 1) 次
                    // 不可能的情况
                    dp[i][j][0] = Integer.MIN_VALUE;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                // 前面无现也无，或前面有现卖出
                dp[i][j][0] = Math.max(dp[i - 1][j][0],
                        dp[i - 1][j][1] + prices[i]);
                // 每次卖出的时候才有可能最大
                res = Math.max(res, dp[i][j][0]);
                // 前面有现不动，或前面买了 j-1 次且已卖出此时再买一次
                dp[i][j][1] = Math.max(dp[i - 1][j][1],
                        dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0123 main = new LeetCode0123();
        System.out.println(main.maxProfit(
                new int[]{3, 3, 5, 0, 0, 3, 1, 4}
        ));
        System.out.println(main.maxProfit(
                new int[]{1, 2, 3, 4, 5}
        ));
        System.out.println(main.maxProfit(
                new int[]{7, 6, 4, 3, 1}
        ));
    }
}