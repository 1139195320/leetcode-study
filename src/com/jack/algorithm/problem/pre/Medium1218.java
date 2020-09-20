package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] - arr[j] == difference) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Medium1218 main = new Medium1218();
        System.out.println(main.longestSubsequence(
                new int[] {1, 2, 3, 4}, 1
        ));
        System.out.println(main.longestSubsequence(
                new int[]{1, 3, 5, 7}, 1
        ));
        System.out.println(main.longestSubsequence(
                new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2
        ));
    }
}