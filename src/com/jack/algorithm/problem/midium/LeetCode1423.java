package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1423 {

    public int maxScore(int[] cardPoints, int k) {
        // 此方法超时，没必要
        // 直接前面取 i 个，后面取 k - i 个，比较最大
        return doMaxScore(cardPoints, 0, cardPoints.length - 1,
                k, 0, 0);
    }
    private int doMaxScore(int[] cardPoints, int l, int r,
                           int k, int count, int pre) {
        if (count == k - 1) {
            return pre + Math.max(cardPoints[l], cardPoints[r]);
        }
        return Math.max(doMaxScore(cardPoints, l + 1, r, k,
                count + 1, pre + cardPoints[l]),
                doMaxScore(cardPoints, l, r - 1, k,
                        count + 1, pre + cardPoints[r]));
    }

    public int maxScore2(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // dp[i]：取左边的 i 个数 右边 k - i 个数
        int[] dp = new int[k + 1];
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            dp[k] += cardPoints[i - 1];
        }
        int res = dp[k];
        for (int i = 1; i <= k; i++) {
            dp[k - i] = dp[k - i + 1] - cardPoints[k - i] + cardPoints[n - i];
            res = Math.max(res, dp[k - i]);
        }
        return res;
    }

    public int maxScore3(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int pre = 0;
        for (int i = 1; i <= k; i++) {
            pre += cardPoints[i - 1];
        }
        int res = pre;
        for (int i = 1; i <= k; i++) {
            int cur = pre - cardPoints[k - i] + cardPoints[n - i];
            res = Math.max(res, cur);
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1423 main = new LeetCode1423();
        System.out.println(main.maxScore(
                new int[]{1, 2, 3, 4, 5, 6, 1}, 3
        ));
        System.out.println(main.maxScore(
                new int[]{2, 2, 2}, 2
        ));
        System.out.println(main.maxScore(
                new int[]{9, 7, 7, 9, 7, 7, 9}, 7
        ));
        System.out.println(main.maxScore(
                new int[]{1, 1000, 1}, 1
        ));
        System.out.println(main.maxScore(
                new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3
        ));
        System.out.println();
        System.out.println(main.maxScore2(
                new int[]{1, 2, 3, 4, 5, 6, 1}, 3
        ));
        System.out.println(main.maxScore2(
                new int[]{2, 2, 2}, 2
        ));
        System.out.println(main.maxScore2(
                new int[]{9, 7, 7, 9, 7, 7, 9}, 7
        ));
        System.out.println(main.maxScore2(
                new int[]{1, 1000, 1}, 1
        ));
        System.out.println(main.maxScore2(
                new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3
        ));
    }
}