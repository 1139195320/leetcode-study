package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0680 {

    public boolean validPalindrome(String s) {
        boolean res = s.length() <= 2 || doValidPalindrome(s);
        if (!res) {
            for (int i = 0; i < s.length(); i++) {
                res = doValidPalindrome(s.substring(0, i) + s.substring(i + 1));
                if (res) {
                    break;
                }
            }
        }
        return res;
    }
    private boolean doValidPalindrome(String s) {
        int len = s.length();
        int l = 0;
        int r = len -1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l ++;
                r --;
            } else {
                boolean res1 = true;
                boolean res2 = true;
                for (int i = l, j = r - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        res1 = false;
                        break;
                    }
                }
                if (res1) {
                    break;
                }
                for (int i = l + 1, j = r; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        res2 = false;
                        break;
                    }
                }
                return res2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0680 main = new LeetCode0680();
        System.out.println(main.validPalindrome(""));
        System.out.println(main.validPalindrome("a"));
        System.out.println(main.validPalindrome("ab"));
        System.out.println(main.validPalindrome("aba"));
        System.out.println(main.validPalindrome("abca"));
        System.out.println(main.validPalindrome("abcab"));
        System.out.println(main.validPalindrome("abcaba"));
        System.out.println("===========================");
        System.out.println(main.validPalindrome2(""));
        System.out.println(main.validPalindrome2("a"));
        System.out.println(main.validPalindrome2("ab"));
        System.out.println(main.validPalindrome2("aba"));
        System.out.println(main.validPalindrome2("abca"));
        System.out.println(main.validPalindrome2("abcab"));
        System.out.println(main.validPalindrome2("abcaba"));
    }
}
