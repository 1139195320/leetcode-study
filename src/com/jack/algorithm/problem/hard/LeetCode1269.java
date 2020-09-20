package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode1269 {

    public int numWays(int steps, int arrLen) {
        int MOD = 1_000_000_007;
        // 一直往右最远也只能到 steps + 1 的位置
        arrLen = Math.min(arrLen, steps + 1);
        // i 步，到了位置 j
        int[][] dp = new int[steps + 1][arrLen];
        // 走 0 步 在位置 0
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < arrLen; j++) {
                // 走了 i - 1 步，在左边位置、自身位置、右边位置
                for (int k = -1; k <= 1; k ++) {
                    if (j - k >= 0 && j - k < arrLen) {
                        dp[i][j] += dp[i - 1][j - k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        LeetCode1269 main = new LeetCode1269();
        System.out.println(main.numWays(3, 2));
        System.out.println(main.numWays(2, 4));
        System.out.println(main.numWays(4, 2));
        System.out.println(main.numWays(500, 100_00));
    }
}