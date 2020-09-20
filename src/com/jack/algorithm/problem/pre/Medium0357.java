package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0357 {

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int k = 9;
            int tmp = 1;
            for (int j = 1; j < i; j++) {
                tmp *= k;
                k -= 1;
            }
            dp[i] = dp[i - 1] + tmp * 9;
        }
        return dp[n];
    }

    public int countNumbersWithUniqueDigits2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 10;
        int multiple = 9;
        int tmp = 9;
        for (int i = 2; i <= n; i++) {
            tmp *= multiple;
            dp[i] = tmp + dp[i - 1];
            multiple --;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Medium0357 main = new Medium0357();
        System.out.println(main.countNumbersWithUniqueDigits(1));
        System.out.println(main.countNumbersWithUniqueDigits(2));
        System.out.println(main.countNumbersWithUniqueDigits(3));
        System.out.println(main.countNumbersWithUniqueDigits(4));
    }
}