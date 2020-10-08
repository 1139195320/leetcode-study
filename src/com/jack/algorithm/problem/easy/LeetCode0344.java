package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0344 {

    public void reverseString(char[] s) {
        int r = s.length - 1, l = 0;
        while (l < r) {
            swap(s, l ++, r --);
        }
    }
    private void swap(char[] s, int x, int y) {
        char t = s[x];
        s[x] = s[y];
        s[y] = t;
    }
}
