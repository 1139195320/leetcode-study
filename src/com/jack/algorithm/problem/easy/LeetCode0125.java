package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !isValid(s.charAt(l))) {
                l ++;
            }
            if (l == r) {
                break;
            }
            while (l < r && !isValid(s.charAt(r))) {
                r --;
            }
            if (l == r) {
                break;
            }
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);
            if (Character.isDigit(c1) || Character.isDigit(c2)) {
                if (c1 != c2) {
                    return false;
                }
            } else {
                int dif = Math.abs(c1 - c2);
                if (dif != 0 && dif != 32) {
                    return false;
                }
            }
            l ++;
            r --;
        }
        return true;
    }
    private boolean isValid(char c) {
        return Character.isDigit(c)
                || (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z');
    }
}