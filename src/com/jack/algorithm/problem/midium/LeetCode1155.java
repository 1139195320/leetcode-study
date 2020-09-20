package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1155 {

    private static final int MOD = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[31][1001];
        int min = Math.min(f, target);
        // 从一个骰子来达到某个和值的可能情况数为 1
        for (int i = 0; i <= min; i++) {
            dp[1][i] = 1;
        }
        // 最大能得到的和值
        int maxTarget = d * f;
        // 骰子数大于 1 开始才有意义
        for (int i = 2; i <= d; i++) {
            // i 个骰子开始，则和从 i 开始
            for (int j = i; j <= maxTarget; j++) {
                for (int k = 1; k < j && k <= f; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= MOD;
                }
            }
        }
        return dp[d][target];
    }

    public static void main(String[] args) {
        LeetCode1155 main = new LeetCode1155();
        System.out.println(main.numRollsToTarget(
                1, 6, 3
        ));
        System.out.println(main.numRollsToTarget(
                2, 6, 7
        ));
        System.out.println(main.numRollsToTarget(
                2, 5, 10
        ));
        System.out.println(main.numRollsToTarget(
                1, 2, 3
        ));
        System.out.println(main.numRollsToTarget(
                30, 30, 500
        ));
    }
}
