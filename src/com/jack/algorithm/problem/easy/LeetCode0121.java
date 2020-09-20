package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0121 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        int curMin = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] > curMin) {
                res = Math.max(res, prices[i] - curMin);
            } else {
                curMin = prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0121 main = new LeetCode0121();
        System.out.println(main.maxProfit(
                new int[]{7, 1, 5, 3, 6, 4}
        ));
        System.out.println(main.maxProfit(
                new int[] {7, 6, 4, 3, 1}
        ));
    }
}