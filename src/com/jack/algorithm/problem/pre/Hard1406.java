package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard1406 {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        if (n == 0) {
            return "Tie";
        }
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = stoneValue[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + stoneValue[i];
        }
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 当前取了1、2、3堆时，后面能取的最大值里面最小的
            int bestJ = dp[i + 1];
            for (int j = i + 2; j <= i + 3 && j <= n; j++) {
                bestJ = Math.min(bestJ, dp[j]);
            }
            dp[i] = suffixSum[i] - bestJ;
        }
        int total = suffixSum[0];
        if (dp[0] * 2 == total) {
            return "Tie";
        }
        return dp[0] * 2 > total ? "Alice" : "Bob";
    }

    public static void main(String[] args) {
        Hard1406 main = new Hard1406();
        System.out.println(main.stoneGameIII(
                new int[]{1, 2, 3, 7}
        ));
        System.out.println(main.stoneGameIII(
                new int[]{1, 2, 3, -9}
        ));
        System.out.println(main.stoneGameIII(
                new int[]{1, 2, 3, 6}
        ));
        System.out.println(main.stoneGameIII(
                new int[]{1, 2, 3, -1, -2, -3, 7}
        ));
        System.out.println(main.stoneGameIII(
                new int[]{-1, -2, -3}
        ));
    }
}