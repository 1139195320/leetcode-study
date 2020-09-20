package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0214 {

    public String shortestPalindrome(String s) {
        int n = s.length();
        int base = 131, MOD = 1_000_000_007;
        int left = 0, right = 0, mul = 1;
        int best = -1;
        for (int i = 0; i < n; i++) {
            left = (int) (((long) left * base + s.charAt(i)) % MOD);
            right = (int) ((right + (long) mul * s.charAt(i)) % MOD);
            if (left == right) {
                best = i;
            }
            mul = (int) ((long) mul * base % MOD);
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuilder sb = new StringBuilder(add).reverse();
        sb.append(s);
        return sb.toString();
    }

    public String shortestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        // 找出 s 前面的最长的回文串
        int tIdx = 0;
        for (int i = n - 1; i > 0; i--) {
            if (isPalindrome(arr, i)) {
                tIdx = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(tIdx + 1))
                .reverse().append(s);
        return sb.toString();
    }
    private boolean isPalindrome(char[] arr, int r) {
        if (arr.length < 2) {
            return true;
        }
        int l = 0;
        while (l < r) {
            if (arr[l ++] != arr[r --]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0214 main = new LeetCode0214();
        System.out.println(main.shortestPalindrome("aab"));
        System.out.println(main.shortestPalindrome("abcd"));
    }

}