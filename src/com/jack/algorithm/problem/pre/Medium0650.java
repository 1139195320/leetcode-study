package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0650 {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + 1 + i / j - 1;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Medium0650 main = new Medium0650();
        System.out.println(main.minSteps(2));
        System.out.println(main.minSteps(3));
        System.out.println(main.minSteps(4));
        System.out.println(main.minSteps(5));
        System.out.println(main.minSteps(6));
        System.out.println(main.minSteps(8));
    }
}