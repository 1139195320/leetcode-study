package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = coins[0]; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i <= coin) {
                    if (i == coin) {
                        dp[i] = 1;
                    }
                    break;
                }
                if (dp[i - coin] == -1 || i - coin < coins[0]) {
                    continue;
                }
                dp[i] = dp[i] == -1 ? dp[i - coin] + 1
                        : Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        LeetCode0322 main = new LeetCode0322();
        System.out.println(main.coinChange(
                new int[] {1, 2, 5}, 7
        ));
        System.out.println(main.coinChange(
                new int[] {1, 2, 5}, 9
        ));
        System.out.println(main.coinChange(
                new int[] {1, 2, 5}, 10
        ));
        System.out.println(main.coinChange(
                new int[] {1, 5}, 7
        ));
        System.out.println(main.coinChange(
                new int[] {1, 5}, 8
        ));
    }
}