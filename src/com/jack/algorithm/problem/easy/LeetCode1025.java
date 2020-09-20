package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1025 {

    public boolean divisorGame3(int N) {
        return (N & 1) == 0;
    }

    public boolean divisorGame2(int N) {
        return N % 2 == 0;
    }

    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        LeetCode1025 main = new LeetCode1025();
        System.out.println(main.divisorGame(2));
        System.out.println(main.divisorGame(3));
        for (int i = 4; i < 10; i++) {
            System.out.println(main.divisorGame(i));
        }
    }
}