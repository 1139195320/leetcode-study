package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0746 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + (i != len ? cost[i] : 0);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Easy0746 main = new Easy0746();
        System.out.println(main.minCostClimbingStairs(
                new int[] {10, 15, 20, 1, 10, 25}
        ));
        System.out.println(main.minCostClimbingStairs(
                new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        ));
    }
}