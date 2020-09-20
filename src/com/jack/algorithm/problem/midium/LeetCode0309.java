package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][j]
        // 第 i 天
        // 手上是否有股票 j，0 无，1 有
        int[][] dp = new int[n][2];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = -prices[i];
                continue;
            }
            // 前无，或前有现卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            res = Math.max(res, dp[i][0]);
            // 前有，或前无现买入
            if (i == 1) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }

        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int res = 0;
        int dp_i_0 = 0;
        int dp_i_1 = 0;
        int dp_i_pre = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp_i_1 = - prices[i];
                continue;
            }
            int tmp_i_0 = dp_i_0;
            int tmp_i_1 = dp_i_1;
            // 前无，或前有现卖出
            dp_i_0 = Math.max(tmp_i_0, tmp_i_1 + prices[i]);
            res = Math.max(res, dp_i_0);
            // 前有，或前无现买入
            if (i == 1) {
                dp_i_1 = Math.max(tmp_i_1, tmp_i_0 - prices[i]);
            } else {
                dp_i_1 = Math.max(tmp_i_1, dp_i_pre - prices[i]);
            }
            dp_i_pre = tmp_i_0;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0309 main = new LeetCode0309();
        System.out.println(main.maxProfit(
                new int[]{1, 2, 3, 0, 2}
        ));
        System.out.println(main.maxProfit2(
                new int[]{1, 2, 3, 0, 2}
        ));
    }
}