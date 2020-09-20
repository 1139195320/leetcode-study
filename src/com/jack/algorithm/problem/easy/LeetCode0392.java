package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0392 {

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = t.indexOf(c);
            if (index == -1 || n - i > t.length() - index) {
                return false;
            }
            t = t.substring(index + 1);
        }
        return true;
    }

    public boolean isSubsequence2(String s, String t) {
        // 父
        int n = t.length();
        // 子
        int m = s.length();
        if (m == 0) {
            return true;
        }
        if (n < m) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < n && j < m && n - i >= m - j) {
            if (t.charAt(i) == s.charAt(j)) {
                j ++;
            }
            if (j == m) {
                return true;
            }
            i ++;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0392 main = new LeetCode0392();
        System.out.println(main.isSubsequence(
                "abc", "ahbgdc"
        ));
        System.out.println(main.isSubsequence(
                "axc", "ahbgdc"
        ));
    }
}