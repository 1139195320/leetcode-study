package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0455 {

    public int findContentChildren(int[] g, int[] s) {
        // g 孩子，s 饼干
        int n = g.length;
        int m = s.length;
        if (n == 0 || m == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (g[i] <= s[j]) {
                i ++;
            }
            j ++;
        }
        return i;
    }

    public static void main(String[] args) {
        LeetCode0455 main = new LeetCode0455();
        System.out.println(main.findContentChildren(
                new int[] {1, 2, 3}, new int[] {1, 1}
        ));
        System.out.println(main.findContentChildren(
                new int[] {1, 2}, new int[] {1, 2, 3}
        ));
    }
}