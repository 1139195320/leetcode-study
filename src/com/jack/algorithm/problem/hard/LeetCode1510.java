package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode1510 {

    public boolean winnerSquareGame(int n) {
        if (n == 1) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode1510 main = new LeetCode1510();
        System.out.println(main.winnerSquareGame(1));
        System.out.println(main.winnerSquareGame(2));
        System.out.println(main.winnerSquareGame(4));
        System.out.println(main.winnerSquareGame(7));
        System.out.println(main.winnerSquareGame(17));
    }
}