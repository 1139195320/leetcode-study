package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0714 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = - prices[i] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i],
                    dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1],
                    dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        LeetCode0714 main = new LeetCode0714();
        System.out.println(main.maxProfit(
                new int[] {1, 3, 2, 8, 4, 9}, 2
        ));
    }
}
