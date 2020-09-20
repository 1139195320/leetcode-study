package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0188 {

    public int maxProfit2(int k, int[] prices) {
        // 动态规划，压缩了数组内存
        int n = prices.length;
        if (k == 0 || n <= 1) {
            return 0;
        }
        if (k >= n / 2 + 1) {
            // 次数过大，相当于可以无限次购买卖出
            return maxProfit2(prices);
        }
        int res = 0;
        int[][] dp = new int[k + 1][2];
        dp[1][1] = - prices[0];
        for (int i = 1; i < n; i++) {
            dp[0][1] = Integer.MIN_VALUE;
            for (int j = k; j >= 1; j--) {
                if (j > i / 2 + 1) {
                    // 当前天不可能购买这么多次
                    dp[j][0] = Integer.MIN_VALUE;
                    dp[j][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[j][0] = Math.max(dp[j][0],
                        dp[j][1] + prices[i]);
                res = Math.max(res, dp[j][0]);
                dp[j][1] = Math.max(dp[j][1],
                        dp[j - 1][0] - prices[i]);
            }
        }
        return res;
    }

    public int maxProfit(int k, int[] prices) {
        // 通用动态规划
        int n = prices.length;
        if (k == 0 || n <= 1) {
            return 0;
        }
        if (k >= n / 2 + 1) {
            // 次数过大，相当于可以无限次购买卖出
            return maxProfit(prices);
        }
        int res = 0;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][1][1] = - prices[i];
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    break;
                }
                if (j > i / 2 + 1) {
                    // 当前天不可能购买这么多次
                    dp[i][j][0] = Integer.MIN_VALUE;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0],
                        dp[i - 1][j][1] + prices[i]);
                res = Math.max(res, dp[i][j][0]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1],
                        dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return res;
    }
    private int maxProfit(int[] prices) {
        // 通用动态规划
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = - prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i],
                    dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1],
                    dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    private int maxProfit2(int[] prices) {
        // 贪心算法
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int dif = prices[i] - prices[i - 1];
            if (dif > 0) {
                res += dif;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0188 main = new LeetCode0188();
        System.out.println(main.maxProfit2(
                2, new int[] {2, 1, 4, 5, 2, 9, 7}
        ));
        System.out.println(main.maxProfit2(
                2, new int[] {1, 4, 2, 7}
        ));
        System.out.println(main.maxProfit2(
                3, new int[]{3, 2, 6, 5, 0, 3}
        ));
    }
}
