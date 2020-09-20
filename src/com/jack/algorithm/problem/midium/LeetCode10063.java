package com.jack.algorithm.problem.midium;

/**
 * @author jack
 *
 */
public class LeetCode10063 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int preMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            if (cur < preMin) {
                preMin = cur;
            } else {
                res = Math.max(res, cur - preMin);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode10063 main = new LeetCode10063();
        System.out.println(main.maxProfit(
                new int[]{7, 1, 5, 3, 6, 4}
        ));
        System.out.println(main.maxProfit(
                new int[]{7, 6, 4, 3, 1}
        ));
    }
}