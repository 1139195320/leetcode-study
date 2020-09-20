package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0122 {

    public int maxProfit(int[] prices) {
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

    public int maxProfit2(int[] prices) {
        // 通用动态规划
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = - prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0],
                    dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],
                    dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit3(int[] prices) {
        // 通用动态规划（压缩内存）
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int cur_0 = 0;
        int cur_1 = - prices[0];
        for (int i = 1; i < n; i++) {
            int pre_0 = cur_0;
            // 此处 pre_1 可不需要
            int pre_1 = cur_1;
            cur_0 = Math.max(pre_0, pre_1 + prices[i]);
            cur_1 = Math.max(pre_1, pre_0 - prices[i]);
        }
        return cur_0;
    }

    public static void main(String[] args) {
        LeetCode0122 main = new LeetCode0122();
        main.testMaxProfit();
        System.out.println();
        main.testMaxProfit2();
        System.out.println();
        main.testMaxProfit3();
    }

    private void testMaxProfit() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    private void testMaxProfit2() {
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }

    private void testMaxProfit3() {
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit3(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit3(new int[]{7, 6, 4, 3, 1}));
    }
}
