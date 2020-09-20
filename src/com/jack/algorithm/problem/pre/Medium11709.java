package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium11709 {

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        int[] arr = new int[]{3, 5, 7};
        int[] p = new int[]{0, 0, 0};
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = arr[0] * dp[p[0]];
            for (int j = 1; j < arr.length; j++) {
                int cur = arr[j] * dp[p[j]];
                if (cur < dp[i]) {
                    dp[i] = cur;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                int cur = arr[j] * dp[p[j]];
                if (dp[i] == cur) {
                    p[j] ++;
                }
            }
        }
        return dp[k - 1];
    }

    public static void main(String[] args) {
        Medium11709 main = new Medium11709();
        System.out.println(main.getKthMagicNumber(3));
        System.out.println(main.getKthMagicNumber(4));
        System.out.println(main.getKthMagicNumber(5));
        System.out.println(main.getKthMagicNumber(6));
        System.out.println(main.getKthMagicNumber(7));
    }
}