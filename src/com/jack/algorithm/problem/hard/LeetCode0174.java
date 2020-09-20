package com.jack.algorithm.problem.hard;

/**
 * @author jackx
 */
public class LeetCode0174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int [][] dp = new int[row][col];
        int tmp = 1 - dungeon[row - 1][col - 1];
        dp[row - 1][col - 1] = tmp > 0 ? tmp : 1;
        for (int i = row - 1 - 1; i >= 0; i --) {
            dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - dungeon[i][col - 1]);
        }
        for (int i = col - 1 - 1; i >= 0; i --) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - dungeon[row - 1][i]);
        }
        for (int i = row - 1 - 1; i >= 0; i --) {
            for (int j = col - 1 - 1; j >= 0; j--) {
                int curTmp = (Math.min(dp[i + 1][j], dp[i][j + 1])) - dungeon[i][j];
                dp[i][j] = Math.max(1, curTmp);
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        int tail = dungeon[row - 1][col - 1];
        dp[row - 1][col - 1] = tail >= 1 ? 1 : 1 - tail;
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = Math.max(1,
                    dp[i + 1][col - 1] - dungeon[i][col - 1]);
        }
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(1,
                    dp[row - 1][i + 1] - dungeon[row - 1][i]);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1,
                        Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        LeetCode0174 main = new LeetCode0174();
        System.out.println(main.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
        System.out.println(main.calculateMinimumHP2(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}
