package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0647 {

    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] == arr[j + i]) {
                    dp[j][j + i] = i <= 1 || dp[j + 1][j + i - 1];
                    if (dp[j][j + i]) {
                        res ++;
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings2(String s) {
        int n = s.length();
        int res = 0;
        char[] arr = s.toCharArray();
        // 使用 n * 2 - 1 往下除 2 可以包含奇数和偶数数量的情况
        for (int i = 0; i < (n * 2 - 1); i++) {
            int l = i >> 1;
            int r = (i >> 1) + (i & 1);
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                l --;
                r ++;
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0647 main = new LeetCode0647();
        System.out.println(main.countSubstrings("abc"));
        System.out.println(main.countSubstrings("aaa"));
        System.out.println(main.countSubstrings("aabaaba"));
        System.out.println(main.countSubstrings("a"));
        System.out.println(main.countSubstrings("ab"));
    }
}